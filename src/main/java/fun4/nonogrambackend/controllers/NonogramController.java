package fun4.nonogrambackend.controllers;

import com.auth0.jwt.JWT;
import fun4.nonogrambackend.domain.User;
import fun4.nonogrambackend.repositories.HintSideValueRepository;
import fun4.nonogrambackend.repositories.HintTopValueRepository;
import fun4.nonogrambackend.repositories.NonogramRepository;
import fun4.nonogrambackend.domain.Nonogram;
import fun4.nonogrambackend.repositories.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path="/nonogram")
public class NonogramController {
    private final NonogramRepository nonogramRepository;
    private final UserRepository userRepository;

    public NonogramController(NonogramRepository nonogramRepository, UserRepository userRepository) {
        this.nonogramRepository = nonogramRepository;
        this.userRepository = userRepository;
    }

    @CrossOrigin
    @Transactional
    @PostMapping(path="/add")
    public ResponseEntity<?> addNewNonogram(@RequestHeader("Authorization") String token, @Valid @RequestBody Nonogram nonogram) {
        token = token.replace("Bearer ", "");
        String decodedToken = new String(Base64.decodeBase64(JWT.decode(token).getPayload()));
        try {
            JSONObject json = new JSONObject(decodedToken);
            String username = json.get("sub").toString();
            Optional<User> user = userRepository.findByUsername(username);
            if (user.isEmpty()) return ResponseEntity.status(404).body("User not found");
            nonogram.setUser(user.get());
            nonogramRepository.save(nonogram);
            return ResponseEntity.ok(nonogram);
        } catch (JSONException e) {
            return ResponseEntity.status(403).body("Unauthorized request");
        }
    }

    @CrossOrigin
    @GetMapping("/get")
    public ResponseEntity<?> nonogram(@RequestParam int id) {
        var nonogram = nonogramRepository.findById(id);
        if (nonogram.isPresent()) {
            return ResponseEntity.ok(nonogram.get());
        }
        return ResponseEntity.status(404).body("Nonogram not found");
    }
}
