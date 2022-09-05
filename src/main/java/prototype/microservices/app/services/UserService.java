package prototype.microservices.app.services;

import prototype.microservices.app.models.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<List<UserEntity>> getAllUsers();
    Optional<UserEntity> addUser(UserEntity user);
    boolean deleteUser(UserEntity user);
    Optional<UserEntity> updateUser(UserEntity user);
}
