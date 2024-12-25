package com.agrgic.task_manager_service.model;

import com.agrgic.task_manager_service.model.enums.Status;
import lombok.Getter;

@Getter
public class UpdateTaskDTO {
    String title;
    String description;
    Status status;
}
