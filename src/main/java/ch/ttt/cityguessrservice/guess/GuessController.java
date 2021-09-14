package ch.ttt.cityguessrservice.guess;

import ch.ttt.cityguessrservice.guessanswer.GuessAnswer;
import ch.ttt.cityguessrservice.result.GuessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/guess")
@RequiredArgsConstructor
public class GuessController {
    private final GuessService service;

    @GetMapping("/{userId}")
    public GuessDTO createGuess(@PathVariable final UUID userId) {
        return service.createGuess(userId);
    }

    @PostMapping
    public GuessResult answer(@RequestBody final GuessAnswer answer) {
        return service.checkAnswer(answer);
    }
}
