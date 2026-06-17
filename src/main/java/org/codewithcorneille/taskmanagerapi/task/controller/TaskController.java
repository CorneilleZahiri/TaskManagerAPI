package org.codewithcorneille.taskmanagerapi.task.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.codewithcorneille.taskmanagerapi.share.ApiResponse;
import org.codewithcorneille.taskmanagerapi.task.dto.TaskDto;
import org.codewithcorneille.taskmanagerapi.task.dto.TaskDtoRegister;
import org.codewithcorneille.taskmanagerapi.task.dto.TaskUpdateStatus;
import org.codewithcorneille.taskmanagerapi.task.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskDto>> getTask(@PathVariable UUID id) {

        return ResponseEntity.ok(ApiResponse
                .success("Tâche récupérée avec succès.",
                        taskService.getTaskById(id)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<TaskDto>>> getAllTasks(
            @RequestParam(required = false, name = "page", defaultValue = "0") int page,
            @RequestParam(required = false, name = "size", defaultValue = "10") int size,
            @RequestParam(required = false, name = "sort", defaultValue = "title") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return ResponseEntity.ok(ApiResponse.success("Liste des tâches.", taskService.getAllTasks(pageable)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskDto>> updateTask(@PathVariable UUID id, @Valid @RequestBody TaskDtoRegister taskDtoRegister) {

        return ResponseEntity.ok(ApiResponse.success("Modification réussie.", taskService.updateTask(id, taskDtoRegister)));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<TaskDto>> updateTaskStatus(@PathVariable UUID id,
                                                                 @RequestBody TaskUpdateStatus taskUpdateStatus) {
        return ResponseEntity.ok(ApiResponse.success(
                "Modification du status réussie.", taskService.updateStatus(id, taskUpdateStatus)));
    }

}
