package ec.com.core.springrestfulservices.repository;

import ec.com.core.springrestfulservices.model.Person;
import ec.com.core.springrestfulservices.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserApp, Integer> {

    public UserApp findByCodigoPersona(int codigoPersona);

    @Query("SELECT p FROM UserApp p WHERE p.login = :login and p.passwd =:passwd and p.userStatus =:status")
    public UserApp findByLoginAndPasswd(@Param("login") String login, @Param("passwd") String passwd, @Param("status") String status);

}
