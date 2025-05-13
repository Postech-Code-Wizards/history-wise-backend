package br.com.foodwise.platform.application.facade;

import br.com.foodwise.platform.application.facade.converter.PreviousConsultationsRequestToDomain;
import br.com.foodwise.platform.application.facade.converter.PreviousConsultationsToResponseConverter;
import br.com.foodwise.platform.application.usecase.diagnostics.RetrieveDiagnosticsUseCase;
import br.com.foodwise.platform.application.usecase.previous_consultations.CreatePreviousConsultationsUseCase;
import br.com.foodwise.platform.application.usecase.previous_consultations.RetrieveAllPreviousConsultationsUseCase;
import br.com.foodwise.platform.application.usecase.previous_consultations.RetrievePreviousConsultationsByIdUseCase;
import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.domain.PreviousConsultations;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PreviousConsultationsRequest;
import br.com.foodwise.platform.infrastructure.graphql.dtos.response.PreviousConsultationsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PreviousConsultationsFacade {

    private final PreviousConsultationsRequestToDomain previousConsultationsRequestToDomain;
    private final PreviousConsultationsToResponseConverter previousConsultationsToResponseConverter;

    private final RetrieveDiagnosticsUseCase retrieveDiagnosticsUseCase;
    private final CreatePreviousConsultationsUseCase createPreviousConsultationsUseCase;
    private final RetrievePreviousConsultationsByIdUseCase retrievePreviousConsultationsByIdUseCase;
    private final RetrieveAllPreviousConsultationsUseCase retrieveAllPreviousConsultationsUseCase;

    public PreviousConsultationsResponse create(PreviousConsultationsRequest previousConsultationsRequest) {
        Diagnostics diagnostics = retrieveDiagnosticsUseCase.execute(previousConsultationsRequest.getDiagnostics());

        var previousConsultations = previousConsultationsRequestToDomain.convert(previousConsultationsRequest, diagnostics);
        var saved = createPreviousConsultationsUseCase.execute(previousConsultations);
        return previousConsultationsToResponseConverter.convert(saved);

    }

    public PreviousConsultationsResponse getById(Long id) {
        var previousConsultations = retrievePreviousConsultationsByIdUseCase.execute(id);
        return previousConsultationsToResponseConverter.convert(previousConsultations);
    }

    public List<PreviousConsultationsResponse> getAll() {
        List<PreviousConsultations> prevList = retrieveAllPreviousConsultationsUseCase.execute();
        return prevList.stream().map(previousConsultationsToResponseConverter::convert).toList();
    }

    public PreviousConsultationsResponse update(Long id, PreviousConsultationsRequest previousConsultationsUpdateRequest) {

        var existingPreviousConsultations = retrievePreviousConsultationsByIdUseCase.execute(id);
        var existingDiagnostics = retrieveDiagnosticsUseCase.execute(previousConsultationsUpdateRequest.getDiagnostics());

        var previousConverter = previousConsultationsRequestToDomain.convert(existingPreviousConsultations,
                existingDiagnostics, previousConsultationsUpdateRequest);
        var prevUpdated = createPreviousConsultationsUseCase.execute(previousConverter);
        return previousConsultationsToResponseConverter.convert(prevUpdated);
    }
}
