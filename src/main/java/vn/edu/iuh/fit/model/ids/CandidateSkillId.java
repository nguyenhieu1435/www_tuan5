package vn.edu.iuh.fit.model.ids;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.model.Candidate;
import vn.edu.iuh.fit.model.Skill;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class CandidateSkillId implements Serializable {
    private long skill;
    private long candidate;

}
