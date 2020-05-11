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

import java.util.ArrayList;
import java.util.Optional;

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
    private final int[][] topRow = new int[][] { {1}, {5}, {2}, {5}, {2, 1}, {2}, {0} };
    private final int[][] sideRow = new int[][] { {2, 1}, {1, 3}, {1, 2}, {3}, {4}, {1}, {0}};

    @CrossOrigin
    @GetMapping(path="/add")
    public @ResponseBody String addNewNonogram() {
        Nonogram n = new Nonogram();
        ArrayList<HintSideValue> sideValues = new ArrayList<>();
        ArrayList<HintTopValue> topValues = new ArrayList<>();

        for (int x = 0; x < topRow.length; x++) {
            for (int y = 0; y < topRow[x].length; y++){
                HintTopValue value = new HintTopValue(topRow[x][y], x, y);
                topValues.add(value);
            }
        }
        hintTopValueRepository.saveAll(topValues);

        for (int x = 0; x < sideRow.length; x++) {
            for (int y = 0; y < sideRow[x].length; y++){
                HintSideValue value = new HintSideValue(sideRow[x][y], x, y);
                sideValues.add(value);
            }
        }
        hintSideValueRepository.saveAll(sideValues);

        n.setSideValues(sideValues);
        n.setTopValues(topValues);
        n.setName("rens");
        nonogramRepository.save(n);
        return "Saved";
    }

    @CrossOrigin
    @GetMapping("/get")
    public @ResponseBody Nonogram nonogram(@RequestParam int id) {
        Nonogram test = nonogramRepository.findById(id).get();
        return test;
    }
}
