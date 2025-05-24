package br.com.foodwise.platform.gateway.database.jpa.converter;

import br.com.foodwise.platform.domain.PreviousConsultations;
import br.com.foodwise.platform.gateway.database.jpa.entities.PreviousConsultationsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PreviousConsultationsEntityToDomainConverter {

    private final DiagnosticsEntityToDomainConverter diagnosticsEntityToDomainConverter;

    public PreviousConsultations convert(PreviousConsultationsEntity source) {
        return new PreviousConsultations(source.getId(),
                source.getConsultation(),
                source.getPatient(),
                source.getDoctor(),
                source.getNurse(),
                source.getScheduledAt(),
                source.getCompletedAt(),
                source.getStatus(),
                diagnosticsEntityToDomainConverter.convert(source.getDiagnosticsEntity()),
                source.getCreatedAt()
        );
    }
}
