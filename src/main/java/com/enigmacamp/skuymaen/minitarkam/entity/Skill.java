package com.enigmacamp.skuymaen.minitarkam.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 10)
    private Integer agility;
    @Column(name = "shoot_power")
    private Integer shootPower;
    @Column(length = 10)
    private Integer strength;
    @Column(length = 10)
    private Integer reflex;
    @Column(length = 10)
    private Integer dribble;
    @Column(length = 10)
    private Integer stamina;
    @Column(length = 10)
    private Integer determination;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "player_id")
    private Player player;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
