package app.infrastructure.database;

import app.domain.entity.District;
import org.springframework.data.repository.CrudRepository;

public interface DistrictRepository extends CrudRepository<District,Integer> {

}
