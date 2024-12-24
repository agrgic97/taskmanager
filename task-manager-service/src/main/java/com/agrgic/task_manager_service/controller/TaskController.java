package com.agrgic.task_manager_service.controller;

import com.agrgic.task_manager_service.model.Task;
import com.agrgic.task_manager_service.model.CreateTaskDTO;
import com.agrgic.task_manager_service.model.UpdateTaskDTO;
import com.agrgic.task_manager_service.service.TaskService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/{userId}")
    public ResponseEntity<List<Task>> getTaskByUserId(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(taskService.findAllByUserId(userId));
    }

    @PostMapping("/task")
    public ResponseEntity<Task> createTask(@RequestBody CreateTaskDTO task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));
    }

    @PutMapping("/task/{taskId}")
    public ResponseEntity<Task> updateTask(@RequestBody UpdateTaskDTO updateTaskDTO, @PathVariable("taskId") Integer taskId) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(taskService.updateTask(updateTaskDTO, taskId));
    }

    @DeleteMapping("/task/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable("taskId") Integer taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Task deleted successfully");
    }
}
