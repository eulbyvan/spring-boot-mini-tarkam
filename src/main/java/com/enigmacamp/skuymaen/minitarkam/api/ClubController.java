package com.enigmacamp.skuymaen.minitarkam.api;

import com.enigmacamp.skuymaen.minitarkam.entity.Club;
import com.enigmacamp.skuymaen.minitarkam.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/club")
@RestController
public class ClubController {
    @Autowired
    private ClubService clubService;

    @PostMapping("/addClub")
    public Club addClub(@RequestBody Club club) {
        return clubService.saveClub(club);
    }

    @PostMapping("/addClubs")
    public List<Club> addClubs(@RequestBody List<Club> clubs) {
        return clubService.saveClubs(clubs);
    }

    @GetMapping("/findClubs")
    public List<Club> findClubs() {
        return clubService.getClubs();
    }

    @GetMapping(path = "{id}")
    public Club findClubById(@PathVariable("id") int id) {
        return clubService.getClubById(id);
    }

    @GetMapping(path = "/findByName")
    public List<Club> findClubByName(@RequestParam(value = "name") String name) {
        return clubService.getClubsByName(name);
    }

    @PutMapping("/update")
    public Club updateClub(@RequestBody Club club) {
        return clubService.updateClub(club);
    }

    @PutMapping("/delete/{id}")
    public String deleteClub(@PathVariable int id) {
        return clubService.deleteClub(id);
    }
}
