package vn.edu.iuh.fit.irepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.model.Job;
@Repository
public interface IJobRepository extends PagingAndSortingRepository<Job, Long>, CrudRepository<Job, Long> {

    public boolean deleteJobById(long id);
}
