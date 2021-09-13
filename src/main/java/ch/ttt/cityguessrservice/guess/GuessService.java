package ch.ttt.cityguessrservice.guess;

import ch.ttt.cityguessrservice.answer.GuessAnswer;
import ch.ttt.cityguessrservice.cities.CitiesService;
import ch.ttt.cityguessrservice.cities.City;
import ch.ttt.cityguessrservice.result.GuessResult;
import ch.ttt.cityguessrservice.webflux.GuessDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuessService {
    private final GuessRepository repository;
    private final CitiesService citiesService;

    public Mono<GuessDTO> createGuess() {
        final Flux<City> randomCities = citiesService.getRandomCities(4);

        final Mono<List<City>> collect = randomCities.collect(Collectors.toList());

        return collect
                .map(e -> new Guess(UUID.randomUUID(), pickRandom(e)))
                .map(repository::save)
                .zipWith(collect)
                .flatMap(tuple -> tuple.getT1()
                        .map(e -> new GuessDTO(
                                e.getId(),
                                e.getCity().getLat(),
                                e.getCity().getLng(),
                                tuple.getT2().stream().map(City::getName)
                                        .collect(Collectors.toList()))));
    }

    private City pickRandom(final List<City> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

    public Mono<GuessResult> checkAnswer(final GuessAnswer answer) {
        // save answer
        return Mono.just(new GuessResult(
                answer.getGuessId(),
                answer.getAnswer(),
                "New York"));
    }
}
