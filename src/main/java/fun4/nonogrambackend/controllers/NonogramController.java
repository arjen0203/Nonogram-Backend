package fun4.nonogrambackend.controllers;

import fun4.nonogrambackend.repositories.HintSideValueRepository;
import fun4.nonogrambackend.repositories.HintTopValueRepository;
import fun4.nonogrambackend.repositories.NonogramRepository;
import fun4.nonogrambackend.domain.Nonogram;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path="/nonogram")
public class NonogramController {
    private final NonogramRepository nonogramRepository;


    public NonogramController(NonogramRepository nonogramRepository) {
        this.nonogramRepository = nonogramRepository;
    }

    @CrossOrigin
    @Transactional
    @PostMapping(path="/add")
    public ResponseEntity<?> addNewNonogram(@Valid @RequestBody Nonogram nonogram) {
        nonogramRepository.save(nonogram);
        return ResponseEntity.ok(nonogram);
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
