package com.boostware.taskservice.service;

import com.boostware.taskservice.dto.TaskDto;
import com.boostware.taskservice.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    List<Task> getTasksByUserName(String username);
    Task getTaskById(Long id);
    TaskDto updateTask(TaskDto taskDto);

    Task createTask(Task task);

    void deleteTaskById(Long id);

}
