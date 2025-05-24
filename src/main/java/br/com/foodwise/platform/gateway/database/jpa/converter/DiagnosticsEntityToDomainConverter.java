package br.com.foodwise.platform.gateway.database.jpa.converter;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.gateway.database.jpa.entities.DiagnosticsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiagnosticsEntityToDomainConverter {

    public Diagnostics convert(DiagnosticsEntity source) {
        return new Diagnostics(source.getId(),
                source.getDiagnosticId(),
                source.getConsultation(),
                source.getPatient(),
                source.getDoctor(),
                source.getSymptoms(),
                source.getPrescriptionsDetails()
        );
    }
}
