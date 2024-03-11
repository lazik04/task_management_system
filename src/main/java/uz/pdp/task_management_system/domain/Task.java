package uz.pdp.task_management_system.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    private Long id;
    private String title;
    private String description;
    private Date created;
    private Date deadline;
    private String stat;
}
