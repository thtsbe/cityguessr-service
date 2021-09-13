package ch.ttt.cityguessrservice.rsocket;

import ch.ttt.cityguessrservice.guess.GuessService;
import ch.ttt.cityguessrservice.webflux.GuessDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class GuessRSocketController {
    private final GuessService service;

    @MessageMapping("guess")
    public Mono<GuessDTO> getGuess() {
        return service.createGuess();
    }
}
