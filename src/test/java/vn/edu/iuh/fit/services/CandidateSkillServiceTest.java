package vn.edu.iuh.fit.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.enums.SkillLevel;
import vn.edu.iuh.fit.model.Candidate;
import vn.edu.iuh.fit.model.CandidateSkill;
import vn.edu.iuh.fit.model.Skill;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CandidateSkillServiceTest {
    @Autowired
    private CandidateSkillService candidateSkillService;
    @Test
    void insert() {
        try {
            candidateSkillService
                    .insert(new CandidateSkill(
                            new Skill(1L), new Candidate(1L), SkillLevel.MASTER,
                    "more infos"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findOne() {
    }

    @Test
    void findAll() {
    }
}