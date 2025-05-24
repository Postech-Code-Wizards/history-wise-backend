package br.com.foodwise.platform.gateway.database.jpa.converter;

import br.com.foodwise.platform.domain.PreviousConsultations;
import br.com.foodwise.platform.gateway.database.jpa.entities.PreviousConsultationsEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PreviousConsultationsDomainToEntityConverter {

    private final DiagnosticsDomainToEntityConverter diagnosticsDomainToEntityConverter;

    public PreviousConsultationsEntity convert(PreviousConsultations source) {
        var prevNew = new PreviousConsultationsEntity();
        var modelMapper = new ModelMapper();
        modelMapper.map(source, prevNew);

        prevNew.setDiagnosticsEntity(diagnosticsDomainToEntityConverter.convert(source.getDiagnostics()));

        return prevNew;
    }
}
