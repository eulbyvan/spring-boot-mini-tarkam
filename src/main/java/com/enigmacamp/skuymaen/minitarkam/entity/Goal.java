package com.enigmacamp.skuymaen.minitarkam.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_goal")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_goal_scored")
    private Integer totalGoalScored;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @OneToOne
    @JoinColumn(name = "match_id")
    private Match match;
}