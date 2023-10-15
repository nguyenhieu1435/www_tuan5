package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.irepositories.ISkillRepository;
import vn.edu.iuh.fit.backend.model.Skill;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    private ISkillRepository skillRepository;
    @Autowired
    public SkillService(ISkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }
    @Transactional
    public boolean insert(Skill skill){
        skillRepository.save(skill);
        return true;
    }
    @Transactional
    public boolean update(Skill skill){
        skillRepository.save(skill);
        return true;
    }
    @Transactional
    public boolean delete(long id){
        skillRepository.deleteSkillById(id);
        return true;
    }
    @Transactional(readOnly = true)
    public Optional<Skill> findOne(long id){
        return skillRepository.findById(id);

    }
    @Transactional(readOnly = true)
    public List<Skill> findAll(int page, int size){
        return skillRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending()))
                .getContent();
    }
}
