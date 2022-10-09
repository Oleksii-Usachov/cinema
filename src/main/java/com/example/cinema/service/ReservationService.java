package com.example.cinema.service;

import com.example.cinema.controller.dto.ReservationDto;
import com.example.cinema.mapper.ReservationMappers;
import com.example.cinema.mapper.ScreeningMappers;
import com.example.cinema.repository.ReservationRepository;
import com.example.cinema.repository.ScreeningRepository;
import com.example.cinema.repository.ViewerRepository;
import com.example.cinema.repository.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.cinema.constants.ReservationStatus.RESERVED;

@Service
public class ReservationService {

    @Autowired
    private ReservationMappers reservationMappers;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ViewerRepository viewerRepository;
    @Autowired
    private ScreeningMappers screeningMappers;
    @Autowired
    private ScreeningRepository screeningRepository;

    public ReservationDto reserveSeat(ReservationDto reservationDto) {
        reservationDto.setReservationStatus(RESERVED);
        Reservation reservation = reservationRepository.save(
                reservationMappers.dtoToEntity(reservationDto));
        return reservationMappers.entityToDto(reservation);
    }
}
