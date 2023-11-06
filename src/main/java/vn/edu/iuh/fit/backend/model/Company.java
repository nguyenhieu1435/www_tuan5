package vn.edu.iuh.fit.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String username;
    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String password;

    public Company(String name, String about, Address address, String phone, String webURL, String email, String username, String password) {
        this.name = name;
        this.about = about;
        this.address = address;
        this.phone = phone;
        this.webURL = webURL;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", about='" + about + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", webURL='" + webURL + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

