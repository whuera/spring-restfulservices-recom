package ec.com.core.springrestfulservices.service.impl;

import ec.com.core.springrestfulservices.model.Address;
import ec.com.core.springrestfulservices.repository.AddressRepository;
import ec.com.core.springrestfulservices.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> getAddressByCodePerson(int codePerson) {
        return addressRepository.findByCodePerson(codePerson);
    }
}
