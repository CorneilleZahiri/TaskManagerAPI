package org.codewithcorneille.taskmanagerapi.task.mapper;

import org.codewithcorneille.taskmanagerapi.task.dto.TaskDto;
import org.codewithcorneille.taskmanagerapi.task.dto.TaskDtoRegister;
import org.codewithcorneille.taskmanagerapi.task.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task taskRegisterToTask(TaskDtoRegister taskDtoRegister);

    TaskDto taskToTaskDto(Task task);

    Task taskDtoToTask(TaskDto taskDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateTask(TaskDtoRegister taskDtoRegister, @MappingTarget Task task);

}
