package vn.edu.iuh.fit.model.ids;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.model.Job;
import vn.edu.iuh.fit.model.Skill;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class JobSkillId implements Serializable {
    private long job;
    private long skill;
}

