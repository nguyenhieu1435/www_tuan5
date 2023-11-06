package vn.edu.iuh.fit.backend.model;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "add_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "smallint(6)")
    private CountryCode country;
    @Column(columnDefinition = "varchar(50)")
    private String city;
    @Column(columnDefinition = "varchar(7)")
    private String zipcode;
    @Column(columnDefinition = "varchar(150)")
    private String street;
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Candidate candidate;
    @Column(columnDefinition = "varchar(20)")
    private String number;
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Company company;

    public Address(long id) {
        this.id = id;
    }

    public Address(CountryCode country, String city, String zipcode, String street, String number) {
        this.country = country;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
        this.number = number;
    }

    public Address(long id, CountryCode country, String city, String zipcode, String street, String number) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country=" + country +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
