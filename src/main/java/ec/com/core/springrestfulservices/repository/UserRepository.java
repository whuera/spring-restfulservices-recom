package ec.com.core.springrestfulservices.repository;

import ec.com.core.springrestfulservices.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository <UserApp extends Person> extends JpaRepository<Person, Integer> {

}
