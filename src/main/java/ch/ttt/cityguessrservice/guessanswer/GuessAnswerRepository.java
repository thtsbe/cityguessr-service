package ch.ttt.cityguessrservice.guessanswer;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GuessAnswerRepository extends CrudRepository<GuessAnswer, UUID> {
}
