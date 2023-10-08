package vn.edu.iuh.fit.model;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Company {
    @Id
    @Column(name = "com_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String about;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "add_id")
    private Address address;
    private String phone;
    private String webURL;
    private String email;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Job> jobs;
}

