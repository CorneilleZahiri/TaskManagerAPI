package org.codewithcorneille.taskmanagerapi.task.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TaskDtoRegister {
    @NotBlank(message = "Le titre de la tâche est obligatoire.")
    private String title;

    private String description;
}
