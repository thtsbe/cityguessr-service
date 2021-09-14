package ch.ttt.cityguessrservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/checkin")
@RequiredArgsConstructor
public class CheckinController {
    private final CheckinRepository repository;

    @PostMapping("/{username}")
    public UUID checkin(@PathVariable final String username) {
        final UUID userid = UUID.randomUUID();
        repository.save(new Checkin(userid, username));
        return userid;
    }

}
