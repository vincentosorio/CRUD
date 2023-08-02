package com.example.demo.talent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/talent")
public class TalentController {

    private final TalentService talentService;

    @Autowired
    public TalentController(TalentService talentService) {
        this.talentService = talentService;
    }

    @GetMapping
    public List<Talent> getTalents(){
        return talentService.getTalent();
    }

    @PostMapping
    public void registerNewTalent(@RequestBody Talent talent){
        talentService.addNewTalent(talent);
    }

    @DeleteMapping(path = "{talentId}")
    public void deleteTalent(@PathVariable("talentId") Long studentId) {
        talentService.deleteTalent(studentId);
    }

    @PutMapping(path =  "{talentId}")
    public void updateTalent(
            @PathVariable("talentId") Long talentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        talentService.updateTalent(talentId,name,email);
    }
}
