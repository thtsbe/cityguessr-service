package ch.ttt.cityguessrservice.webflux;

import ch.ttt.cityguessrservice.cities.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Value
public class GuessDTO {
    @Id
    UUID id;
    String lat;
    String lng;
    String option1;
    String option2;
    String option3;
    String option4;
}
