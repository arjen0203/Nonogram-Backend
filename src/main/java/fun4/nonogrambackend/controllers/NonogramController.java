package fun4.nonogrambackend.controllers;

import fun4.nonogrambackend.models.NonogramModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NonogramController {
    private final long id = 1;
    private final int[][] topRow = new int[][] { {1}, {5}, {2}, {5}, {2, 1}, {2} };
    private final int[][] sideRow = new int[][] { {2, 1}, {1, 3}, {1, 2}, {3}, {4}, {1}};

    @CrossOrigin
    @GetMapping("/nonogram")
    public NonogramModel nonogram() {
        return new NonogramModel(id, topRow, sideRow);
    }
}
