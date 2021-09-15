package ch.ttt.cityguessrservice.scores;

import lombok.Value;

@Value
public class Score {
    String username;
    int totalGames;
    int points;
}
