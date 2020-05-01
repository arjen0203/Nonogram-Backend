package fun4.nonogrambackend.Repositories;

import fun4.nonogrambackend.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

}
