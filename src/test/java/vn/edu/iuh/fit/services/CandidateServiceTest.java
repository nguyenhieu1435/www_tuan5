package vn.edu.iuh.fit.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.model.Address;
import vn.edu.iuh.fit.model.Candidate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CandidateServiceTest {
    @Autowired
    private CandidateService candidateService;

    @Test
    void insert() {
        try {
            candidateService.insert(new Candidate("Nguyen Van A", "091231231", "abc@gmail.com",
                    LocalDate.now(), new Address(1L)));
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