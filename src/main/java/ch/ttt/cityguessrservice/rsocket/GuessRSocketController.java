package ch.ttt.cityguessrservice.rsocket;

import ch.ttt.cityguessrservice.guess.Guess;
import ch.ttt.cityguessrservice.guess.GuessService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class GuessRSocketController {
    private final GuessService service;

    @MessageMapping("guess")
    public Mono<Guess> getGuess() {
        return service.createGuess();
    }
}
