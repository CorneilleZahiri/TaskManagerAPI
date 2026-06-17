package org.codewithcorneille.taskmanagerapi.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codewithcorneille.taskmanagerapi.task.enumeration.TaskEnum;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {
    private UUID id;
    private String title;
    private String description;
    private TaskEnum status;
    private Instant createdAt;
    private Instant updatedAt;
}
