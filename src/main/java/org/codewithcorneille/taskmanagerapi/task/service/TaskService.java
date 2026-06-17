package org.codewithcorneille.taskmanagerapi.task.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.codewithcorneille.taskmanagerapi.task.dto.TaskDto;
import org.codewithcorneille.taskmanagerapi.task.dto.TaskDtoRegister;
import org.codewithcorneille.taskmanagerapi.task.entity.Task;
import org.codewithcorneille.taskmanagerapi.task.enumeration.TaskEnum;
import org.codewithcorneille.taskmanagerapi.task.mapper.TaskMapper;
import org.codewithcorneille.taskmanagerapi.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

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
}
