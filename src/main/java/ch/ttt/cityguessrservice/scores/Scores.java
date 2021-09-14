package ch.ttt.cityguessrservice.scores;

import lombok.Value;

import java.util.List;

@Value
public class Scores {
    String username;
    int totalGames;
    int points;
    List<Score> scores;
}
