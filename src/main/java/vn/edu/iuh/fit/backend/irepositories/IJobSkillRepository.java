package vn.edu.iuh.fit.backend.irepositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.model.JobSkill;
import vn.edu.iuh.fit.backend.model.ids.JobSkillId;
@Repository
public interface IJobSkillRepository extends PagingAndSortingRepository<JobSkill, JobSkillId>
        , CrudRepository<JobSkill, JobSkillId> {
    @Modifying
    @Query("delete from JobSkill jk where jk.job.id = :jobID and jk.skill.id = :skillID")
    public boolean deleteByJobIdAndSkillId(@Param("jobID") long jobID, @Param("skillID") long skillID);
}
