package ch.ttt.cityguessrservice.cities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    private UUID id;
    private String city;
    private String lat;
    private String lng;
    private String country;
    private long population;
    private double density;
}
