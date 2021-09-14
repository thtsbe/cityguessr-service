package ch.ttt.cityguessrservice.guess;

import ch.ttt.cityguessrservice.guessanswer.GuessAnswer;
import ch.ttt.cityguessrservice.result.GuessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guess")
@RequiredArgsConstructor
public class GuessController {
    private final GuessService service;

    @GetMapping
    private GuessDTO createGuess() {
        return service.createGuess();
    }

    @PostMapping
    private GuessResult answer(@RequestBody final GuessAnswer answer) {
        return service.checkAnswer(answer);
    }
}
