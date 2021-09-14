package ch.ttt.cityguessrservice.guessanswer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@NoArgsConstructor
public class GuessAnswer {
    UUID guessId;
    UUID cityId;
    UUID userId;

    @JsonCreator
    public GuessAnswer(@JsonProperty("guessId") final UUID guessId,
                       @JsonProperty("cityId") final UUID cityId,
                       @JsonProperty("userId") final UUID userId) {
        this.guessId = guessId;
        this.cityId = cityId;
        this.userId = userId;
    }
}
