package br.com.foodwise.platform.gateway.database.jpa.converter;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.gateway.database.jpa.entities.DiagnosticsEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiagnosticsDomainToEntityConverter {

    public DiagnosticsEntity convert(Diagnostics source) {

        var diagnosticsEntity = new DiagnosticsEntity();
        var modelMapper = new ModelMapper();

        modelMapper.map(source, diagnosticsEntity);

        return diagnosticsEntity;
    }
}
