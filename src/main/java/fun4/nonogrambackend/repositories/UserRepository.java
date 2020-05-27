package fun4.nonogrambackend.repositories;

import org.springframework.data.repository.CrudRepository;

import fun4.nonogrambackend.domain.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByName(String name);
}
