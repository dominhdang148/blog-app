package com.dominhdang.blog_app.models;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiResponse<Type> {
    private Type data;
    private String message;
    private Pagination pagination;
    private HttpStatus status;
}
