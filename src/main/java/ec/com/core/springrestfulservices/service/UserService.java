package ec.com.core.springrestfulservices.service;

import ec.com.core.springrestfulservices.model.UserApp;

public interface UserService {

    public UserApp getUserByCodePerson(int codigoPersona);

    public UserApp saveCredentialsUser(UserApp user);

    public UserApp getUserByCredentials(String login, String password, String status);

}
