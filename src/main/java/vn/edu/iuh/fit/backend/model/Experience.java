package vn.edu.iuh.fit.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Experience {
    @Id
    @Column(name = "exp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "to_date", columnDefinition = "date", nullable = false)
    private LocalDate toDate;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Column(name = "from_date", columnDefinition = "date", nullable = false)
    private LocalDate fromDate;
    @Column(name = "company", columnDefinition = "varchar(120)", nullable = false)
    private String companyName;
    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String role;
    @Column(name = "work_desc", columnDefinition = "varchar(400)", nullable = false)
    private String workDescription;

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", toDate=" + toDate +
                ", candidate=" + candidate +
                ", fromDate=" + fromDate +
                ", companyName='" + companyName + '\'' +
                ", role='" + role + '\'' +
                ", workDescription='" + workDescription + '\'' +
                '}';
    }
}
