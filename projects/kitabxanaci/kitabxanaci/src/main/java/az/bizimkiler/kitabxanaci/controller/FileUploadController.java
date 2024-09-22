package az.bizimkiler.kitabxanaci.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@RestController
    @RequestMapping("/api/upload")
    public class FileUploadController {

        @PostMapping("/image")
        public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
            // Yüklənmiş faylın adını təsadüfi adla dəyişmək
            String randomFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            // Faylı serverdə saxlamaq
            try {
                Path path = Paths.get("uploads/images/" + randomFileName);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                return ResponseEntity.ok(randomFileName); // Təsadüfi yaradılan fayl adını geri qaytarır
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed");
            }
        }
    }


