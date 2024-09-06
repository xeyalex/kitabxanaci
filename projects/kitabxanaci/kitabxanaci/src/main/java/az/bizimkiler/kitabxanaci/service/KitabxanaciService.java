package az.bizimkiler.kitabxanaci.service;

import az.bizimkiler.kitabxanaci.entity.Kitabxanaci;
import az.bizimkiler.kitabxanaci.repository.KitabxanaciRepository;
import az.bizimkiler.kitabxanaci.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KitabxanaciService {

    @Autowired
    private KitabxanaciRepository kitabxanaciRepository;

    public void registerKitabxanaci(Kitabxanaci kitabxanaci) {
        kitabxanaciRepository.save(kitabxanaci);
    }

    public boolean loginKitabxanaci(LoginRequest loginRequest) {
        Optional<Kitabxanaci> kitabxanaci = kitabxanaciRepository.findByEmail(loginRequest.getEmail());
        if (kitabxanaci.isPresent() && kitabxanaci.get().getPassword().equals(loginRequest.getPassword())) {
            return true;
        }
        return false;
    }
}
