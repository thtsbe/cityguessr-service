package ch.ttt.cityguessrservice.cities;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CitiesService {
    private final CityRepository repository;

    private static final int MIN_POPULATION = 1_000_000;

    public List<City> getRandomCities(final int size) {
        final List<City> cities = repository.findAllByPopulationGreaterThan(MIN_POPULATION);
        Collections.shuffle(cities);
        return cities.stream()
                .limit(size)
                .collect(Collectors.toList());
    }
}
