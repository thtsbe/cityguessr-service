package ch.ttt.cityguessrservice.scores;

import ch.ttt.cityguessrservice.cities.City;
import ch.ttt.cityguessrservice.cities.CityRepository;
import ch.ttt.cityguessrservice.guess.GuessRepository;
import ch.ttt.cityguessrservice.guessanswer.GuessAnswer;
import ch.ttt.cityguessrservice.guessanswer.GuessAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/scores")
@RequiredArgsConstructor
public class ScoreController {
    private final GuessRepository guessRepository;
    private final GuessAnswerRepository answerRepository;
    private final CityRepository cityRepository;


    @GetMapping
    public Scores getScores() {
        final List<Score> scores = StreamSupport.stream(guessRepository.findAll().spliterator(), false)
                .map(g -> new Score(getAnswer(g.getId()), g.getCity()))
                .collect(Collectors.toList());

        return new Scores(
                "username",
                scores.size(),
                calculateCorrect(scores));
    }

    private long calculateCorrect(final List<Score> scores) {
        return scores.stream()
                .filter(s -> s.getCorrect().equals(s.getAnswer()))
                .count();
    }

    private City getAnswer(final UUID id) {
        return answerRepository.findById(id)
                .map(GuessAnswer::getCityId)
                .flatMap(cityRepository::findById)
                .orElse(null);
    }

}
