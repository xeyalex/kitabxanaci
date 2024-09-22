package az.bizimkiler.kitabxanaci.service;

import az.bizimkiler.kitabxanaci.dto.UserProfileUpdate;
import az.bizimkiler.kitabxanaci.entity.User;
import az.bizimkiler.kitabxanaci.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }
    public void updateProfile(Long userId, UserProfileUpdate update) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("İstifadəçi tapılmadı"));

        // Yenilənəcək sahələr
        user.setFirstName(update.getFirstName());
        user.setLastName(update.getLastName());
        user.setPhone(update.getPhone());
        user.setAddress(update.getAddress());

        userRepository.save(user);
    }



}
