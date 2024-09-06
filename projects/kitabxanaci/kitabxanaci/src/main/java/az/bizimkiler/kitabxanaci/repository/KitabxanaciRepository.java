package az.bizimkiler.kitabxanaci.repository;

import az.bizimkiler.kitabxanaci.entity.Kitabxanaci;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KitabxanaciRepository extends JpaRepository <Kitabxanaci, Long> {
    Optional<Kitabxanaci> findByEmail(String email);
}
