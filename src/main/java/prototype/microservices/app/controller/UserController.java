package prototype.microservices.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import prototype.microservices.app.models.entities.UserEntity;
import prototype.microservices.app.services.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        log.info("UserController: Request to fetch all users");
        Optional<List<UserEntity>> allUsers = userService.getAllUsers();
        return allUsers.map(userEntities -> new ResponseEntity<>(userEntities, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(Collections.emptyList(), HttpStatus.FOUND));
    }
}
