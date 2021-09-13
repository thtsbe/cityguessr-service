package ch.ttt.cityguessrservice.cities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    private Long id;
    private String name;
    private String lat;
    private String lng;
    private String country;
    private long population;
    private double density;
}
