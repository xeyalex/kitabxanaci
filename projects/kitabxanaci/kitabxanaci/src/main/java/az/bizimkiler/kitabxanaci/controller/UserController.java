package az.bizimkiler.kitabxanaci.controller;

import az.bizimkiler.kitabxanaci.dto.UserProfileUpdate;
import az.bizimkiler.kitabxanaci.entity.User;
import az.bizimkiler.kitabxanaci.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("İstifadəçi qeydiyyatdan keçdi.");
    }
    @PutMapping("/{userId}")
    public ResponseEntity<String> updateProfile(@PathVariable Long userId, @RequestBody UserProfileUpdate update) {
        userService.updateProfile(userId, update);
        return ResponseEntity.ok("Profil yeniləndi.");
    }
}
