package com.boostware.taskservice.service;

import com.boostware.taskservice.dto.CustomTaskMapper;
import com.boostware.taskservice.dto.TaskDto;
import com.boostware.taskservice.model.Task;
import com.boostware.taskservice.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    private final CustomTaskMapper mapper;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksByUserName(String username) {
        return taskRepository.findByUsername(username);
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        log.info("TaskServiceImpl:updateTask - task id:{}",taskDto.id());
        Optional<Task> opTask = taskRepository.findById(taskDto.id());
        if (opTask.isPresent()) {
            mapper.updateTaskFromTaskDto(taskDto,opTask.get());
            Task task = taskRepository.save(opTask.get());
            mapper.updateTaskDtoFromTask(task,taskDto);
        } else {
            log.error("updateTask failed. Task Id:{} not found",taskDto.id());
        }
        return taskDto;
    }

    @Override
    public Task createTask(Task task) {
        log.info("TaskServiceImpl:createTask");
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public void deleteTaskById(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task getTaskById(Long id){
        Optional<Task> task =  taskRepository.findById(id);
        return task.orElseThrow();
    }
}
