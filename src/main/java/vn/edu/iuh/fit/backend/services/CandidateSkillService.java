package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.irepositories.ICandidateSkillRepository;
import vn.edu.iuh.fit.backend.model.CandidateSkill;
import vn.edu.iuh.fit.backend.model.ids.CandidateSkillId;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateSkillService {
    private ICandidateSkillRepository candidateSkillRepository;

    @Autowired
    public CandidateSkillService(ICandidateSkillRepository candidateSkillRepository) {
        this.candidateSkillRepository = candidateSkillRepository;
    }
    @Transactional
    public boolean insert(CandidateSkill candidateSkill) {
        candidateSkillRepository.save(candidateSkill);
        return true;
    }
    @Transactional
    public boolean update(CandidateSkill candidateSkill) {
        candidateSkillRepository.save(candidateSkill);
        return true;
    }
    @Transactional
    public boolean delete(long canID, long skillID) {
        return candidateSkillRepository.deleteCandidateSkillByCandidateAndSkill(canID, skillID);
    }
    @Transactional(readOnly = true)
    public Optional<CandidateSkill> findOne(long canID, long skillID) {
        return candidateSkillRepository.findById(new CandidateSkillId(canID, skillID));
    }
    @Transactional(readOnly = true)
    public List<CandidateSkill> findAll(int page, int size) {
        return candidateSkillRepository.findAll(PageRequest.of(page, size, Sort.by("candidate")
                .descending().and(Sort.by("skill")))).getContent();
    }
}

