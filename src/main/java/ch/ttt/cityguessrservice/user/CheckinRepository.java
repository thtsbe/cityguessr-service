package ch.ttt.cityguessrservice.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CheckinRepository extends CrudRepository<Checkin, UUID> {
}
