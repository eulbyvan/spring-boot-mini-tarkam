package com.enigmacamp.skuymaen.minitarkam.entity;

import com.enigmacamp.skuymaen.minitarkam.constants.Position;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "birth_date")
    private Date birthDate;
    private String citizenship;
    private Double height;

    @Enumerated(EnumType.STRING)
    private Position position;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Club club;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
