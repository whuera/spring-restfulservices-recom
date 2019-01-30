package ec.com.core.springrestfulservices.service.impl;

import ec.com.core.springrestfulservices.model.UserApp;
import ec.com.core.springrestfulservices.repository.UserRepository;
import ec.com.core.springrestfulservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserApp getUserByCodePerson(int codigoPersona) {
        return userRepository.findByCodigoPersona(codigoPersona);
    }

    @Override
    public UserApp saveCredentialsUser(UserApp user) {
        return userRepository.save(user);
    }

    @Override
    public UserApp getUserByCredentials(String login, String password, String status) {

        return userRepository.findByLoginAndPasswd(login,password, status);
    }


}
