package az.bizimkiler.kitabxanaci.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class BookRequest {
        private String title;
        private String author;
        private String isbn;
        private String imagePath; // Geri qaytarılan şəkil adı burada saxlanılacaq
    }

