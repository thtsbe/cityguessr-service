package ch.ttt.cityguessrservice.cities;

import lombok.Value;

@Value
public class City {
    String city;
    String lat;
    String lng;
    String country;
    long population;
    double density;
}
