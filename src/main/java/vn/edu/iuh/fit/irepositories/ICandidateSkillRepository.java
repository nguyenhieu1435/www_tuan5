package vn.edu.iuh.fit.irepositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.model.CandidateSkill;
import vn.edu.iuh.fit.model.ids.CandidateSkillId;
@Repository
public interface ICandidateSkillRepository extends PagingAndSortingRepository<CandidateSkill, CandidateSkillId>, CrudRepository<CandidateSkill, CandidateSkillId> {
    @Modifying
    @Query("DELETE FROM CandidateSkill CK where CK.candidate.id = :canID and CK.skill.id = :skillID")
    public boolean deleteCandidateSkillByCandidateAndSkill(@Param("canID") long canID, @Param("skillID") long skillID);


}
