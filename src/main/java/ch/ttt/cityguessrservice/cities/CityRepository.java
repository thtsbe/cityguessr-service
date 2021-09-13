package ch.ttt.cityguessrservice.cities;

import ch.ttt.cityguessrservice.guess.Guess;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepository  extends ReactiveMongoRepository<City, Integer> {
}
