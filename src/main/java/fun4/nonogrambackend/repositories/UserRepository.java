package fun4.nonogrambackend.repositories;

import org.springframework.data.repository.CrudRepository;

import fun4.nonogrambackend.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
