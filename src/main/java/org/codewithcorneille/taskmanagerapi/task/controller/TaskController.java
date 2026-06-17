package org.codewithcorneille.taskmanagerapi.task.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.codewithcorneille.taskmanagerapi.share.ApiResponse;
import org.codewithcorneille.taskmanagerapi.task.dto.TaskDto;
import org.codewithcorneille.taskmanagerapi.task.dto.TaskDtoRegister;
import org.codewithcorneille.taskmanagerapi.task.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<ApiResponse<TaskDto>> registerTask(@Valid @RequestBody TaskDtoRegister taskDtoRegister,
                                                             UriComponentsBuilder uriComponentsBuilder) {

        TaskDto taskDto = taskService.createTask(taskDtoRegister);

        URI location = uriComponentsBuilder
                .path("/task/{id}")
                .buildAndExpand(taskDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(ApiResponse.success("Tâche enregistrée avec succès.", taskDto));
    }

}
