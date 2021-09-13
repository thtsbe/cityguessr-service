package ch.ttt.cityguessrservice.cities;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CitiesService {
    private final CityRepository repository;

    public City getRandomCity() {
        return new City(
                1,
                "New York",
                "40.6943",
                "-73.9249",
                "United States",
                18713220,
                10934);
    }
}
