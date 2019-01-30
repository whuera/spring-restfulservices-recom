package ec.com.core.springrestfulservices.controller;

import java.util.List;
import java.util.UUID;

import ec.com.core.springrestfulservices.model.*;
import ec.com.core.springrestfulservices.repository.ContactRepository;
import ec.com.core.springrestfulservices.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The Class MainController.
 */
@RestController
@CrossOrigin
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

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	AuditorServiceImpl auditorServiceImpl;


	
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

	/**
	 * get credentials for login
	 * @param codigoPersona
	 * @return
	 */
	@RequestMapping(value="/getUserByCodePerson/{codigoPersona}", method = RequestMethod.GET)
	public ResponseEntity<UserApp> getUserByCodePerson(@PathVariable(value = "codigoPersona") int codigoPersona) {
		logger.info("dentro de metodo getUserByCodePerson: "+codigoPersona);
		UserApp userApp = userServiceImpl.getUserByCodePerson(codigoPersona);
		if(userApp == null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<UserApp>(userApp, HttpStatus.OK);

	}

	/**
	 * save credentials for user access to app
	 * @param userApp
	 * @return
	 */
	@RequestMapping(value="/saveUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserApp> saveUser(@RequestBody UserApp userApp){
		logger.info("dentro de metodo save contact "+userApp);
		return new ResponseEntity<UserApp>( userServiceImpl.saveCredentialsUser(userApp),HttpStatus.CREATED);
	}


	/**
	 * save Object Person
	 * @param person
	 * @return
	 */
	@RequestMapping(value="/savePerson", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> savePerson(@RequestBody Person person){
		logger.info("dentro de metodo save Person "+person);
		return new ResponseEntity<Person>( personServiceImpl.savePerson(person),HttpStatus.CREATED);
	}

    /**
     * get user by credentials request
     * @param userApp
     * @return
     */
	@RequestMapping(value="/getUserByCredentials", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserApp> getUserByCredentials(@RequestBody UserApp userApp) {
		logger.info("dentro de metodo getUserByCredentials: "+userApp.toString());
		UserApp userFromBdd = userServiceImpl.getUserByCredentials(userApp.getLogin(),userApp.getPasswd(), "ACTIVO");
		if(userFromBdd == null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<UserApp>(userFromBdd, HttpStatus.OK);

	}

    /**
     * update user to active user after to register
     * @param id
     * @param userApp
     * @return
     */
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserApp> updateUser(@PathVariable(value = "id") int id,
                                                 @Valid @RequestBody UserApp userApp) {
        logger.info("dentro de metodo update user "+id);
        UserApp userAppInMem = userServiceImpl.getUserByCodePerson(id);
        if(userAppInMem == null) {
            return ResponseEntity.notFound().build();
        }
        else{
            userAppInMem.setUserStatus("ACTIVO");

        }
        return ResponseEntity.ok(userServiceImpl.saveCredentialsUser(userAppInMem));
    }

	@RequestMapping(value="/updateUserByCodePerson/{codigoPersona}", method = RequestMethod.GET)
	public String  updateUserByCodePerson(@PathVariable(value = "codigoPersona") int codigoPersona) {
		logger.info("dentro de metodo updateUserByCodePerson: "+codigoPersona);
		UserApp userApp = userServiceImpl.getUserByCodePerson(codigoPersona);
		if(userApp == null) {
			//return ResponseEntity.notFound().build();
			return "Error en actualizacion de registro";
		}else{
			userApp.setUserStatus("ACTIVO");
			userServiceImpl.saveCredentialsUser(userApp);
		}
		return "Registro Actualizado";

	}

	@RequestMapping(value="/saveAuditor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Auditor> saveAuditor(@RequestBody Auditor auditor){
		logger.info("dentro de metodo save Auditor "+auditor);
		String uniqueID = UUID.randomUUID().toString();
		String idTransacctionToSave = uniqueID.concat("-").concat(auditor.getNumberDocumentQuery());
		auditor.setIdTransaction(idTransacctionToSave);
		return new ResponseEntity<Auditor>( auditorServiceImpl.saveAuditor(auditor),HttpStatus.CREATED);
	}

	/**
	 * list all transactions for user
	 * @param codePerson
	 * @return
	 */
	@RequestMapping(value="/getAuditorByCodePerson/{codePerson}", method = RequestMethod.GET)
	public ResponseEntity<List<Auditor>> getAuditorByCodePerson(@PathVariable(value = "codePerson") int codePerson) {
		logger.info("dentro de metodo getAuditorByCodePerson: "+codePerson);
		List<Auditor> auditorInMem = auditorServiceImpl.getListAuditorByCodePerson(codePerson);
		if(auditorInMem == null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<Auditor>>(auditorInMem, HttpStatus.OK);

	}

	/**
	 * process: return value calculate from all transactions for each users
	 * @param codPerson
	 * @return
	 */
	@RequestMapping(value="/getCostAuditorByCodePerson/{codePerson}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public double getCostAuditorByCodePerson(@PathVariable(value = "codePerson") int codPerson) {
		logger.info("dentro de metodo getCostAuditorByCodePerson: "+codPerson);
		double val_auditor = auditorServiceImpl.getCost(codPerson);
		return val_auditor;
	}


}
