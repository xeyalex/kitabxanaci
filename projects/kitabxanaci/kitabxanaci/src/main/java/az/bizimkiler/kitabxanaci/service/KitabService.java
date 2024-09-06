package az.bizimkiler.kitabxanaci.service;

import az.bizimkiler.kitabxanaci.entity.Kitab;
import az.bizimkiler.kitabxanaci.repository.KitabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitabService {
    @Autowired
    private KitabRepository kitabRepository;
    public void addKitab(Kitab kitab){
        kitabRepository.save(kitab);
    }
public List<Kitab> getAllKitablar(){
        return kitabRepository.findAll();
}
public void deleteKitab(Long id){
        kitabRepository.deleteById(id);
}
}
