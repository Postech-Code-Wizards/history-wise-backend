package br.com.foodwise.platform.application.facade;

import br.com.foodwise.platform.application.facade.converter.DiagnosticsDomainToResponseConverter;
import br.com.foodwise.platform.application.facade.converter.DiagnosticsRequestToDomain;
import br.com.foodwise.platform.application.usecase.diagnostics.CreateDiagnosticsUseCase;
import br.com.foodwise.platform.application.usecase.diagnostics.RetrieveAllDiagnosticsUseCase;
import br.com.foodwise.platform.application.usecase.diagnostics.RetrieveDiagnosticsUseCase;
import br.com.foodwise.platform.application.usecase.diagnostics.UpdateDiagnosticsUseCase;
import br.com.foodwise.platform.application.usecase.prescriptionsDetails.RetrievePrescriptionsDetailsUseCase;
import br.com.foodwise.platform.application.usecase.symptom.RetrieveSymptomUseCase;
import br.com.foodwise.platform.domain.PrescriptionsDetails;
import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.infrastructure.rest.dtos.request.DiagnosticsRequest;
import br.com.foodwise.platform.infrastructure.rest.dtos.response.DiagnosticsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagnosticsFacade {

    private final DiagnosticsRequestToDomain diagnosticsRequestToDomain;
    private final DiagnosticsDomainToResponseConverter diagnosticsDomainToResponseConverter;

    private final RetrieveSymptomUseCase retrieveSymptomUseCase;
    private final RetrievePrescriptionsDetailsUseCase retrievePrescriptionsDetailsUseCase;

    private final CreateDiagnosticsUseCase createDiagnosticsUseCase;
    private final RetrieveAllDiagnosticsUseCase retrieveAllDiagnosticsUseCase;
    private final RetrieveDiagnosticsUseCase retrieveDiagnosticsUseCase;
    private final UpdateDiagnosticsUseCase updateDiagnosticsUseCase;

    public DiagnosticsResponse create(DiagnosticsRequest diagnosticsRequest) {
        Symptoms existingSymptom = retrieveSymptomUseCase.execute(diagnosticsRequest.getSymptoms());
        PrescriptionsDetails existingPrescriptionsDetails = retrievePrescriptionsDetailsUseCase.execute(diagnosticsRequest.getPrescriptionsDetails());
        var diagnostics = diagnosticsRequestToDomain.convert(diagnosticsRequest, existingSymptom, existingPrescriptionsDetails);
        var diagnosticsSaved = createDiagnosticsUseCase.execute(diagnostics);
        return diagnosticsDomainToResponseConverter.convert(diagnosticsSaved);
    }

    public DiagnosticsResponse getById(Long id) {
        var diagnostics = retrieveDiagnosticsUseCase.execute(id);
        return diagnosticsDomainToResponseConverter.convert(diagnostics);
    }

    public List<DiagnosticsResponse> getAll() {
        var diagnosticsList = retrieveAllDiagnosticsUseCase.execute();
        return diagnosticsList.stream().map(diagnosticsDomainToResponseConverter::convert).toList();
    }

    public DiagnosticsResponse update(Long id, DiagnosticsRequest diagnosticsUpdateRequest) {
        var existingSymptom = retrieveSymptomUseCase.execute(diagnosticsUpdateRequest.getSymptoms());
        var existingPrescriptionsDetails = retrievePrescriptionsDetailsUseCase.execute(diagnosticsUpdateRequest.getPrescriptionsDetails());
        var existingDiagnostics = retrieveDiagnosticsUseCase.execute(id);

        var diagnosticsConverter = diagnosticsRequestToDomain.convert(existingDiagnostics,
                                                existingSymptom, existingPrescriptionsDetails, diagnosticsUpdateRequest);
        var diagnosticsUpdated = updateDiagnosticsUseCase.execute(diagnosticsConverter);
        return diagnosticsDomainToResponseConverter.convert(diagnosticsUpdated);
    }
}
