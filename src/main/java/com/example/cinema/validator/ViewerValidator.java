package com.example.cinema.validator;

import com.example.cinema.dto.ViewerDto;
import com.example.cinema.repository.ViewerRepository;
import com.example.cinema.repository.entity.Viewer;
import com.example.cinema.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ViewerValidator {

    @Autowired
    private ViewerRepository viewerRepository;

    public void validateViewerDoesNotExist(ViewerDto viewerDto) {
        Viewer viewer = viewerRepository.findViewerByLoginOrPassword(viewerDto.getLogin(), viewerDto.getPassword());
        if (Objects.nonNull(viewer)) {
            ResponseUtils.throwBadRequestException("Login/password is already used");
        }
    }
}
