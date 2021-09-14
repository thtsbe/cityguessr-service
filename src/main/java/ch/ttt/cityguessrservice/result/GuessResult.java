package ch.ttt.cityguessrservice.result;

import lombok.Value;

import java.util.UUID;

@Value
public class GuessResult {
    UUID guessId;
    UUID answerCityId;
    UUID correctCityId;
}
