package ec.com.core.springrestfulservices.service.impl;

import ec.com.core.springrestfulservices.model.CredictCard;
import ec.com.core.springrestfulservices.repository.CreditCardRepository;
import ec.com.core.springrestfulservices.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    public List<CredictCard> getCreditCardByNumberDocument(String numberDocument) {
        return creditCardRepository.findByNumberDocument(numberDocument);
    }
}
