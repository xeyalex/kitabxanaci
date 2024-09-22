package az.bizimkiler.kitabxanaci.repository;

import az.bizimkiler.kitabxanaci.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); }
