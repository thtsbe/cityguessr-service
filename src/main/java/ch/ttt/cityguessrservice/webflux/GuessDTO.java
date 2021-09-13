package ch.ttt.cityguessrservice.webflux;

import lombok.Value;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Value
public class GuessDTO {
    @Id
    UUID id;
    String lat;
    String lng;
    List<String> options;
}
