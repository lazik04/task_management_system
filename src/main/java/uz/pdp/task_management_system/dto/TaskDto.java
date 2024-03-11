package uz.pdp.task_management_system.dto;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private String title;
    private String description;
    private Date deadline;
    private String stat;
}