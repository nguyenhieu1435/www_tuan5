package vn.edu.iuh.fit.model;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.SkillLevel;

@Entity
@Table(name = "job_skill")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class JobSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    private SkillLevel skillLevel;
    private String moreInfo;
}
