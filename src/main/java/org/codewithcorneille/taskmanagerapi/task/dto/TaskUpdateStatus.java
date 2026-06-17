package org.codewithcorneille.taskmanagerapi.task.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.codewithcorneille.taskmanagerapi.task.enumeration.TaskEnum;

@AllArgsConstructor
@Data
public class TaskUpdateStatus {
    @NotBlank(message = "Le status de la tâche est obligatoire.")
    private TaskEnum status;
}
