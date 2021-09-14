package ch.ttt.cityguessrservice.guess;

import ch.ttt.cityguessrservice.guessanswer.GuessAnswer;
import ch.ttt.cityguessrservice.cities.CitiesService;
import ch.ttt.cityguessrservice.cities.City;
import ch.ttt.cityguessrservice.guessanswer.GuessAnswerRepository;
import ch.ttt.cityguessrservice.result.GuessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GuessService {
    private final GuessRepository repository;
    private final GuessAnswerRepository guessAnswerRepository;
    private final CitiesService citiesService;

    public GuessDTO createGuess() {
        final List<City> randomCities = citiesService.getRandomCities(4);

        final UUID guessId = UUID.randomUUID();
        final City city = pickRandom(randomCities);

        repository.save(new Guess(guessId, city));

        return new GuessDTO(
                guessId,
                city.getLat(),
                city.getLng(),
                randomCities);
    }

    private City pickRandom(final List<City> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

    public GuessResult checkAnswer(final GuessAnswer answer) {
        guessAnswerRepository.save(answer);
        return repository.findById(answer.getGuessId())
                .map(g -> new GuessResult(
                        answer.getGuessId(),
                        answer.getCityId(),
                        g.getCity().getId())
                ).orElseThrow();
    }
}
