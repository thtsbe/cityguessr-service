package ch.ttt.cityguessrservice.cities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    List<City> findAllByPopulationGreaterThan(int minPopulation);
}
