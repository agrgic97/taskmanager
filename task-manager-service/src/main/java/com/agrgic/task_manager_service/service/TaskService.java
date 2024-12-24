package com.agrgic.task_manager_service.service;

import com.agrgic.task_manager_service.exception.TaskDoesNotExistException;
import com.agrgic.task_manager_service.model.Task;
import com.agrgic.task_manager_service.model.CreateTaskDTO;
import com.agrgic.task_manager_service.model.UpdateTaskDTO;
import com.agrgic.task_manager_service.model.User;
import com.agrgic.task_manager_service.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAllByUserId(Integer userId){
        return taskRepository.findAllByUserId(userId);
    }

    public Task createTask(CreateTaskDTO task) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Task createdTask = Task.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(false)
                .user(user).build();

        return taskRepository.save(createdTask);
    }

    public Task updateTask(UpdateTaskDTO task, Integer taskId) {
        Optional<Task> existingTask = taskRepository.findById(taskId);

        if (existingTask.isEmpty()) {
            throw new TaskDoesNotExistException("Task with id " + taskId + " does not exist");
        }

        Task updatedTask = Task.builder()
                .id(existingTask.get().getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(task.isCompleted())
                .user(existingTask.get().getUser()).build();

        return taskRepository.save(updatedTask);
    }

    public void deleteTask(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

}
