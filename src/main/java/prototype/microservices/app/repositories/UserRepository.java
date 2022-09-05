package prototype.microservices.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prototype.microservices.app.models.entities.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    List<UserEntity> findAll();
    UserEntity saveAndFlush(UserEntity userEntity);

    Optional<UserEntity> findByIdentificationNumber(String identificationNumber);
}
