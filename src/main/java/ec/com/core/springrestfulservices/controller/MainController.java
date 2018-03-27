package ec.com.core.springrestfulservices.controller;

import java.util.List;

import ec.com.core.springrestfulservices.model.*;
import ec.com.core.springrestfulservices.repository.ContactRepository;
import ec.com.core.springrestfulservices.service.impl.AddressServiceImpl;
import ec.com.core.springrestfulservices.service.impl.CreditCardServiceImpl;
import ec.com.core.springrestfulservices.service.impl.PersonServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.com.core.springrestfulservices.service.BeerService;
import ec.com.core.springrestfulservices.service.impl.ContactServiceImpl;

import javax.validation.Valid;

/**
 * The Class MainController.
 */
@RestController
@RequestMapping(path="/")
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/** The beer service. */
	// @Autowired
	// BeerService beerService;
	
	/** The contact service impl. */
	@Autowired
	ContactServiceImpl contactServiceImpl;
	@Autowired
	ContactRepository contactRepository;

	@Autowired
	PersonServiceImpl personServiceImpl;

	@Autowired
    AddressServiceImpl addressServiceImpl;

	@Autowired
	CreditCardServiceImpl creditCardServiceImpl;


	
	 /**
 	 * Gets the all beers.
 	 *
 	 * @return the all beers
 	 */
	 /*
 	@RequestMapping(value="/getAllBeers", method = RequestMethod.GET)
		public ResponseEntity<List<Beer>> getAllBeers(){
		logger.info("dentro de metodo ");
			return new ResponseEntity<List<Beer>>(beerService.getAllBeers(), HttpStatus.OK);

		}
		*/
	 
	 /**
 	 * Gets the all contacts.
 	 *
 	 * @return the all contacts
 	 */
	 @CrossOrigin(origins = "http://localhost:4200")
 	 @RequestMapping(value="/getAllContacts", method = RequestMethod.GET)
		public ResponseEntity<List<Contact>> getAllContacts(){
		 logger.info("dentro de metodo contacts ");
			return new ResponseEntity<List<Contact>>(contactServiceImpl.getAllContacts(), HttpStatus.OK);

		}
	 
	 /**
 	 * Save contact.
 	 *
 	 * @param contact the contact
 	 * @return the response entity
 	 */
	 @CrossOrigin(origins = "http://localhost:4200")
     @RequestMapping(value="/saveContact", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Contact> saveContact(@RequestBody Contact contact){
		 logger.info("dentro de metodo save contact ");
			return new ResponseEntity<Contact>( contactServiceImpl.saveContact(contact),HttpStatus.CREATED);
		}


    /**
     * Method controller search contact object by id
     * @param idContact : long
     * @return
     */
    @RequestMapping(value="/getContactById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contact> getContactById(@PathVariable(value = "id") int idContact) {
		logger.info("dentro de metodo getContactById: "+idContact);
        Contact contact = contactServiceImpl.getContactById(idContact);
        if(contact == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(contact);
    }

	/**
	 * Method for update contact object
	 * @param idContact
	 * @param contact
	 * @return
	 */

	//@RequestMapping(value="/{id}/updateContact", method = RequestMethod.PUT)
	@PutMapping("/updateContact/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable(value = "id") int idContact,
										   @Valid @RequestBody Contact contact) {
		logger.info("dentro de metodo update contact "+idContact);
		ec.com.core.springrestfulservices.model.Contact contactInMem = contactRepository.findOne(idContact);
		if(contactInMem == null) {
			return ResponseEntity.notFound().build();
		}
		else{
			contactInMem = contact;
			contactInMem.setStatus("1");
		}
		return ResponseEntity.ok(contactServiceImpl.saveContact(contactInMem));
	}

	/**
	 * Method to logic delete from DB
	 * @param idContact
	 * @return
	 */
	@PutMapping("/deleteContact/{id}")
	public ResponseEntity<Contact> deleteContact(@PathVariable(value = "id") int idContact) {
		logger.info("dentro de metodo delete contact "+idContact);
		Contact contactDel = contactRepository.findOne(idContact);
		if(contactDel == null) {
			return ResponseEntity.notFound().build();
		}
		contactDel.setStatus("0");
		return ResponseEntity.ok(contactServiceImpl.saveContact(contactDel));
	}


	@RequestMapping(value="/getPersonByNumberDocument/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPersonByNumberDocument(@PathVariable(value = "id") String numberDocument) {
		logger.info("dentro de metodo getContactByNumberDocument: "+numberDocument);
		//Contact contact = contactServiceImpl.getContactById(idContact);
		Person person = personServiceImpl.getPersonByNumberDocument(numberDocument);
		if(person == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(person);
	}


    @RequestMapping(value="/getPersonByCode/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPersonByCode(@PathVariable(value = "id") int id) {
        logger.info("dentro de metodo getPersonByCode: "+id);

        Person person = personServiceImpl.getPersonByCode(id);
        if(person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(person);
    }

    @RequestMapping(value="/getAddressByCodePerson/{codePerson}", method = RequestMethod.GET)
	public ResponseEntity<List<Address>> getAddressByCodePerson(@PathVariable(value = "codePerson") int codePerson) {
		logger.info("dentro de metodo getAddressByCodePerson: "+codePerson);
		List<Address> addressPerson = addressServiceImpl.getAddressByCodePerson(codePerson);
		if(addressPerson == null) {
			return ResponseEntity.notFound().build();
		}
        return new ResponseEntity<List<Address>>(addressPerson, HttpStatus.OK);

    }

	/**
	 * controller for creditcard service
	 * @param numberDocument
	 * @return
	 */
	@RequestMapping(value="/getCreditCardByNumberDocument/{numberDocument}", method = RequestMethod.GET)
	public ResponseEntity<List<CredictCard>> getCreditCardByNumberDocument(@PathVariable(value = "numberDocument") String numberDocument) {
		logger.info("dentro de metodo getCreditCardByNumberDocument: "+numberDocument);
		List<CredictCard> creditCardList = creditCardServiceImpl.getCreditCardByNumberDocument(numberDocument);
		if(creditCardList == null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<CredictCard>>(creditCardList, HttpStatus.OK);

	}

}