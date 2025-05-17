package br.com.foodwise.platform.application.facade;

import br.com.foodwise.platform.application.facade.converter.PreviousConsultationsRequestToDomain;
import br.com.foodwise.platform.application.facade.converter.PreviousConsultationsToResponseConverter;
import br.com.foodwise.platform.application.usecase.previous_consultations.CreatePreviousConsultationsUseCase;
import br.com.foodwise.platform.application.usecase.previous_consultations.RetrieveAllFutureConsultationsUseCase;
import br.com.foodwise.platform.application.usecase.previous_consultations.RetrieveAllPreviousConsultationsUseCase;
import br.com.foodwise.platform.application.usecase.previous_consultations.RetrievePreviousConsultationsByIdUseCase;
import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.domain.PreviousConsultations;
import br.com.foodwise.platform.infrastructure.configuration.RabbitMQConfig;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PreviousConsultationsRequest;
import br.com.foodwise.platform.infrastructure.graphql.dtos.response.PreviousConsultationsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PreviousConsultationsFacade {

    private final PreviousConsultationsRequestToDomain previousConsultationsRequestToDomain;
    private final PreviousConsultationsToResponseConverter previousConsultationsToResponseConverter;

    private final DiagnosticsFacade diagnosticsFacade;
    private final CreatePreviousConsultationsUseCase createPreviousConsultationsUseCase;
    private final RetrievePreviousConsultationsByIdUseCase retrievePreviousConsultationsByIdUseCase;
    private final RetrieveAllPreviousConsultationsUseCase retrieveAllPreviousConsultationsUseCase;
    private final RetrieveAllFutureConsultationsUseCase retrieveAllFutureConsultationsUseCase;

    @RabbitListener(queues = RabbitMQConfig.HISTORY_NEW_QUEUE)
    public void create(PreviousConsultationsRequest previousConsultationsRequest) {

        Diagnostics diagnostics = diagnosticsFacade.create(previousConsultationsRequest);

        var previousConsultations = previousConsultationsRequestToDomain.convert(previousConsultationsRequest, diagnostics);

        createPreviousConsultationsUseCase.execute(previousConsultations);
    }

    public PreviousConsultationsResponse getById(Long id) {
        var previousConsultations = retrievePreviousConsultationsByIdUseCase.execute(id);
        return previousConsultationsToResponseConverter.convert(previousConsultations);
    }

    public List<PreviousConsultationsResponse> getAll() {
        List<PreviousConsultations> prevList = retrieveAllPreviousConsultationsUseCase.execute();
        return prevList.stream().map(previousConsultationsToResponseConverter::convert).toList();
    }

    @RabbitListener(queues = RabbitMQConfig.HISTORY_UPDATE_QUEUE)
    public void update(PreviousConsultationsRequest previousConsultationsUpdateRequest) {

        Diagnostics existingDiagnostics = diagnosticsFacade.update(previousConsultationsUpdateRequest);

        var existingPreviousConsultations = retrievePreviousConsultationsByIdUseCase.execute(previousConsultationsUpdateRequest.getId());

        var previousConverter = previousConsultationsRequestToDomain.convert(existingPreviousConsultations,
                existingDiagnostics, previousConsultationsUpdateRequest);

        createPreviousConsultationsUseCase.execute(previousConverter);
    }

    public List<PreviousConsultationsResponse> getAllFuture() {
        List<PreviousConsultations> prevList = retrieveAllFutureConsultationsUseCase.execute();
        return prevList.stream().map(previousConsultationsToResponseConverter::convert).toList();
    }
}
