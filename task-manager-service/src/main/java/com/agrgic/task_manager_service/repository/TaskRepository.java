package com.agrgic.task_manager_service.repository;

import com.agrgic.task_manager_service.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    public List<Task> findAllByUserId(Integer userId);
}
