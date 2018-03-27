package ec.com.core.springrestfulservices.service;

import ec.com.core.springrestfulservices.model.CredictCard;

import java.util.List;

public interface CreditCardService {

    /**
     * service interface
     * @param numberDocument
     * @return
     */
    public List<CredictCard> getCreditCardByNumberDocument(String numberDocument);
}
