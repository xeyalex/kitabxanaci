package az.bizimkiler.kitabxanaci.repository;

import az.bizimkiler.kitabxanaci.entity.Kitab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitabRepository extends JpaRepository <Kitab, Long> {
}
