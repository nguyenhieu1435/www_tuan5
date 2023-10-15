package vn.edu.iuh.fit.backend.irepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.model.Skill;
@Repository
public interface ISkillRepository extends PagingAndSortingRepository<Skill, Long>, CrudRepository<Skill, Long> {
    public boolean deleteSkillById(long id);
}
