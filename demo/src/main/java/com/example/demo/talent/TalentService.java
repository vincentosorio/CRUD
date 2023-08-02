package com.example.demo.talent;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TalentService {

    private final TalentRepository talentRepository;

    @Autowired
    public TalentService(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
    }

    public List<Talent> getTalent(){
        return talentRepository.findAll();
    }

    public void addNewTalent(Talent talent) {
        Optional<Talent> talentOptional = talentRepository
                .findTalentByEmail(talent.getEmail());

        if (talentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        talentRepository.save(talent);
    }

    public void deleteTalent(Long talendId){
        boolean exists = talentRepository.existsById(talendId);
        if (!exists){
            throw new IllegalStateException("talent with id "+ talendId + " does not exists");
        }
        talentRepository.deleteById(talendId);
    }

    @Transactional
    public void updateTalent(Long talentId,
                              String name,
                              String email){
        Talent talent = talentRepository.findById(talentId)
                .orElseThrow(() -> new IllegalStateException(
                        "talent with id " + talentId + " does not exist")
                );


        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(talent.getName(), name)) {
            talent.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(talent.getEmail(), email)) {
            Optional<Talent> talentOptional = talentRepository
                    .findTalentByEmail(email);
            if (talentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            talent.setEmail(email);
        }
    }
}
