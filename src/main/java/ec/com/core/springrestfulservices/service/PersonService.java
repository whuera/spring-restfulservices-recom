package ec.com.core.springrestfulservices.service;

import ec.com.core.springrestfulservices.model.Person;

public interface PersonService {
    /**
     * get person by number document
     * @param numberDocument
     * @return
     */
    public Person getPersonByNumberDocument(String numberDocument);

    public Person getPersonById (int id);

    public Person getPersonByCode(int id);
}
