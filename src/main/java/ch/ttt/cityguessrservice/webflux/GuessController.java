package ch.ttt.cityguessrservice.webflux;

import ch.ttt.cityguessrservice.answer.GuessAnswer;
import ch.ttt.cityguessrservice.guess.GuessService;
import ch.ttt.cityguessrservice.result.GuessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/guess")
@RequiredArgsConstructor
public class GuessController {
    private final GuessService service;

    @GetMapping
    private Mono<GuessDTO> createGuess() {
        return service.createGuess();
    }

    @PostMapping
    private Mono<GuessResult> answer(@RequestBody final GuessAnswer answer) {
        return service.checkAnswer(answer);
    }
}
