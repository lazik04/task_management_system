package uz.pdp.task_management_system.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
 public class User {
    private String email;
    private String password;

}
