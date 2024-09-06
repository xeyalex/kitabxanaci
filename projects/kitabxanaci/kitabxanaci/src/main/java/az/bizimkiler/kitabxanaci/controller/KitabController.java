package az.bizimkiler.kitabxanaci.controller;

import az.bizimkiler.kitabxanaci.entity.Kitab;
import az.bizimkiler.kitabxanaci.service.KitabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kitablar")
public class KitabController {
    @Autowired
    private KitabService kitabService;

    @PostMapping("/add")
    public ResponseEntity<String>addKitab(@RequestBody Kitab kitab){
       kitabService.addKitab(kitab);
       return ResponseEntity.ok("Kitab əlavə olundu.");
    }
    @GetMapping("/all")
    public ResponseEntity<List<Kitab>>getAllKitablar(){

        return ResponseEntity.ok(kitabService.getAllKitablar());
    }
    @DeleteMapping
    public ResponseEntity<String>deleteKitab(@PathVariable Long id){
        kitabService.deleteKitab(id);
        return ResponseEntity.ok(("Kitab silindi"));
    }
}
