package vn.edu.iuh.fit.irepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.model.Company;
@Repository
public interface ICompanyRepository extends PagingAndSortingRepository<Company, Long>, CrudRepository<Company, Long> {

    public boolean deleteCompanyById(long id);

}
