package br.com.foodwise.platform.gateway.database.jpa.converter;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.gateway.database.jpa.entities.DiagnosticsEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiagnosticsDomainToEntityConverter {

    private final PrescriptionsDetailsDomainToEntityConverter prescriptionsDetailsDomainToEntityConverter;
    private final SymptomsDomainToEntityConverter symptomsDomainToEntityConverter;

    public DiagnosticsEntity convert(Diagnostics source) {
        var diagnosticsEntity = new DiagnosticsEntity();

        var modelMapper = new ModelMapper();
        modelMapper.map(source, DiagnosticsEntity.class);

        diagnosticsEntity.setSymptomsEntity(symptomsDomainToEntityConverter.convert(source.getSymptoms()));
        diagnosticsEntity.setPrescriptionsDetailsEntity(prescriptionsDetailsDomainToEntityConverter.convert(source.getPrescriptionsDetails()));

        return diagnosticsEntity;
    }
}
