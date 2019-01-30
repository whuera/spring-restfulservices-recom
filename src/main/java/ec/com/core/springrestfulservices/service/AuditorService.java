package ec.com.core.springrestfulservices.service;

import ec.com.core.springrestfulservices.model.Auditor;

import java.util.List;

public interface AuditorService {

    /**
     * save object auditor
     * @param auditor
     * @return
     */
    public Auditor saveAuditor (Auditor auditor);

    public List<Auditor> getListAuditorByCodePerson(int codePerson);

    public double getCost(int codePerson);


}
