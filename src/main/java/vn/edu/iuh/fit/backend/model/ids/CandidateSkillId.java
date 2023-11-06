package vn.edu.iuh.fit.backend.model.ids;

import lombok.*;

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
