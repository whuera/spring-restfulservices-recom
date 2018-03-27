package ec.com.core.springrestfulservices.service;

import ec.com.core.springrestfulservices.model.Address;

import java.util.List;

public interface AddressService {

    public List<Address> getAddressByCodePerson(int codePerson);
}
