package com.enigmacamp.skuymaen.minitarkam.service.implementation;

import com.enigmacamp.skuymaen.minitarkam.entity.Club;
import com.enigmacamp.skuymaen.minitarkam.repo.IClubRepo;
import com.enigmacamp.skuymaen.minitarkam.service.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService implements IClubService {
    @Autowired
    private IClubRepo clubRepo;

    @Override
    public Club saveClub(Club club) {
        return clubRepo.save(club);
    }

    @Override
    public List<Club> saveClubs(List<Club> clubs) {
        return clubRepo.saveAll(clubs);
    }

    @Override
    public List<Club> getClubs() {
        return clubRepo.findAll();
    }

    @Override
    public Club getClubById(int id) {
        return clubRepo.findById(id).orElse(null);
    }

    @Override
    public List<Club> getClubsByName(String name) {
        return clubRepo.findByName(name);
    }

    @Override
    public String deleteClub(int id) {
        Club existingClub = clubRepo.findById(id).orElse(null);

        if (existingClub == null) return "club not found";

        existingClub.setIsActive(false);
        existingClub.setIsDeleted(true);

        Club deletedClub = clubRepo.save(existingClub);

        return "club deleted: " + deletedClub.getId();
//        return null;
    }

    @Override
    public Club updateClub(Club club) {
        Club existingClub = clubRepo.findById(club.getId()).orElse(null);

        if (existingClub == null) return null;

        existingClub.setCity(club.getCity());
        existingClub.setName(club.getName());
        existingClub.setPlayers(club.getPlayers());
        existingClub.setHomeMatches(club.getHomeMatches());
        existingClub.setAwayMatches(club.getAwayMatches());

        return clubRepo.save(existingClub);
//        return null;
    }
}
