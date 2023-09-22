package com.notebox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
public class Note {
    private String title;
    private String content;
    private LocalDateTime date;
}
