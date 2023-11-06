package vn.edu.iuh.fit.backend.irepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.model.Company;

import java.util.Optional;

@Repository
public interface ICompanyRepository extends PagingAndSortingRepository<Company, Long>, CrudRepository<Company, Long> {

    public boolean deleteCompanyById(long id);

    public Optional<Company> findCompaniesByUsernameAndPassword(String username, String password);

}
