package com.example.cinema.unit;

import com.example.cinema.core.AbstractUnitTest;
import com.example.cinema.dto.ReservationDto;
import com.example.cinema.mapper.ReservationMapper;
import com.example.cinema.repository.ReservationRepository;
import com.example.cinema.repository.entity.Reservation;
import com.example.cinema.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.example.cinema.constants.ReservationStatus.RESERVED;
import static com.example.cinema.constants.UnitTestingConstants.ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReservationUnitTests extends AbstractUnitTest {

    @Autowired
    ReservationService reservationService;
    @MockBean
    ReservationMapper reservationMapper;
    @MockBean
    ReservationRepository reservationRepository;

    ReservationDto mockReservationDto;

    @BeforeEach
    void setUp() {
        reset(reservationRepository);

        mockReservationDto = new ReservationDto();
        mockReservationDto.setId(ID);
        mockReservationDto.setReservationStatus(RESERVED);
        mockReservationDto.setScreeningId(ID);
        mockReservationDto.setSeatId(ID);
        mockReservationDto.setViewerId(ID);
    }

    @Test
    void whenReservationIsCalled_thenSeatIsReserved() {

        mockReservationDto.setReservationStatus(RESERVED);
        Reservation mockReservation = new Reservation();

        when(reservationMapper.dtoToEntity(mockReservationDto)).thenReturn(mockReservation);
        when(reservationRepository.save(mockReservation)).thenReturn(mockReservation);

        reservationService.reserveSeat(mockReservationDto);

        assertEquals(RESERVED, mockReservationDto.getReservationStatus());
        verify(reservationRepository).save(mockReservation);
        verify(reservationMapper).entityToDto(mockReservation);
    }
}
