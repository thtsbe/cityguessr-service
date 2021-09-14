package ch.ttt.cityguessrservice.scores;

import lombok.Value;

@Value
public class Scores {
    String username;
    long total;
    long correct;
}
