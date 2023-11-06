package vn.edu.iuh.fit.backend.irepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.model.Experience;
@Repository
public interface IExperienceRepository extends PagingAndSortingRepository<Experience, Long>
        , CrudRepository<Experience, Long> {
    public boolean deleteExperienceById(long id);
}
