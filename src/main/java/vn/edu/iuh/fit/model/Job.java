package vn.edu.iuh.fit.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "job")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Job {
    @Id
    @Column(name = "job_id")
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "com_id")
    private Company company;
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobSkill> jobSkills;
    private String description;


}
