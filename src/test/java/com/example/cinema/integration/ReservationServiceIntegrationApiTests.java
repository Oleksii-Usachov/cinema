package com.example.cinema.integration;

import com.example.cinema.core.AbstractApiTest;
import com.example.cinema.dto.ReservationDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.cinema.constants.ReservationStatus.RESERVED;
import static com.example.cinema.constants.UnitTestingConstants.ID;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ReservationServiceIntegrationApiTests extends AbstractApiTest {

    private ReservationDto mockReservation;

    @BeforeEach
    void setUp() {
        mockReservation = new ReservationDto();
        mockReservation.setId(ID);
        mockReservation.setScreeningId(ID);
        mockReservation.setReservationStatus(RESERVED);
        mockReservation.setViewerId(ID);
        mockReservation.setSeatId(ID);
    }

    @Test
    void whenValidDataIsProvided_thenSeatIsReserved() throws Exception {
        String expectedValue = OBJECT_MAPPER.writeValueAsString(mockReservation);

        mockMvc.perform(MockMvcRequestBuilders.post("/reservation/reserve-seat")
                .content(OBJECT_MAPPER.writeValueAsString(mockReservation))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedValue));
    }
}
