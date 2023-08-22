package app.infrastructure.database;

import app.domain.entity.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State,Integer> {

}
