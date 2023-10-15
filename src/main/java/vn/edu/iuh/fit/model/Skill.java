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
    @Column(name = "skill_type", columnDefinition = "tinyint(4)", nullable = false)
    private SkillType type;
    @Column(name = "skill_name", columnDefinition = "varchar(150)", nullable = false)
    private String skillName;
    @Column(name = "skill_desc", columnDefinition = "varchar(300)", nullable = false)
    private String skillDescription;
    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobSkill> jobSkills;

    public Skill(long id) {
        this.id = id;
    }

    public Skill(SkillType type, String skillName, String skillDescription) {
        this.type = type;
        this.skillName = skillName;
        this.skillDescription = skillDescription;
    }
}
