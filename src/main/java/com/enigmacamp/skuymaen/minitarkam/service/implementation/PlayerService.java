package com.enigmacamp.skuymaen.minitarkam.service.implementation;

import com.enigmacamp.skuymaen.minitarkam.entity.Player;
import com.enigmacamp.skuymaen.minitarkam.repo.IPlayerRepo;
import com.enigmacamp.skuymaen.minitarkam.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepo playerRepo;

    @Override
    public Player savePlayer(Player player) {
        return playerRepo.save(player);
    }

    @Override
    public List<Player> savePlayers(List<Player> players) {
        return playerRepo.saveAll(players);
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepo.findAll();
    }

    @Override
    public Player getPlayerById(int id) {
        return playerRepo.findById(id).orElse(null);
    }

    @Override
    public List<Player> getPlayersByName(String name) {
        return playerRepo.findByName(name);
    }

    @Override
    public String deletePlayer(int id) {
        Player existingPlayer = playerRepo.findById(id).orElse(null);

        if (existingPlayer == null) return "player not found";

        existingPlayer.setIsActive(false);
        existingPlayer.setIsDeleted(true);

        Player deletedPlayer = playerRepo.save(existingPlayer);

        return "player deleted: " + deletedPlayer.getId();
//        return null;
    }

    @Override
    public Player updatePlayer(Player player) {
        Player existingPlayer = playerRepo.findById(player.getId()).orElse(null);

        if (existingPlayer == null) return null;

        existingPlayer.setName(player.getName());
        existingPlayer.setBirthDate(player.getBirthDate());
        existingPlayer.setCitizenship(player.getCitizenship());
        existingPlayer.setHeight(player.getHeight());
        existingPlayer.setPosition(player.getPosition());
        existingPlayer.setGoal(player.getGoal());
        existingPlayer.setSkill(player.getSkill());
        existingPlayer.setClub(player.getClub());

        return playerRepo.save(existingPlayer);
//        return null;
    }
}
