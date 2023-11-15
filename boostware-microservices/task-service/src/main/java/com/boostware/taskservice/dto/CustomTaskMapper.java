package com.boostware.taskservice.dto;

import com.boostware.taskservice.model.Task;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CustomTaskMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTaskFromTaskDto(TaskDto dto, @MappingTarget Task task);

    void updateTaskDtoFromTask(Task task, @MappingTarget TaskDto taskDto);
}
