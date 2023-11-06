package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.irepositories.IExperienceRepository;
import vn.edu.iuh.fit.backend.model.Experience;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {
    private IExperienceRepository iExperienceRepository;
    @Autowired
    public ExperienceService(IExperienceRepository iExperienceRepository) {
        this.iExperienceRepository = iExperienceRepository;
    }
    @Transactional
    public boolean insert(Experience experience){
        iExperienceRepository.save(experience);
        return true;
    }
    @Transactional
    public boolean update(Experience experience){
        iExperienceRepository.save(experience);
        return true;
    }
    @Transactional
    public boolean delete(long id){
        return iExperienceRepository.deleteExperienceById(id);
    }
    @Transactional(readOnly = true)
    public Optional<Experience> findOne(long id){
        return iExperienceRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public List<Experience> findAll(int page, int size){
        return iExperienceRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending())).getContent();
    }
}
