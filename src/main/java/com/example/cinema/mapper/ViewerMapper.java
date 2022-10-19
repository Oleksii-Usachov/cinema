package com.example.cinema.mapper;

import com.example.cinema.controller.dto.ViewerDto;
import com.example.cinema.repository.entity.Viewer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ViewerMapper {

    Viewer dtoToEntity(ViewerDto viewerDto);

    ViewerDto entityToDto(Viewer viewer);

    List<ViewerDto> entitiesToDto(Iterable<Viewer> viewer);
}
