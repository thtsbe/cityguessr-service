package ch.ttt.cityguessrservice.guess;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuessRepository extends CrudRepository<Guess, UUID> {

}
