package br.com.foodwise.platform.application.facade;

import br.com.foodwise.platform.application.facade.converter.DiagnosticsDomainToResponseConverter;
import br.com.foodwise.platform.application.facade.converter.DiagnosticsRequestToDomain;
import br.com.foodwise.platform.application.usecase.diagnostics.CreateDiagnosticsUseCase;
import br.com.foodwise.platform.application.usecase.diagnostics.RetrieveAllDiagnosticsUseCase;
import br.com.foodwise.platform.application.usecase.diagnostics.RetrieveDiagnosticsUseCase;
import br.com.foodwise.platform.application.usecase.diagnostics.UpdateDiagnosticsUseCase;
import br.com.foodwise.platform.application.usecase.prescriptions_details.RetrievePrescriptionsDetailsUseCase;
import br.com.foodwise.platform.application.usecase.symptom.RetrieveSymptomUseCase;
import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.domain.PrescriptionsDetails;
import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.DiagnosticsRequest;
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

    private final RetrieveSymptomUseCase retrieveSymptomUseCase;
    private final RetrievePrescriptionsDetailsUseCase retrievePrescriptionsDetailsUseCase;

    private final CreateDiagnosticsUseCase createDiagnosticsUseCase;
    private final RetrieveAllDiagnosticsUseCase retrieveAllDiagnosticsUseCase;
    private final RetrieveDiagnosticsUseCase retrieveDiagnosticsUseCase;
    private final UpdateDiagnosticsUseCase updateDiagnosticsUseCase;


    public Diagnostics create(PreviousConsultationsRequest previousConsultationsRequest) {
        Symptoms existingSymptom = retrieveSymptomUseCase.execute(previousConsultationsRequest.getSymptomsId());
        PrescriptionsDetails existingPrescriptionsDetails = retrievePrescriptionsDetailsUseCase.execute(previousConsultationsRequest.getPrescriptionsDetailsId());
        var diagnostics = diagnosticsRequestToDomain.convert(previousConsultationsRequest, existingSymptom, existingPrescriptionsDetails);
        return createDiagnosticsUseCase.execute(diagnostics);
    }

    public DiagnosticsResponse getById(Long id) {
        var diagnostics = retrieveDiagnosticsUseCase.execute(id);
        return diagnosticsDomainToResponseConverter.convert(diagnostics);
    }

    public List<DiagnosticsResponse> getAll() {
        var diagnosticsList = retrieveAllDiagnosticsUseCase.execute();
        return diagnosticsList.stream().map(diagnosticsDomainToResponseConverter::convert).toList();
    }

    public Diagnostics update(PreviousConsultationsRequest previousConsultationsUpdateRequest) {
        var existingSymptom = retrieveSymptomUseCase.execute(previousConsultationsUpdateRequest.getSymptomsId());
        var existingPrescriptionsDetails = retrievePrescriptionsDetailsUseCase.execute(previousConsultationsUpdateRequest.getPrescriptionsDetailsId());
        var existingDiagnostics = retrieveDiagnosticsUseCase.execute(previousConsultationsUpdateRequest.getDiagnosticsId());

        var diagnosticsConverter = diagnosticsRequestToDomain.convert(existingDiagnostics,
                existingSymptom, existingPrescriptionsDetails, previousConsultationsUpdateRequest);
        return updateDiagnosticsUseCase.execute(diagnosticsConverter);
    }
}
