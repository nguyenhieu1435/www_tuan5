package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.irepositories.IAddressRepository;
import vn.edu.iuh.fit.backend.model.Address;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private IAddressRepository addressRepository;

    @Autowired
    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    @Transactional
    public boolean insert(Address address) {
        addressRepository.save(address);
        return true;
    }
    @Transactional
    public boolean update(Address address) {
        addressRepository.save(address);
        return true;
    }
    @Transactional
    public boolean delete(long id){
        return addressRepository.deleteAddressById(id);
    }
    @Transactional(readOnly = true)
    public Optional<Address> findOne(long id){
        return addressRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public List<Address> findAll(int page, int limit) {
        return addressRepository.findAll(
                PageRequest.of(page, limit, Sort.by("id").descending()
                )).getContent();
    }

}
