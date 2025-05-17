package br.com.foodwise.platform.gateway.database.jpa.converter;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.gateway.database.jpa.entities.DiagnosticsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiagnosticsEntityToDomainConverter {

    private final SymptomsEntityToDomainConverter symptomsEntityToDomainConverter;
    private final PrescriptionsDetailsEntityToDomainConverter prescriptionsDetailsEntityToDomainConverter;

    public Diagnostics convert(DiagnosticsEntity source) {
        return new Diagnostics(source.getId(),
                source.getConsultation(),
                source.getPatient(),
                source.getDoctor(),
                symptomsEntityToDomainConverter.convert(source.getSymptomsEntity()),
                prescriptionsDetailsEntityToDomainConverter.convert(source.getPrescriptionsDetailsEntity())
        );
    }
}
