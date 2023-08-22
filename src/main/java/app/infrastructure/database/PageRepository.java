package app.infrastructure.database;

import app.domain.entity.Page;
import org.springframework.data.repository.CrudRepository;

public interface PageRepository extends CrudRepository<Page,Integer> {

}
