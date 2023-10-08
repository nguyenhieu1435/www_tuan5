package vn.edu.iuh.fit.model;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Address {
    @Id
    @Column(name = "add_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private CountryCode country;
    private String city;
    private String zipcode;
    private String street;
    @OneToOne(mappedBy = "address")
    private Candidate candidate;
    private String number;
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Company company;


}
