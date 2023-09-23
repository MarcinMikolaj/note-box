package com.notebox.dto;

import com.notebox.infrastructure.validation.NoteContent;
import com.notebox.infrastructure.validation.NoteTitle;

public record NoteDto(Long id, @NoteTitle String title, @NoteContent String content) {}