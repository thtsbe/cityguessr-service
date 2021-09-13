package ch.ttt.cityguessrservice.cities;

import org.springframework.stereotype.Service;

@Service
public class CitiesService {

    public City getRandomCity() {
        return new City(
                "New York",
                "40.6943",
                "-73.9249",
                "United States",
                18713220,
                10934);
    }
}
