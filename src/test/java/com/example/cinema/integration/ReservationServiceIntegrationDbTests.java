package com.example.cinema.integration;

import com.example.cinema.core.AbstractDbTest;
import com.example.cinema.dto.ReservationDto;
import com.example.cinema.mapper.ReservationMapper;
import com.example.cinema.repository.ReservationRepository;
import com.example.cinema.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.cinema.constants.ReservationStatus.RESERVED;
import static com.example.cinema.constants.UnitTestingConstants.ID;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReservationServiceIntegrationDbTests extends AbstractDbTest {

    @Autowired
    ReservationService reservationService;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ReservationMapper reservationMapper;

    @Test
    void givenValidDataIsProvided_thenSeatIsReserved() {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(ID);
        reservationDto.setScreeningId(ID);
        reservationDto.setReservationStatus(RESERVED);
        reservationDto.setViewerId(ID);
        reservationDto.setSeatId(ID);

        ReservationDto resultingReservationDto = reservationService.reserveSeat(reservationDto);
        ReservationDto dbReservationDto = reservationMapper.entityToDto(reservationRepository.findById(ID).orElse(null));

        assertEquals(dbReservationDto, resultingReservationDto);
    }
}
