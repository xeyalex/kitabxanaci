package az.bizimkiler.kitabxanaci.service;

import az.bizimkiler.kitabxanaci.entity.User;
import az.bizimkiler.kitabxanaci.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("İstifadəçi tapılmadı: " + username));


        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }


    public void registerUser(String email, String password) {
            User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password)); // Parolu şifrələyirik
        user.setRole("USER"); // Default olaraq USER rolunu təyin edirik

             userRepository.save(user);
    }
}
