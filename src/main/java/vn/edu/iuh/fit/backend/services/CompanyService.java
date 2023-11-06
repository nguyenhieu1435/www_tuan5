package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.irepositories.ICompanyRepository;
import vn.edu.iuh.fit.backend.model.Company;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private ICompanyRepository companyRepository;
    @Autowired
    public CompanyService(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @Transactional
    public boolean insert(Company company){
        companyRepository.save(company);
        return true;
    }
    @Transactional
    public boolean update(Company company){
        companyRepository.save(company);
        return true;
    }
    @Transactional
    public boolean delete(long id){
        return companyRepository.deleteCompanyById(id);
    }
    @Transactional(readOnly = true)
    public Optional<Company> findOne(long id){
        return companyRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public List<Company> findAll(int page, int size){
        return companyRepository.findAll(PageRequest.of(page, size,
                Sort.by("id").descending())).getContent();
    }
}
