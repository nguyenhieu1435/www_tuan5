package vn.edu.iuh.fit.services;

import com.neovisionaries.i18n.CountryCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.backend.model.Address;
import vn.edu.iuh.fit.backend.services.AddressService;

@SpringBootTest
class AddressServiceTest {
    @Autowired
    private AddressService addressService;
    @Test
    void insert() {
        try {
            addressService.insert(
                    new Address(CountryCode.VN,"hcm"
                            , "59", "nguyen van bao", "50"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findOne() {
    }

    @Test
    void findAll() {
    }
}