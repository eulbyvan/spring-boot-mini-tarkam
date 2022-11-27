package com.enigmacamp.skuymaen.minitarkam.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "t_goal")
@ToString
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;

    @Column(name = "total_goal_scored")
    private @Getter @Setter Integer totalGoalScored;

    @OneToOne
    @JoinColumn(name = "player_id")
    private @Getter @Setter @ToString.Exclude Player player;

    @OneToOne
    @JoinColumn(name = "match_id")
    private @Getter @Setter @ToString.Exclude Match match;
}