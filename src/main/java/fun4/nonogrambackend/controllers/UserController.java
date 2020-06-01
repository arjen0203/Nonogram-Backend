package fun4.nonogrambackend.controllers;

import com.auth0.jwt.JWT;
import fun4.nonogrambackend.domain.Nonogram;
import fun4.nonogrambackend.repositories.UserRepository;
import fun4.nonogrambackend.domain.User;
import fun4.nonogrambackend.security.JWTAuthenticationFilter;
import fun4.nonogrambackend.security.JWTAuthorizationFilter;
import fun4.nonogrambackend.services.UserDetailsServiceImpl;
import fun4.nonogrambackend.services.UserService;
import fun4.nonogrambackend.validators.UserValidator;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @GetMapping("/profile")
    public ResponseEntity<?> getMe(@RequestHeader("Authorization") String token) {
        token = token.replace("Bearer ", "");
        String decodedToken = new String(Base64.decodeBase64(JWT.decode(token).getPayload()));
        try {
            JSONObject json = new JSONObject(decodedToken);
            String username = json.get("sub").toString();
            Optional<User> user = userRepository.findByUsername(username);
            if (user.isEmpty()) return ResponseEntity.status(404).body("User not found");
            return ResponseEntity.ok(user.get());
        } catch (JSONException e) {
            return ResponseEntity.status(403).body("Unauthorized request");
        }
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
}
