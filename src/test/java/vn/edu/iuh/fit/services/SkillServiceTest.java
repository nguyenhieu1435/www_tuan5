package vn.edu.iuh.fit.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.enums.SkillType;
import vn.edu.iuh.fit.model.Skill;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SkillServiceTest {

    @Autowired
    private SkillService skillService;
    @Test
    void insert() {
        try {
            skillService.insert(new Skill(SkillType.TECHNICAL_SKILL, "lap trinh abc", "abc description"));
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