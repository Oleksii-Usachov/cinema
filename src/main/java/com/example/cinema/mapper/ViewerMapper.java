package com.example.cinema.mapper;

import com.example.cinema.controller.dto.ViewerDto;
import com.example.cinema.repository.entity.Viewer;
import org.springframework.stereotype.Component;

@Component
public class ViewerMapper {

    public Viewer dtoToEntity(ViewerDto viewerDto) {
        if (viewerDto == null) {
            return null;
        }

        Viewer viewer = new Viewer();

        viewer.setId(viewerDto.getId());
        viewer.setLogin(viewerDto.getLogin());
        viewer.setPassword(viewerDto.getPassword());
        viewer.setFirstName(viewerDto.getFirstName());
        viewer.setLastName(viewerDto.getLastName());

        return viewer;
    }

    public ViewerDto entityToDto(Viewer viewer) {
        if (viewer == null) {
            return null;
        }

        ViewerDto viewerDto = new ViewerDto();

        viewerDto.setId(viewer.getId());
        viewerDto.setLogin(viewer.getLogin());
        viewerDto.setPassword(viewer.getPassword());
        viewerDto.setFirstName(viewer.getFirstName());
        viewerDto.setLastName(viewer.getLastName());

        return viewerDto;
    }
}
