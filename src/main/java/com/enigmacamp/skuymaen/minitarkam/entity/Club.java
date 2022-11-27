package com.enigmacamp.skuymaen.minitarkam.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
    private List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy = "homeClub", fetch = FetchType.LAZY)
    private List<Match> homeMatches = new ArrayList<>();

    @OneToMany(mappedBy = "awayClub", fetch = FetchType.LAZY)
    private List<Match> awayMatches = new ArrayList<>();
}