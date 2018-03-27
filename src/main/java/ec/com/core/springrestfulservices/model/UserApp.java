package ec.com.core.springrestfulservices.model;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name="APP_USERS")
@PrimaryKeyJoinColumn(name = "CODIGO_PERSONA")
public class UserApp extends Person{
    /*
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID_USER")
    private int idUser;
*/
    @Column(name = "LOGIN", length = 50)
    private String login;

    @Column(name = "PASSWORD", length = 100)
    private String passwd;

    @Column(name = "TOKEN", length = 80)
    private String token;

    @Column(name = "IP_ADDRESS", length = 50)
    private String ip;

    @Column(name = "DEVICE", length = 50)
    private String device;

    @Column(name = "OBSERVATION", length = 50)
    private String observation;

    @Column(name = "ROL_USER", length = 50)
    private int idRolUser;

    @Column(name = "LEVEL", length = 50)
    private String levelAccess;

    public int getIdRolUser() {
        return idRolUser;
    }

    public void setIdRolUser(int idRolUser) {
        this.idRolUser = idRolUser;
    }

    public String getLevelAccess() {
        return levelAccess;
    }

    public void setLevelAccess(String levelAccess) {
        this.levelAccess = levelAccess;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
