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

    public List<City> getRandomCities(final int size) {
        final List<City> cities = repository.findAllByPopulationGreaterThan(2_000_000).stream()
                .filter(c -> !c.getCountry().equals("China"))
                .collect(Collectors.toList());
        Collections.shuffle(cities);
        return cities.stream()
                .limit(size)
                .collect(Collectors.toList());
    }
}
