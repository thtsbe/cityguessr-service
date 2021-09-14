package ch.ttt.cityguessrservice.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class CheckinRequest {
    String username;

    @JsonCreator
    public CheckinRequest(@JsonProperty("username") final String username) {
        this.username = username;
    }
}
