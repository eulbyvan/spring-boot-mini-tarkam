package com.enigmacamp.skuymaen.minitarkam.service;

import com.enigmacamp.skuymaen.minitarkam.entity.Club;

import java.util.List;

public interface IClubService {
    Club saveClub(Club club);
    List<Club> saveClubs(List<Club> clubs);
    List<Club> getClubs();
    Club getClubById(int id);
    List<Club> getClubsByName(String name);
    String deleteClub(int id);
    Club updateClub(Club club);
}
