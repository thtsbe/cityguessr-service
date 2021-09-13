package ch.ttt.cityguessrservice.cities;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CitiesService {
    private final CityRepository repository;

    public Mono<City> getRandomCity() {
        return repository.count()
                .flatMap(count -> {
                    long leftLimit = 1L;
                    long rightLimit = count;
                    long id = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
                    return repository.findById(id);
                });
    }

    public Flux<City> getRandomCities(final int size) {
        return repository.count()
                .map(max -> new Random()
                        .longs(size, 1L, max)
                        .boxed()
                        .collect(Collectors.toList()))
                .flatMapMany(repository::findAllById);

    }
}
