package ch.ttt.cityguessrservice.answer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.UUID;

@Value
public class GuessAnswer {
    UUID guessId;
    String answer;

    @JsonCreator
    public GuessAnswer(@JsonProperty("guessId") final UUID guessId,
                       @JsonProperty("answer") final String answer) {
        this.guessId = guessId;
        this.answer = answer;
    }
}
