package vn.edu.iuh.fit.backend.irepositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.model.Job;

import java.util.List;

@Repository
public interface IJobRepository extends PagingAndSortingRepository<Job, Long>, CrudRepository<Job, Long> {

    public boolean deleteJobById(long id);
    public List<Job> findAllByCompany_Id(long id);
    @Modifying
    @Query("select j from Job j join j.jobSkills jk join jk.skill s join s.candidateSkills ck" +
            " where ck.candidate.id = :candidateID and ck.candidate.address.city = j.company.address.city")
    public List<Job> findAllJobMatchWithCandidate(@Param("candidateID") long candidateID);
}
