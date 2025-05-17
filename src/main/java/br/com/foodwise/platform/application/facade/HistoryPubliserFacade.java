package br.com.foodwise.platform.application.facade;

import br.com.foodwise.platform.application.usecase.rabbit.SendNewHistoryUseCase;
import br.com.foodwise.platform.application.usecase.rabbit.SendUpdateHistoryUseCase;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PreviousConsultationsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryPubliserFacade {

    private final SendNewHistoryUseCase sendNewHistoryUseCase;
    private final SendUpdateHistoryUseCase sendUpdateHistoryUseCase;


    public void create(PreviousConsultationsRequest previousConsultationsRequest) {
        sendNewHistoryUseCase.execute(previousConsultationsRequest);
    }

    public void update(PreviousConsultationsRequest previousConsultationsUpdateRequest) {
        sendUpdateHistoryUseCase.execute(previousConsultationsUpdateRequest);
    }
}
