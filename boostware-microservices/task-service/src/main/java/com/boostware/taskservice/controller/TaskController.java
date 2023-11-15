package com.boostware.taskservice.controller;

import com.boostware.taskservice.dto.TaskDto;
import com.boostware.taskservice.model.Task;
import com.boostware.taskservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping()
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTasks());
    }

    @GetMapping("all/{username}")
    public ResponseEntity<List<Task>> getAllTasksByUsername(@PathVariable("username") String username) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTasksByUserName(username));
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long taskId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskById(taskId));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable("id") Long taskId) {
        taskService.deleteTaskById(taskId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskdto, @PathVariable("id") String taskId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(taskdto));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.createTask(task));
    }
    /**
    content type negotiation for same URI - controls response content type/representation
    eg: Accept header - application/xml, application/json

     internationalization
    eg: Accept-Language - en,nl,fr
    achieved by adding com.fasterxml.jackson.dataformat
     **/


}
