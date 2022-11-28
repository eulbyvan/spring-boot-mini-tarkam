package com.enigmacamp.skuymaen.minitarkam.repo;

import com.enigmacamp.skuymaen.minitarkam.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPlayerRepo extends JpaRepository<Player, Integer> {
    List<Player> findByName(String name);
}
