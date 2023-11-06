package vn.edu.iuh.fit.backend.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "candidate")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Candidate {
    @Id
    @Column(name = "can_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "full_name", columnDefinition = "varchar(255)", nullable = false)
    private String fullName;
    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String phone;
    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String username;
    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String password;
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String email;
    @DateTimeFormat(pattern="yyyy-MM-dd")
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

    public Candidate(long id, String fullName, String phone, String username, String password, String email, LocalDate dob, Address address) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.address = address;
    }

    public Candidate(String fullName, String phone, String username, String password, String email, LocalDate dob, Address address) {
        this.fullName = fullName;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", address=" + address +
                '}';
    }
}
