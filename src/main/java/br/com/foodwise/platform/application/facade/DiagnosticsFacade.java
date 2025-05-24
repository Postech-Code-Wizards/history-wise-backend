package br.com.foodwise.platform.application.facade;

import br.com.foodwise.platform.application.facade.converter.DiagnosticsDomainToResponseConverter;
import br.com.foodwise.platform.application.facade.converter.DiagnosticsRequestToDomain;
import br.com.foodwise.platform.application.usecase.diagnostics.CreateDiagnosticsUseCase;
import br.com.foodwise.platform.application.usecase.diagnostics.RetrieveAllDiagnosticsUseCase;
import br.com.foodwise.platform.application.usecase.diagnostics.RetrieveDiagnosticsUseCase;
import br.com.foodwise.platform.application.usecase.diagnostics.UpdateDiagnosticsUseCase;
import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PreviousConsultationsRequest;
import br.com.foodwise.platform.infrastructure.graphql.dtos.response.DiagnosticsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagnosticsFacade {

    private final DiagnosticsRequestToDomain diagnosticsRequestToDomain;
    private final DiagnosticsDomainToResponseConverter diagnosticsDomainToResponseConverter;

    private final CreateDiagnosticsUseCase createDiagnosticsUseCase;
    private final RetrieveAllDiagnosticsUseCase retrieveAllDiagnosticsUseCase;
    private final RetrieveDiagnosticsUseCase retrieveDiagnosticsUseCase;
    private final UpdateDiagnosticsUseCase updateDiagnosticsUseCase;

    public DiagnosticsResponse getById(Long id) {
        var diagnostics = retrieveDiagnosticsUseCase.execute(id);
        return diagnosticsDomainToResponseConverter.convert(diagnostics);
    }

    public List<DiagnosticsResponse> getAll() {
        var diagnosticsList = retrieveAllDiagnosticsUseCase.execute();
        return diagnosticsList.stream().map(diagnosticsDomainToResponseConverter::convert).toList();
    }

    public Diagnostics update(PreviousConsultationsRequest previousConsultationsUpdateRequest) {
        var diagnosticsConverter = diagnosticsRequestToDomain.convert(previousConsultationsUpdateRequest);
        return updateDiagnosticsUseCase.execute(diagnosticsConverter);
    }
}
