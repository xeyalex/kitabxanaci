package az.bizimkiler.kitabxanaci.dto;

import lombok.Data;

@Data
public class UserProfileUpdate {
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
}
