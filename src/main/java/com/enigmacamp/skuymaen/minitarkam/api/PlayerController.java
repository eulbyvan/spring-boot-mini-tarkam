package com.enigmacamp.skuymaen.minitarkam.api;

import com.enigmacamp.skuymaen.minitarkam.entity.Player;
import com.enigmacamp.skuymaen.minitarkam.service.implementation.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/player")
@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @PostMapping("/addPlayers")
    public List<Player> addPlayers(@RequestBody List<Player> players) {
        return playerService.savePlayers(players);
    }

    @GetMapping("/findPlayers")
    public List<Player> findPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping(path = "{id}")
    public Player findPlayerById(@PathVariable("id") int id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping(path = "/findByName")
    public List<Player> findPlayerByName(@RequestParam(value = "name") String name) {
        return playerService.getPlayersByName(name);
    }

    @PutMapping("/update")
    public Player updatePlayer(@RequestBody Player player) {
        return playerService.updatePlayer(player);
    }

    @PutMapping("/delete/{id}")
    public String deletePlayer(@PathVariable int id) {
        return playerService.deletePlayer(id);
    }
}
