package com.notebox.infrastructure.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
public class ExceptionDto {
    private LocalDateTime timestamp;
    private int status;
    private List<String> messages;
    private String path;
    private String method;
}
