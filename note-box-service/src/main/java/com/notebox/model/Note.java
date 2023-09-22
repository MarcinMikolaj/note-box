package com.notebox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class Note {
    private String title;
    private String content;
    private LocalDateTime date;
}
