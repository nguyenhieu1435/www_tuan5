package vn.edu.iuh.fit.irepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.model.Candidate;

@Repository
public interface ICandidateRepository extends PagingAndSortingRepository<Candidate, Long>, CrudRepository<Candidate, Long> {

    public boolean deleteCandidateById(long id);
}
