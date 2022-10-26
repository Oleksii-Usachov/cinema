package com.example.cinema.integration;

import com.example.cinema.core.AbstractApiTest;
import com.example.cinema.dto.Credentials;
import com.example.cinema.dto.ViewerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.cinema.constants.UnitTestingConstants.ID;
import static com.example.cinema.constants.UnitTestingConstants.LENGTH;
import static com.example.cinema.constants.UnitTestingConstants.LOGIN;
import static com.example.cinema.constants.UnitTestingConstants.PASSWORD;
import static com.example.cinema.constants.UnitTestingConstants.SECOND_ID;
import static com.example.cinema.constants.UnitTestingConstants.TEST;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static wiremock.org.apache.commons.lang3.RandomStringUtils.random;

class AuthorizationServiceIntegrationApiTests extends AbstractApiTest {

    private Credentials mockCredentials;
    private ViewerDto mockViewerDto;

    @BeforeEach
    public void setUp() {
        mockViewerDto = new ViewerDto();
        mockViewerDto.setId(ID);
        mockViewerDto.setLogin(LOGIN);
        mockViewerDto.setPassword(PASSWORD);
        mockViewerDto.setFirstName(TEST);
        mockViewerDto.setLastName(TEST);

        mockCredentials = new Credentials();
        mockCredentials.setLogin(mockViewerDto.getLogin());
        mockCredentials.setPassword(mockViewerDto.getPassword());
    }

    @Test
    void whenSendSignInRequestWithValidCredentials_thenViewerIsLoggedIn() throws Exception {
        String expectedViewer = OBJECT_MAPPER.writeValueAsString(mockViewerDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/Authorization/signIn")
                .content(OBJECT_MAPPER.writeValueAsString(mockCredentials))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedViewer));
    }

    @Test
    void whenSendSignInRequestWithInvalidCredentials_thenViewerNotFoundErrorMessageIsReturned() throws Exception {
        mockCredentials.setLogin(random(LENGTH));

        mockMvc.perform(MockMvcRequestBuilders.post("/Authorization/signIn")
                .content(OBJECT_MAPPER.writeValueAsString(mockCredentials))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is("400")))
                .andExpect(jsonPath("$.errorMessage", is("Incorrect login/password")));
    }

    @Test
    void whenSendRegisterRequestWithValidData_thenViewerIsRegistered() throws Exception {
        mockViewerDto.setId(SECOND_ID);
        mockViewerDto.setLogin("login");
        mockViewerDto.setPassword("pass");
        mockViewerDto.setFirstName("Frank");
        mockViewerDto.setLastName("Reich");

        String expectedValue = OBJECT_MAPPER.writeValueAsString(mockViewerDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/Authorization/signUp")
                .content(OBJECT_MAPPER.writeValueAsString(mockViewerDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedValue));
    }

    @Test
    void whenSendDeleteRequestWithValidData_thenViewerIsDeleted() throws Exception {
        Long idToDelete = 3L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/Authorization/delete-viewer/{id}", idToDelete)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
