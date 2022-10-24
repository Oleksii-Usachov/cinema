package com.example.cinema.unit;


import com.example.cinema.core.AbstractUnitTest;
import com.example.cinema.dto.Credentials;
import com.example.cinema.dto.ViewerDto;
import com.example.cinema.exception.BadRequestException;
import com.example.cinema.mapper.ViewerMapper;
import com.example.cinema.repository.ViewerRepository;
import com.example.cinema.repository.entity.Viewer;
import com.example.cinema.service.AuthorizationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.example.cinema.constants.UnitTestingConstants.ID;
import static com.example.cinema.constants.UnitTestingConstants.LOGIN;
import static com.example.cinema.constants.UnitTestingConstants.PASSWORD;
import static com.example.cinema.constants.UnitTestingConstants.TEST;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuthorizationUnitTests extends AbstractUnitTest {

    @Autowired
    AuthorizationService authorizationService;
    @MockBean
    ViewerMapper viewerMapper;
    @MockBean
    ViewerRepository viewerRepository;

    ViewerDto viewerDto;
    Credentials mockCredentials;
    Viewer mockViewer;

    @BeforeEach
    public void setup() {
        reset(viewerRepository);

        mockViewer = new Viewer();
        mockViewer.setId(ID);
        mockViewer.setLogin(LOGIN);
        mockViewer.setPassword(PASSWORD);

        mockCredentials = new Credentials();
        mockCredentials.setLogin(TEST);
        mockCredentials.setPassword(TEST);
    }

    @Test
    void whenViewerIsRegistered_thenViewerIsSaved() {
        Viewer viewer = new Viewer();

        when(viewerMapper.dtoToEntity(any(ViewerDto.class))).thenReturn(viewer);
        when(viewerRepository.save(viewer)).thenReturn(viewer);
        when(viewerMapper.entityToDto(viewer)).thenReturn(viewerDto);

        authorizationService.registerNewViewer(new ViewerDto());

        verify(viewerRepository).save(viewer);
        verify(viewerMapper).entityToDto(viewer);
    }

    @Test
    void whenViewerIsFoundInTheRepository_thenValidDataIsReturned() {
        when(viewerRepository.findViewerByLoginAndPassword(mockCredentials.getLogin(), mockCredentials.getPassword()))
                .thenReturn(mockViewer);

        authorizationService.getViewerData(mockCredentials);

        verify(viewerRepository).findViewerByLoginAndPassword(mockCredentials.getLogin(), mockCredentials.getPassword());
        verify(viewerMapper).entityToDto(mockViewer);
    }

    @Test
    void givenViewerIsNotFoundInTheRepositoryByLoginAndPassword_thenBadRequestExceptionIsExpected() {
        given(viewerRepository.findViewerByLoginAndPassword(mockViewer.getLogin(), mockViewer.getPassword()))
                .willReturn(mockViewer);

        assertThatThrownBy(() -> authorizationService.getViewerData(mockCredentials))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Incorrect login/password");
        verify(viewerMapper, never()).entityToDto(mockViewer);
    }

    @Test
    void whenViewerIsFoundInTheRepository_thenViewerIsDeleted() {
        Long id = ID;
        mockViewer.setId(id);

        when(viewerRepository.findViewerById(id)).thenReturn(mockViewer);
        when(viewerRepository.deleteViewerById(id)).thenReturn(1);

        boolean isViewerDeleted = authorizationService.deleteViewer(id);

        assertTrue(isViewerDeleted);
        verify(viewerRepository).findViewerById(id);
        verify(viewerRepository).deleteViewerById(id);
    }

    @Test
    void givenViewerIsNotFoundInTheRepositoryById_thenBadRequestExceptionIsExpected() {
        given(viewerRepository.findViewerById(mockViewer.getId()))
                .willThrow(BadRequestException.class);

        assertThrows(BadRequestException.class, () -> authorizationService.deleteViewer(mockViewer.getId()));
        verify(viewerRepository, never()).deleteViewerById((mockViewer.getId()));
    }
}
