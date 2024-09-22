package az.bizimkiler.kitabxanaci.service;

import az.bizimkiler.kitabxanaci.dto.LoginRequest;
import az.bizimkiler.kitabxanaci.entity.Telebe;
import az.bizimkiler.kitabxanaci.repository.TelebeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelebeService {
    @Autowired
    private TelebeRepository telebeRepository;
    public void qeydiyyatTelebe(Telebe telebe){
        telebeRepository.save(telebe);

    }
    public boolean loginTelebe(LoginRequest loginRequest){
        Optional<Telebe>telebe=telebeRepository.findByEmail(loginRequest.getEmail());
        if (telebe.isPresent()&& telebe.get().getPassword().equals(loginRequest.getPassword())){
            return true;
        }
        return false;
    }
}