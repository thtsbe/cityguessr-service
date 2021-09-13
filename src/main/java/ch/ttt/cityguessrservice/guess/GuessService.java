package ch.ttt.cityguessrservice.guess;

import ch.ttt.cityguessrservice.answer.GuessAnswer;
import ch.ttt.cityguessrservice.cities.CitiesService;
import ch.ttt.cityguessrservice.cities.City;
import ch.ttt.cityguessrservice.result.GuessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GuessService {
    private final GuessRepository repository;
    private final CitiesService citiesService;

    public Mono<Guess> createGuess() {
        final City randomCity = citiesService.getRandomCity();
        final Guess guess = new Guess(
                UUID.randomUUID(),
                randomCity.getLat(),
                randomCity.getLng(),
                "New York",
                "Manila",
                "Weissenstein",
                "Solothurn"
        );

        // save guess
        // save guessresult
        return Mono.just(guess);
    }

    public Mono<GuessResult> checkAnswer(final GuessAnswer answer) {
        // save answer
        return Mono.just(new GuessResult(
                answer.getGuessId(),
                answer.getAnswer(),
                "New York"));
    }
}
