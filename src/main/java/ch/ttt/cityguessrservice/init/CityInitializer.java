package ch.ttt.cityguessrservice.init;

import ch.ttt.cityguessrservice.cities.City;
import ch.ttt.cityguessrservice.cities.CityRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CityInitializer implements CommandLineRunner {
    private final CityRepository repository;
    private final ObjectMapper objectMapper;

    @Value("classpath:worldcities.json")
    Resource resourceFile;


    @Override
    public void run(final String... args) throws Exception {
        if (count() > 0) {
            return;
        }

        final List<CityImportDTO> jsonCities = objectMapper.readValue(resourceFile.getFile(), new TypeReference<>() {});
        final AtomicInteger index = new AtomicInteger(0);

        final List<City> cities = jsonCities.stream()
                .map(c -> new City(
                        index.incrementAndGet(),
                        c.getCity(),
                        c.getLat(),
                        c.getLng(),
                        c.getCountry(),
                        c.getPopulation(),
                        c.getDensity()
                )).collect(Collectors.toList());

        repository.saveAll(cities).blockLast();
    }

    private Long count() {
        return repository.count().block();
    }
}
