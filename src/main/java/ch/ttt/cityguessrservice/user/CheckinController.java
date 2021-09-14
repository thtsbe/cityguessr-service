package ch.ttt.cityguessrservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/checkin")
@RequiredArgsConstructor
public class CheckinController {
    private final CheckinRepository repository;

    @PostMapping
    public UUID checkin(@RequestBody final CheckinRequest checkinRequest) {
        final UUID userid = UUID.randomUUID();
        repository.save(new Checkin(userid, checkinRequest.getUsername()));
        return userid;
    }

}
