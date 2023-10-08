package vn.edu.iuh.fit.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Experience {
    @Id
    @Column(name = "exp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate toDate;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    private LocalDate fromDate;
    private String companyName;
    private String role;
    private String workDescription;


}
