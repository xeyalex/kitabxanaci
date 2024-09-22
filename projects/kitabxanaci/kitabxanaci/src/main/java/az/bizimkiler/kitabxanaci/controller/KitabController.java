package az.bizimkiler.kitabxanaci.controller;

import az.bizimkiler.kitabxanaci.dto.BookRequest;
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

    // Kitabın qeydiyyatı (imagePath ilə)
    @PostMapping("/add")
    public ResponseEntity<Kitab> registerBookWithImage(@RequestBody BookRequest bookRequest) {
        Kitab newKitab = kitabService.saveBookWithImage(bookRequest);
        return ResponseEntity.ok(newKitab);
    }

    // Bütün kitabları əldə etmək
    @GetMapping("/all")
    public ResponseEntity<List<Kitab>> getAllKitablar() {
        return ResponseEntity.ok(kitabService.getAllKitablar());
    }
    @GetMapping("/history")
    public ResponseEntity<List<Kitab>> getBookHistory() {
        List<Kitab> kitaplar = kitabService.getBookHistory();
        return ResponseEntity.ok(kitaplar); //kitab tarix
    }

    // Kitabı silmək
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteKitab(@PathVariable Long id) {
        kitabService.deleteKitab(id);
        return ResponseEntity.ok("Kitab silindi");
    }
    @GetMapping("/search")
    public ResponseEntity<List<Kitab>> searchBooks(@RequestParam String keyword) {
        List<Kitab> foundBooks = kitabService.searchBooks(keyword);
        return ResponseEntity.ok(foundBooks);
    }
}
