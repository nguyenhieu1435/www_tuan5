package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.irepositories.ICandidateRepository;
import vn.edu.iuh.fit.backend.model.Candidate;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    private ICandidateRepository candidateRepository;
    @Autowired
    public CandidateService(ICandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Transactional
    public boolean insert(Candidate candidate) {
        candidateRepository.save(candidate);
        return true;
    }

    @Transactional
    public boolean update(Candidate candidate) {
        candidateRepository.save(candidate);
        return true;
    }

    @Transactional
    public boolean delete(long id) {
        return candidateRepository.deleteCandidateById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Candidate> findOne(long id) {
        return candidateRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDerection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDerection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }


}
