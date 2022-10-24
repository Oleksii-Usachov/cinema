package com.example.cinema.integration;

import com.example.cinema.core.AbstractDbTest;
import com.example.cinema.dto.Credentials;
import com.example.cinema.dto.ViewerDto;
import com.example.cinema.exception.BadRequestException;
import com.example.cinema.service.AuthorizationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.cinema.constants.UnitTestingConstants.ID;
import static com.example.cinema.constants.UnitTestingConstants.LENGTH;
import static com.example.cinema.constants.UnitTestingConstants.TEST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static wiremock.org.apache.commons.lang3.RandomStringUtils.random;

class AuthorizationServiceIntegrationDbTests extends AbstractDbTest {

    @Autowired
    private AuthorizationService authorizationService;

    private ViewerDto viewerDto;
    private Credentials mockCredentials;

    @BeforeEach
    public void setUp() {
        viewerDto = new ViewerDto();
        viewerDto.setLogin(TEST);
        viewerDto.setPassword(TEST);
        viewerDto.setFirstName(TEST);
        viewerDto.setLastName(TEST);
        viewerDto.setId(ID);

        mockCredentials = new Credentials();
        mockCredentials.setLogin(viewerDto.getLogin());
        mockCredentials.setPassword(viewerDto.getPassword());
    }

    @Test
    void validLoginDataPassedThenNewViewerSaved() {
        authorizationService.registerNewViewer(viewerDto);

        ViewerDto viewerDto = authorizationService.getViewerData(mockCredentials);

        assertEquals(mockCredentials.getLogin(), viewerDto.getLogin());
    }

    @Test
    void invalidLoginDataPassedThenNoViewerFound() {
        mockCredentials.setLogin(random(LENGTH));
        mockCredentials.setPassword(random(LENGTH));

        assertThrows(BadRequestException.class, () -> authorizationService.getViewerData(mockCredentials),
                "Incorrect login/password");
    }

    @Test
    void registeredViewerIsFoundThenViewerIsDeleted() {
        ViewerDto viewerDto = authorizationService.getViewerData(mockCredentials);

        boolean isViewerDeleted = authorizationService.deleteViewer(viewerDto.getId());

        assertTrue(isViewerDeleted);
    }
}
