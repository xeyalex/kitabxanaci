package az.bizimkiler.kitabxanaci.repository;

import az.bizimkiler.kitabxanaci.entity.Telebe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TelebeRepository extends JpaRepository <Telebe, Long> {
    Optional<Telebe>findByEmail(String email);
}
