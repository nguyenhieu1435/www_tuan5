package vn.edu.iuh.fit.model;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.SkillType;

import java.util.List;

@Entity
@Table(name = "skill")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Skill {
    @Id
    @Column(name = "skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private SkillType type;
    private String skillName;
    private String skillDescription;
    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobSkill> jobSkills;


}
