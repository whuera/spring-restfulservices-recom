package ec.com.core.springrestfulservices.repository;

import ec.com.core.springrestfulservices.model.Auditor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditorRepository extends JpaRepository<Auditor, Integer> {

    public List<Auditor> findByCodPersonQuery(int codPerson);

    @Query("SELECT sum((p.counter)*0.25) FROM Auditor p WHERE p.codPersonQuery = :codePerson")
    public double findCost(@Param("codePerson") int codePerson );

    @Query("SELECT sum(p.counter) FROM Auditor p WHERE p.codPersonQuery = :codePerson")
    public int countRecords(@Param("codePerson") int codePerson );



}
