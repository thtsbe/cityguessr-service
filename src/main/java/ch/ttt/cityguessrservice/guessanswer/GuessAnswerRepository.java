package ch.ttt.cityguessrservice.guessanswer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface GuessAnswerRepository extends CrudRepository<GuessAnswer, UUID> {
    List<GuessAnswer> findAllByGuessId(UUID guessId);
}
