package com.notebox.infrastructure.mapper;

import com.notebox.dto.NoteDto;
import com.notebox.model.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoteMapper {
    NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);

    @Mapping(target = "date", expression = "java(java.time.LocalDateTime.now())")
    Note noteDtoToNote(NoteDto noteDto);
}
