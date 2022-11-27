package com.enigmacamp.skuymaen.minitarkam.repo;

import com.enigmacamp.skuymaen.minitarkam.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClubRepo extends JpaRepository<Club, Integer> {
    List<Club> findByName(String name);
}
