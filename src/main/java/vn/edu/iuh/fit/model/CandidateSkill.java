package vn.edu.iuh.fit.model;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.SkillLevel;
import vn.edu.iuh.fit.model.ids.CandidateSkillId;

@Entity
@Table(name = "candidate_skill")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@IdClass(CandidateSkillId.class)
public class CandidateSkill {

    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    @Column(columnDefinition = "tinyint(4)", name = "skill_level", nullable = false)
    private SkillLevel skillLevel;

    @Column(name = "more_infos", columnDefinition = "varchar(1000)")
    private String moreInfo;

}
