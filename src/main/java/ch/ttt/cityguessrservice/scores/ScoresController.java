package ch.ttt.cityguessrservice.scores;

import ch.ttt.cityguessrservice.guess.Guess;
import ch.ttt.cityguessrservice.guess.GuessRepository;
import ch.ttt.cityguessrservice.guessanswer.GuessAnswer;
import ch.ttt.cityguessrservice.guessanswer.GuessAnswerRepository;
import ch.ttt.cityguessrservice.user.Checkin;
import ch.ttt.cityguessrservice.user.CheckinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/scores")
@RequiredArgsConstructor
public class ScoresController {
    private final GuessRepository guessRepository;
    private final GuessAnswerRepository answerRepository;
    private final CheckinRepository checkinRepository;

    @GetMapping
    public List<Scores> getScores() {
        return scoresByUser();
    }

    private List<Scores> scoresByUser() {
        return getGuessesByUser().entrySet().stream()
                .map(e -> createScore(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    private Map<UUID, List<Guess>> getGuessesByUser() {
        return StreamSupport.stream(guessRepository.findAll().spliterator(), false)
                .filter(g -> g.getUserId() != null)
                .collect(Collectors.groupingBy(Guess::getUserId));
    }

    private Scores createScore(final UUID userId, final List<Guess> guesses) {
        final List<Score> scores = createScores(guesses);
        return new Scores(
                getUsername(userId),
                scores.size(),
                calculatePoints(scores),
                scores
        );
    }

    private List<Score> createScores(final List<Guess> guesses) {
        return guesses.stream()
                .map(this::mapToScore)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private String getUsername(final UUID userId) {
        return checkinRepository
                .findById(userId)
                .map(Checkin::getUsername)
                .orElse("unknown");
    }

    private int calculatePoints(final List<Score> scores) {
        return scores.stream()
                .map(s -> {
                    if (s.getAttempts() == 0) {
                        return 0;
                    }
                    if (!s.isAnsweredCorrectly()) {
                        return 0;
                    }
                    if (s.getAttempts() == 1) {
                        return 3;
                    }
                    if (s.getAttempts() == 2) {
                        return 2;
                    }
                    if (s.getAttempts() == 3) {
                        return 1;
                    }
                    return 0;
                }).reduce(Integer::sum)
                .orElse(0);
    }

    private Score mapToScore(final Guess guess) {
        final List<GuessAnswer> answers = answerRepository.findAllByGuessId(guess.getId());
        if (answers.isEmpty()){
            return null;
        }
        return new Score(
                guess.getCity().getCity(),
                answers.stream().anyMatch(a -> guess.getCity().getId().equals(a.getCityId())),
                answers.size());
    }
}
