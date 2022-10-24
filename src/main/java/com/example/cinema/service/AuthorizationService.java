package com.example.cinema.service;

import com.example.cinema.controller.dto.Credentials;
import com.example.cinema.controller.dto.ViewerDto;
import com.example.cinema.mapper.ViewerMapper;
import com.example.cinema.repository.ViewerRepository;
import com.example.cinema.repository.entity.Viewer;
import com.example.cinema.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizationService {

    @Autowired
    private ViewerMapper viewerMapper;
    @Autowired
    private ViewerRepository viewerRepository;

    public ViewerDto registerNewViewer(ViewerDto viewerDto) {
        return viewerMapper.entityToDto(viewerRepository.save(viewerMapper.dtoToEntity(viewerDto)));
    }

    public ViewerDto getViewerData(Credentials credentials) {
        Viewer viewer = Optional.ofNullable(viewerRepository.findViewerByLoginAndPassword(credentials.getLogin(),
                credentials.getPassword()))
                .orElseThrow(() -> ResponseUtils.throwBadRequestException("Incorrect login/password"));
        return viewerMapper.entityToDto(viewer);
    }

    public boolean deleteViewer(Long id) {
        Viewer viewer = viewerRepository.findViewerById(id);
        return viewerRepository.deleteViewerById(viewer.getId()) == 1;
    }
}
