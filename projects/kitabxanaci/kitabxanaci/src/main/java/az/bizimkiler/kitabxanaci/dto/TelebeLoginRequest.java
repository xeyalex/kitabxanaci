package az.bizimkiler.kitabxanaci.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class TelebeLoginRequest {
        private String studentId;
        private String password;
    }

