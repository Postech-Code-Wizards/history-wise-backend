package br.com.foodwise.platform.gateway.database.jpa;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.gateway.database.DiagnosticsGateway;
import br.com.foodwise.platform.gateway.database.jpa.converter.DiagnosticsDomainToEntityConverter;
import br.com.foodwise.platform.gateway.database.jpa.converter.DiagnosticsEntityToDomainConverter;
import br.com.foodwise.platform.gateway.database.jpa.repositories.DiagnosticsRepository;
import br.com.foodwise.platform.infrastructure.graphql.controller.exception.CustomExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DiagnosticsJpaGateway implements DiagnosticsGateway {

    private final DiagnosticsRepository diagnosticsRepository;
    private final DiagnosticsDomainToEntityConverter diagnosticsDomainToEntityConverter;
    private final DiagnosticsEntityToDomainConverter diagnosticsEntityToDomainConverter;

    @Override
    public Diagnostics save(Diagnostics diagnostics) {
        var diagnosticsEntity = diagnosticsDomainToEntityConverter.convert(diagnostics);
        var diagnosticsSaved = diagnosticsRepository.save(diagnosticsEntity);
        return diagnosticsEntityToDomainConverter.convert(diagnosticsSaved);
    }

    @Override
    public List<Diagnostics> findAll() {
        var diagnosticsEntityList = diagnosticsRepository.findAll();
        return diagnosticsEntityList.stream().map(diagnosticsEntityToDomainConverter::convert).toList();
    }

    @Override
    public Diagnostics findById(Long id) {
        var diagnosticsEntity = diagnosticsRepository.findById(id)
                .orElseThrow(() -> new CustomExceptionHandler("error.not_found", "Diagnóstico " +id));
        return diagnosticsEntityToDomainConverter.convert(diagnosticsEntity);
    }

    @Override
    public Diagnostics findByIdOrSave(Diagnostics diagnostics) {
        var diagnosticsEntity = diagnosticsRepository.findById(diagnostics.getId())
                .orElse(null);
        if (diagnosticsEntity == null) {
            return save(diagnostics);
        }
        return diagnosticsEntityToDomainConverter.convert(diagnosticsEntity);
    }
}
