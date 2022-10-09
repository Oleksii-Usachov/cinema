package com.example.cinema.repository.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long movieId;
    private LocalDateTime startTime;
    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Set<Seat> seats;
}
