package ch.ttt.cityguessrservice.scores;

import lombok.Value;

@Value
public class Score {
    String city;
    boolean answeredCorrectly;
    int attempts;
}
