package vn.edu.iuh.fit.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.backend.model.Address;
import vn.edu.iuh.fit.backend.model.Candidate;
import vn.edu.iuh.fit.backend.services.CandidateService;

import java.time.LocalDate;

@SpringBootTest
class CandidateServiceTest {
    @Autowired
    private CandidateService candidateService;

    @Test
    void insert() {
        try {
            candidateService.insert(new Candidate("Nguyen Van A", "091231231","username1" , "123456", "abc@gmail.com",
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