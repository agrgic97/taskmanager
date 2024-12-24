package com.agrgic.task_manager_service.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginResponse {
    private String token;
    private long expiresIn;
}
