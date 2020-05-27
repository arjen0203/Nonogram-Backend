package fun4.nonogrambackend.controllers;

import fun4.nonogrambackend.domain.Nonogram;
import fun4.nonogrambackend.repositories.UserRepository;
import fun4.nonogrambackend.domain.User;
import fun4.nonogrambackend.services.UserService;
import fun4.nonogrambackend.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path="/user")
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserValidator userValidator, UserRepository userRepository) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.userRepository = userRepository;
    }

    @CrossOrigin
    @PostMapping(path="/add")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User user) {
        var result = userValidator.validate(user);
        if (result.isSuccess()) {
            userService.registerUser(user);
            return ResponseEntity.ok("Successfully registered user");
        }

        return ResponseEntity.status(422).body(result.getMessage());
    }

    @CrossOrigin
    @GetMapping(path="/login")
    public ResponseEntity<?> LoginUser(@Valid @RequestBody User user) {
        Optional<User> gottenUser =  userRepository.findByUsername(user.getUsername());

        if (gottenUser.isPresent()) return ResponseEntity.ok(user);
        return ResponseEntity.status(404).body("User not found");
    }
}
