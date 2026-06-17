package org.codewithcorneille.taskmanagerapi.task.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.codewithcorneille.taskmanagerapi.task.dto.TaskDto;
import org.codewithcorneille.taskmanagerapi.task.dto.TaskDtoRegister;
import org.codewithcorneille.taskmanagerapi.task.entity.Task;
import org.codewithcorneille.taskmanagerapi.task.enumeration.TaskEnum;
import org.codewithcorneille.taskmanagerapi.task.mapper.TaskMapper;
import org.codewithcorneille.taskmanagerapi.task.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Transactional
    public TaskDto createTask(TaskDtoRegister request) {
        //Convertir le request en entité
        Task task = taskMapper.taskRegisterToTask(request);
        task.setStatus(TaskEnum.A_FAIRE);
        Task taskCreated = taskRepository.save(task);

        return taskMapper.taskToTaskDto(taskCreated);
    }

    @Transactional
    public TaskDto getTaskById(UUID id) {

        return taskRepository.findById(id)
                .map(taskMapper::taskToTaskDto)
                .orElseThrow(() -> new EntityNotFoundException("Le paramètre id n'existe pas."));
    }

    @Transactional
    public Page<TaskDto> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable).map(taskMapper::taskToTaskDto);
    }
}
