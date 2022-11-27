package com.enigmacamp.skuymaen.minitarkam.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "home_score")
    private Integer homeScore;
    @Column(name = "away_score")
    private Integer awayScore;
    @Column(name = "is_finished")
    private Boolean isFinished = false;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private Club homeClub;

    @ManyToOne
    @JoinColumn(name = "away_id")
    private Club awayClub;
}