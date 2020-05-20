package fun4.nonogrambackend.controllers;

import fun4.nonogrambackend.domain.Nonogram;
import fun4.nonogrambackend.repositories.UserRepository;
import fun4.nonogrambackend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @PostMapping(path="/add")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @CrossOrigin
    @GetMapping(path="/login")
    public ResponseEntity<?> LoginUser(@Valid @RequestBody User user) {
        Optional<User> gottenUser =  userRepository.findByName(user.getName());

        if (gottenUser.isPresent()) return ResponseEntity.ok(user);
        return ResponseEntity.status(404).body("User not found");
    }
}
