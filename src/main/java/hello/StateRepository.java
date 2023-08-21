package hello;

import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State,Integer> {

}
