package com.example.cinema.repository;

import com.example.cinema.repository.entity.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Long> {
}
