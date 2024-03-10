package uz.pdp.task_management_system.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignupDto {
    private String email;
    private String password;
}
