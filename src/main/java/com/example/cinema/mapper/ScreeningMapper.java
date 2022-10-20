package com.example.cinema.mapper;

import com.example.cinema.controller.dto.ScreeningDto;
import com.example.cinema.repository.entity.Screening;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScreeningMapper {

    Screening dtoToEntity(ScreeningDto screeningDto);

    ScreeningDto entityToDto(Screening screening);

    List<ScreeningDto> entitiesToDto(Iterable<Screening> screening);
}
