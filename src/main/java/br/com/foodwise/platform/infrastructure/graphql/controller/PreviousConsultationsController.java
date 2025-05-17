package br.com.foodwise.platform.infrastructure.graphql.controller;

import br.com.foodwise.platform.application.facade.HistoryPubliserFacade;
import br.com.foodwise.platform.application.facade.PreviousConsultationsFacade;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PreviousConsultationsRequest;
import br.com.foodwise.platform.infrastructure.graphql.dtos.response.PreviousConsultationsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PreviousConsultationsController {

    private final PreviousConsultationsFacade previousConsultationsFacade;
    private final HistoryPubliserFacade historyPubliserFacade;

    @MutationMapping
    public void createPreviousConsultations(@Argument PreviousConsultationsRequest previousConsultationsRequest) {
        /*return previousConsultationsFacade.create(previousConsultationsRequest);*/
        historyPubliserFacade.create(previousConsultationsRequest);
    }

    @QueryMapping
    public PreviousConsultationsResponse getPreviousConsultationsById(@Argument Long id) {
        return previousConsultationsFacade.getById(id);
    }

    @QueryMapping
    public List<PreviousConsultationsResponse> listPreviousConsultations() {
        return previousConsultationsFacade.getAll();
    }

    @QueryMapping
    public List<PreviousConsultationsResponse> listFuturePreviousConsultations() {
        return previousConsultationsFacade.getAllFuture();
    }

    @MutationMapping
    public void updatePreviousConsultations(@Argument PreviousConsultationsRequest previousConsultationsRequest) {
        historyPubliserFacade.update(previousConsultationsRequest);
    }
}
