package com.taskmanager.api.dto;

import com.taskmanager.api.entity.TaskStatus;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
