package ch.ttt.cityguessrservice.scores;

import ch.ttt.cityguessrservice.cities.City;
import lombok.Value;

@Value
public class Score {
    City answer;
    City correct;
}
