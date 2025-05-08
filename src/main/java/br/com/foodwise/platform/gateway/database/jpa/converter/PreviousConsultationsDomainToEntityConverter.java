package br.com.foodwise.platform.gateway.database.jpa.converter;

import br.com.foodwise.platform.domain.PreviousConsultations;
import br.com.foodwise.platform.gateway.database.jpa.entities.PreviousConsultationsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PreviousConsultationsDomainToEntityConverter {

    private final DiagnosticsDomainToEntityConverter diagnosticsDomainToEntityConverter;

    public PreviousConsultationsEntity convert(PreviousConsultations source) {
        var previousConsultationsEntity = new PreviousConsultationsEntity();

        var modelMapper = new org.modelmapper.ModelMapper();
        modelMapper.map(source, PreviousConsultationsEntity.class);

        previousConsultationsEntity.setDiagnosticsEntity(diagnosticsDomainToEntityConverter.convert(source.getDiagnostics()));

        return previousConsultationsEntity;
    }
}
