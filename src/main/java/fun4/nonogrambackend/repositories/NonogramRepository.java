package fun4.nonogrambackend.repositories;

import fun4.nonogrambackend.domain.Nonogram;
import org.springframework.data.repository.CrudRepository;


public interface NonogramRepository extends CrudRepository<Nonogram, Integer> {

}
