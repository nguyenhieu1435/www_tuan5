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
    @Column(name = "full_name", columnDefinition = "varchar(255)", nullable = false)
    private String fullName;
    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String phone;
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String email;
    @Column(columnDefinition = "date", nullable = false)
    private LocalDate dob;
    @OneToOne
    @JoinColumn(name = "address", referencedColumnName = "add_id", nullable = false)
    private Address address;
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CandidateSkill> candidateSkills;
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Experience> experiences;

    public Candidate(long id) {
        this.id = id;
    }

    public Candidate(String fullName, String phone, String email, LocalDate dob, Address address) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.address = address;
    }
}
