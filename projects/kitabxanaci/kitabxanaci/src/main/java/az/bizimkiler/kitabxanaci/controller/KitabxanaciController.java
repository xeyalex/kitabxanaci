package az.bizimkiler.kitabxanaci.controller;

import az.bizimkiler.kitabxanaci.entity.Kitabxanaci;
import az.bizimkiler.kitabxanaci.service.KitabxanaciService;
import az.bizimkiler.kitabxanaci.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kitabxanacilar")
public class KitabxanaciController {

    @Autowired
    private KitabxanaciService kitabxanaciService;


    @PostMapping("/register")
    public ResponseEntity<String> registerKitabxanaci(@RequestBody Kitabxanaci kitabxanaci) {
        kitabxanaciService.registerKitabxanaci(kitabxanaci);
        return ResponseEntity.ok("Kitabxanaçı uğurla qeydiyyatdan keçdi.");
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginKitabxanaci(@RequestBody LoginRequest loginRequest) {
        boolean loginSuccess = kitabxanaciService.loginKitabxanaci(loginRequest);
        if (loginSuccess) {
            return ResponseEntity.ok("Login uğurlu oldu.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login uğursuz oldu.");
        }
    }
}
