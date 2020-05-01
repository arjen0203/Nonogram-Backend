//package fun4.nonogrambackend.controllers;
//
//import fun4.nonogrambackend.Repositories.NonogramRepository;
//import fun4.nonogrambackend.models.Nonogram;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping(path="/nonogram")
//public class NonogramController {
//
//    @Autowired
//    private NonogramRepository nonogramRepository;
//
//    private final long id = 1;
//    private final int[][] topRow = new int[][] { {1}, {5}, {2}, {5}, {2, 1}, {2}, {0} };
//    private final int[][] sideRow = new int[][] { {2, 1}, {1, 3}, {1, 2}, {3}, {4}, {1}, {0}};
//
//    @CrossOrigin
//    @PostMapping(path="/add")
//    public @ResponseBody String addNewNonogram (@RequestParam() String topRow, @RequestParam String sideRow) {
//        Nonogram n = new Nonogram();
//        n.setTopRow(topRow);
//        n.setSideRow(sideRow);
//        nonogramRepository.save(n);
//        return "Saved";
//    }
//
//    @CrossOrigin
//    @GetMapping("/get")
//    public Optional<Nonogram> nonogram(@RequestParam int id) {
//        return nonogramRepository.findById(id);
//    }
//}
