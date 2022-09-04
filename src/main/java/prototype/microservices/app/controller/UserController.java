package prototype.microservices.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import prototype.microservices.app.models.dtos.UserDto;

@RestController
@Slf4j
public class UserController {


    @GetMapping("/users")
    public ResponseEntity<UserDto> getAllUsers() {
        return new ResponseEntity<>(new UserDto(), HttpStatus.FOUND);
    }
}
