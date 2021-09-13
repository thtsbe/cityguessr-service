package ch.ttt.cityguessrservice.init;

import lombok.Data;

@Data
public class CityImportDTO {
    private String city;
    private String lat;
    private String lng;
    private String country;
    private long population;
    private double density;
}
