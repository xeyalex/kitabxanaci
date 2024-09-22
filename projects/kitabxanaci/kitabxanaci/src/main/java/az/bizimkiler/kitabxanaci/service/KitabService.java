package az.bizimkiler.kitabxanaci.service;

import az.bizimkiler.kitabxanaci.dto.BookRequest;
import az.bizimkiler.kitabxanaci.entity.Kitab;
import az.bizimkiler.kitabxanaci.repository.KitabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitabService {

    @Autowired
    private KitabRepository kitabRepository;

    // Kitab əlavə etmək
    public void addKitab(Kitab kitab) {
        kitabRepository.save(kitab);
    }

    // Kitabı şəkil ilə əlavə etmək
    public Kitab saveBookWithImage(BookRequest bookRequest) {
        Kitab kitab = new Kitab();
        kitab.setTitle(bookRequest.getTitle());
        kitab.setAuthor(bookRequest.getAuthor());
        kitab.setIsbn(bookRequest.getIsbn());
        kitab.setImagePath(bookRequest.getImagePath()); // Şəkil yolunu təyin edir

        return kitabRepository.save(kitab);
    }

    // Bütün kitabları əldə etmək
    public List<Kitab> getAllKitablar() {
        return kitabRepository.findAll();
    }

    // Kitabı ID ilə silmək
    public void deleteKitab(Long id) {
        kitabRepository.deleteById(id);

    }
    public List<Kitab> getBookHistory() {
        return kitabRepository.findAll(); // Tarix
    }

}
