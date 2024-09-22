package az.bizimkiler.kitabxanaci.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class KitabxanaciLoginRequest {
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String email;
    private String password;
}
