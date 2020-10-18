package ec.com.core.springrestfulservices.service.impl;

import ec.com.core.springrestfulservices.model.Person;
import ec.com.core.springrestfulservices.repository.PersonRepository;
import ec.com.core.springrestfulservices.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person getPersonByNumberDocument(String numberDocument){
      return personRepository.findByNumeroIdentificacion(numberDocument);
    }

    @Override
    public Person getPersonById(int id) {
        return null;
    }

    /*
        public Person getPersonById (int id){
            return personRepository.findOne(id);
            //return personRepository.findByCodigoPersona(id);
        }
    */
    public Person getPersonByCode(int id){
        return personRepository.findByCodigoPersona(id);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}

