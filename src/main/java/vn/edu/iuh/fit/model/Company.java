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
    @Column(name = "comp_name", nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(2000)")
    private String about;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "add_id", nullable = false)
    private Address address;
    @Column(nullable = false)
    private String phone;
    @Column(name = "web_url")
    private String webURL;
    @Column(nullable = false)
    private String email;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Job> jobs;
}

