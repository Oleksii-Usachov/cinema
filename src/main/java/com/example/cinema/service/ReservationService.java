package com.example.cinema.service;

import com.example.cinema.dto.ReservationDto;
import com.example.cinema.mapper.ReservationMapper;
import com.example.cinema.mapper.ScreeningMapper;
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
    private ReservationMapper reservationMapper;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ViewerRepository viewerRepository;
    @Autowired
    private ScreeningMapper screeningMapper;
    @Autowired
    private ScreeningRepository screeningRepository;

    public ReservationDto reserveSeat(ReservationDto reservationDto) {
        reservationDto.setReservationStatus(RESERVED);
        Reservation reservation = reservationRepository.save(
                reservationMapper.dtoToEntity(reservationDto));
        return reservationMapper.entityToDto(reservation);
    }
}
