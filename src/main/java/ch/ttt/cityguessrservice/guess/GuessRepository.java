package ch.ttt.cityguessrservice.guess;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuessRepository extends ReactiveMongoRepository<Guess, UUID> {

}
