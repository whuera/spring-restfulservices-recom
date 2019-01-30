package ec.com.core.springrestfulservices.model;

import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@ToString
@Entity
@DynamicUpdate
@Table(name="APP_AUDITOR")
public class Auditor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID_AUDITOR")
    private int idAuditor;
    @Column(name = "ID_USER_TRANSACTION", length = 100)
    private String idUserTransaction;

    @Column(name = "ID_TRANSACTION", length = 50)
    private String idTransaction;

    @Column(name = "NUMBER_DOCUMENT_QUERY", length = 100)
    private String numberDocumentQuery;

    @Column(name = "COD_PERSON_QUERY")
    private int codPersonQuery;

    @Column(name = "STATUS_QUERY", length = 100)
    private String statusQuery;

    @Column(name = "OBSERVATION_QUERY", length = 100)
    private String observationQuery;

    @Column(name = "DEVICE_QUERY", length = 100)
    private String deviceQuery;

    @Column(name = "DATE_QUERY", length = 100)
    private String dateQuery;

    @Column(name = "COUNTER", length = 100)
    private double counter;

    @Column(name = "IP_CLIENT", length = 50)
    private String ipclient;

    public String getIpclient() {
        return ipclient;
    }

    public void setIpclient(String ipclient) {
        this.ipclient = ipclient;
    }

    public int getIdAuditor() {
        return idAuditor;
    }

    public void setIdAuditor(int idAuditor) {
        this.idAuditor = idAuditor;
    }

    public String getIdUserTransaction() {
        return idUserTransaction;
    }

    public void setIdUserTransaction(String idUserTransaction) {
        this.idUserTransaction = idUserTransaction;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getNumberDocumentQuery() {
        return numberDocumentQuery;
    }

    public void setNumberDocumentQuery(String numberDocumentQuery) {
        this.numberDocumentQuery = numberDocumentQuery;
    }

    public int getCodPersonQuery() {
        return codPersonQuery;
    }

    public void setCodPersonQuery(int codPersonQuery) {
        this.codPersonQuery = codPersonQuery;
    }

    public String getStatusQuery() {
        return statusQuery;
    }

    public void setStatusQuery(String statusQuery) {
        this.statusQuery = statusQuery;
    }

    public String getObservationQuery() {
        return observationQuery;
    }

    public void setObservationQuery(String observationQuery) {
        this.observationQuery = observationQuery;
    }

    public String getDeviceQuery() {
        return deviceQuery;
    }

    public void setDeviceQuery(String deviceQuery) {
        this.deviceQuery = deviceQuery;
    }

    public String getDateQuery() {
        return dateQuery;
    }

    public void setDateQuery(String dateQuery) {
        this.dateQuery = dateQuery;
    }

    public double getCounter() {
        return counter;
    }

    public void setCounter(double counter) {
        this.counter = counter;
    }
}
