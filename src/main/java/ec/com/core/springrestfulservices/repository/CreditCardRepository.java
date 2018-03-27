package ec.com.core.springrestfulservices.repository;


import ec.com.core.springrestfulservices.model.CredictCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CredictCard, Integer> {
    /**
     * method get credit card by number document
     * @param numberDocument
     * @return
     */
    public List<CredictCard> findByNumberDocument(String numberDocument);
}
