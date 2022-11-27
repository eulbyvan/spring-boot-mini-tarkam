package com.enigmacamp.skuymaen.minitarkam.service;

import com.enigmacamp.skuymaen.minitarkam.entity.Club;
import com.enigmacamp.skuymaen.minitarkam.repo.IClubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    @Autowired
    private IClubRepo clubRepo;

    public Club saveClub(Club club) {
        return clubRepo.save(club);
    }

    public List<Club> saveClubs(List<Club> clubs) {
        return clubRepo.saveAll(clubs);
    }

    public List<Club> getClubs() {
        return clubRepo.findAll();
    }

    public Club getClubById(Integer id) {
        return clubRepo.findById(id).orElse(null);
    }

    public List<Club> getClubsByName(String name) {
        return clubRepo.findByName(name);
    }

    public String deleteClub(int id) {
        Club existingClub = clubRepo.findById(id).orElse(null);

        existingClub.setIsActive(false);
        existingClub.setIsDeleted(true);

        Club deletedClub = clubRepo.save(existingClub);

        return "club deleted: " + deletedClub.getId();
    }

    public Club updateClub(Club club) {
        Club existingClub = clubRepo.findById(club.getId()).orElse(null);

        existingClub.setCity(club.getCity());
        existingClub.setName(club.getName());
        existingClub.setPlayers(club.getPlayers());
        existingClub.setHomeMatches(club.getHomeMatches());
        existingClub.setAwayMatches(club.getAwayMatches());

        return clubRepo.save(existingClub);
    }
}
