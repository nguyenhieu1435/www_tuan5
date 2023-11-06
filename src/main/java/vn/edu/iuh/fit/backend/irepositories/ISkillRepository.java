package vn.edu.iuh.fit.backend.irepositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.model.Skill;

import java.util.List;

@Repository
public interface ISkillRepository extends PagingAndSortingRepository<Skill, Long>, CrudRepository<Skill, Long> {
    public boolean deleteSkillById(long id);
    @Query("select s from Skill s where s.id not in (select cs.skill.id from CandidateSkill cs where cs.candidate.id " +
            " = :candidateID)")
    public List<Skill> findSkillCandidateShouldLearn(@Param("candidateID") long candidateID);
}
