package vn.edu.iuh.fit.model;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.SkillLevel;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "candidate")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Candidate {
    @Id
    @Column(name = "can_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String fullName;
   private String phone;
   private String email;
   private LocalDate dob;
   @OneToOne
   @JoinColumn(name = "add_id")
   private Address address;
   @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<CandidateSkill> candidateSkills;
   @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Experience> experiences;
}
