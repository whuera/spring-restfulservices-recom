package ec.com.core.springrestfulservices.repository;

import ec.com.core.springrestfulservices.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    /**
     *
     * @param codePerson
     * @return
     */
    public List<Address> findByCodePerson(int codePerson);

}
