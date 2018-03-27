package ec.com.core.springrestfulservices.repository;

import ec.com.core.springrestfulservices.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    /*
    @Query("SELECT t FROM STG_CONTACT t where t.numero_identificacion = :id")
    Person findByNumberDocument(@Param("id") String numberDocument);

*/

    /**
     * @param numeroIdentificacion
     * @return
     */
 public Person findByNumeroIdentificacion(String numeroIdentificacion);

 public Person findByCodigoPersona(int codigoPersona);


 }
