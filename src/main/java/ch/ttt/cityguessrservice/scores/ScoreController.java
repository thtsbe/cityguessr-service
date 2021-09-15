package ch.ttt.cityguessrservice.scores;

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
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/scores")
@RequiredArgsConstructor
public class ScoreController {
    private final GuessAnswerRepository answerRepository;
    private final CheckinRepository checkinRepository;

    @GetMapping
    public List<Score> getScores() {
        final Map<UUID, List<GuessAnswer>> correctAnswersByUserId = StreamSupport.stream(answerRepository.findAll().spliterator(), false)
                .filter(g -> g.getUserId() != null)
                .collect(Collectors.groupingBy(GuessAnswer::getUserId));

        return correctAnswersByUserId.entrySet().stream()
                .map(e -> new Score(
                        getUsername(e.getKey()),
                        e.getValue().size(),
                        sumScore(e.getValue())
                ))
                .collect(Collectors.toList());
    }

    private Integer sumScore(final List<GuessAnswer> e) {
        return e.stream()
                .map(GuessAnswer::getScore)
                .reduce(0, Integer::sum);
    }

    private String getUsername(final UUID userId) {
        return checkinRepository
                .findById(userId)
                .map(Checkin::getUsername)
                .orElse("unknown");
    }
}
