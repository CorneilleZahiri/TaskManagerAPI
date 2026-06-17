package org.codewithcorneille.taskmanagerapi.task.mapper;

import org.codewithcorneille.taskmanagerapi.task.dto.TaskDto;
import org.codewithcorneille.taskmanagerapi.task.dto.TaskDtoRegister;
import org.codewithcorneille.taskmanagerapi.task.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task taskRegisterToTask(TaskDtoRegister taskDtoRegister);

    TaskDto taskToTaskDto(Task task);

}
