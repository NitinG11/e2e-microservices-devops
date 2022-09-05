package prototype.microservices.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prototype.microservices.app.models.entities.UserEntity;
import prototype.microservices.app.repositories.UserRepository;
import prototype.microservices.app.services.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<List<UserEntity>> getAllUsers() {
        return Optional.of(userRepository.findAll());
    }

    @Override
    public Optional<UserEntity> addUser(UserEntity user) {
        return Optional.of(userRepository.saveAndFlush(user));
    }

    @Override
    public boolean deleteUser(UserEntity user) {
        userRepository.delete(user);
        if(userRepository.findByIdentificationNumber(user.getIdentificationNumber()).isPresent())
            return false;
        return true;
    }

    @Override
    public Optional<UserEntity> updateUser(UserEntity user) {
        return Optional.empty();
    }
}
