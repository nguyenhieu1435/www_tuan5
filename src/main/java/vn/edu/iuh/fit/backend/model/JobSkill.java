package vn.edu.iuh.fit.backend.model;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.model.ids.JobSkillId;

@Entity
@Table(name = "job_skill")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(JobSkillId.class)
public class JobSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;
    @Column(name = "skill_level", columnDefinition = "tinyint(4)", nullable = false)
    private SkillLevel skillLevel;
    @Column(name = "more_infos", columnDefinition = "varchar(1000)")
    private String moreInfo;

    @Override
    public String toString() {
        return "JobSkill{" +
                "job=" + job +
                ", skill=" + skill +
                ", skillLevel=" + skillLevel +
                ", moreInfo='" + moreInfo + '\'' +
                '}';
    }
}
