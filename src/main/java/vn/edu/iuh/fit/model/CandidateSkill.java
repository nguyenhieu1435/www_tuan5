package vn.edu.iuh.fit.model;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.SkillLevel;

@Entity
@Table(name = "candidate_skill")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CandidateSkill {
    private SkillLevel skillLevel;
    @Id
    @OneToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    private String moreInfo;

}
