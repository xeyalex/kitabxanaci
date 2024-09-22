package az.bizimkiler.kitabxanaci.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class KitabxanaciLoginRequest {
        private String email;
        private String password;
}
