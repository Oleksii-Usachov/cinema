package com.example.cinema.repository.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long movieId;
    @ManyToOne
    @JoinColumn(name = "id", insertable=false, updatable=false)
    private CinemaHall cinemaHallId;
//    private Long cinemaHallId;
    private LocalDateTime startTime;
}
