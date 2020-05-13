package fun4.nonogrambackend.controllers;

import fun4.nonogrambackend.domain.HintSideValue;
import fun4.nonogrambackend.domain.HintTopValue;
import fun4.nonogrambackend.repositories.HintSideValueRepository;
import fun4.nonogrambackend.repositories.HintTopValueRepository;
import fun4.nonogrambackend.repositories.NonogramRepository;
import fun4.nonogrambackend.domain.Nonogram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping(path="/nonogram")
public class NonogramController {
    @Autowired
    private NonogramRepository nonogramRepository;
    @Autowired
    private HintSideValueRepository hintSideValueRepository;
    @Autowired
    private HintTopValueRepository hintTopValueRepository;

    private final long id = 1;
    private final int[][] topRow = new int[][] { {1}, {5}, {2}, {5}, {2, 1}, {2}};
    private final int[][] sideRow = new int[][] { {2, 1}, {1, 3}, {1, 2}, {3}, {4}, {1}};
    
    @CrossOrigin
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
