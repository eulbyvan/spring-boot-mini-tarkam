package com.enigmacamp.skuymaen.minitarkam.service;

import com.enigmacamp.skuymaen.minitarkam.entity.Player;

import java.util.List;

public interface IPlayerService {
    Player savePlayer(Player player);
    List<Player> savePlayers(List<Player> players);
    List<Player> getPlayers();
    Player getPlayerById(int id);
    List<Player> getPlayersByName(String name);
    String deletePlayer(int id);
    Player updatePlayer(Player player);
}