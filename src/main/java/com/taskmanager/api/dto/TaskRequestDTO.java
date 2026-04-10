package com.taskmanager.api.dto;

import com.taskmanager.api.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequestDTO {
    @NotBlank(message = "Titulo é obrigatório!")
    private String title;

    private String description;

    @NotNull(message = "Status é obrigatório!")
    private TaskStatus status;
}
