package com.agrgic.task_manager_service.model;

import lombok.Getter;

@Getter
public class UpdateTaskDTO {
    String title;
    String description;
    boolean completed;
}
