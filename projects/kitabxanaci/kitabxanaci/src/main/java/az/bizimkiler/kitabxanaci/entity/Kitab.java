package az.bizimkiler.kitabxanaci.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kitab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String isbn;
    private int publishYear;
    private String imagePath;
    private LocalDateTime createdAt; // Qeydiyyat tarixi
    private LocalDateTime updatedAt; // Dəyişiklik tarixi




}