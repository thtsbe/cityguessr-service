package ch.ttt.cityguessrservice.guess;

import lombok.Value;

import java.util.UUID;

@Value
public class Guess {
    UUID id;
    String lat;
    String lng;
    String option1;
    String option2;
    String option3;
    String option4;
    // user id
}
