package com.example.demo.talent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TalentRepository extends JpaRepository<Talent, Long> {
    @Query("SELECT s FROM Talent s where s.email = ?1")
    Optional<Talent> findTalentByEmail(String email);
}
