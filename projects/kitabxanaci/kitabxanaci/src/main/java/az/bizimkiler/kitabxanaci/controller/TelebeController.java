package az.bizimkiler.kitabxanaci.controller;

import az.bizimkiler.kitabxanaci.dto.LoginRequest;
import az.bizimkiler.kitabxanaci.entity.Telebe;
import az.bizimkiler.kitabxanaci.service.TelebeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/telebeler")
@RestController
public class TelebeController {
    @Autowired
    private TelebeService telebeService;
    @PostMapping("/qeydiyyat")
    public ResponseEntity<String> qeydiyyatTelebe(@RequestBody Telebe telebe){
        telebeService.qeydiyyatTelebe(telebe);
        return ResponseEntity.ok("Telebe ugurla qeydiyyatdan kecdi!");
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginTelebe(@RequestBody LoginRequest loginRequest) {
        boolean loginSuccess = telebeService.loginTelebe(loginRequest);
        if (loginSuccess) {
            return ResponseEntity.ok("Login uğurlu oldu.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login uğursuz oldu.");
        }
    }
}