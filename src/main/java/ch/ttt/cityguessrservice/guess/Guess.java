package ch.ttt.cityguessrservice.guess;

import ch.ttt.cityguessrservice.cities.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guess {
    private UUID id;
    private City city;
}
