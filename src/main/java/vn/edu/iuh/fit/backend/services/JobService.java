package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.irepositories.IJobRepository;
import vn.edu.iuh.fit.backend.model.Job;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private IJobRepository jobRepository;
    @Autowired
    public JobService(IJobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    @Transactional
    public boolean insert(Job job){
        jobRepository.save(job);
        return true;
    }
    @Transactional
    public boolean update(Job job){
        jobRepository.save(job);
        return true;
    }
    @Transactional
    public boolean delete(long id){
        return jobRepository.deleteJobById(id);
    }
    @Transactional(readOnly = true)
    public Optional<Job> findOne(long id){
        return jobRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public List<Job> findAll(int page, int size){
        return jobRepository.findAll(PageRequest.of(page, size
                , Sort.by("id").descending())).getContent();
    }
}
