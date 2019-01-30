package ec.com.core.springrestfulservices.service.impl;

import ec.com.core.springrestfulservices.model.Auditor;
import ec.com.core.springrestfulservices.repository.AuditorRepository;
import ec.com.core.springrestfulservices.service.AuditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditorServiceImpl implements AuditorService {

    @Autowired
    AuditorRepository auditorRepository;
    @Override
    public Auditor saveAuditor(Auditor auditor) {
        return auditorRepository.save(auditor);
    }

    @Override
    public List<Auditor> getListAuditorByCodePerson(int codePerson) {
        return auditorRepository.findByCodPersonQuery(codePerson);
    }

    @Override
    public double getCost(int codePerson) {
        return auditorRepository.findCost(codePerson);
    }
}
