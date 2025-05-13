package br.com.foodwise.platform.infrastructure.graphql.controller;

import br.com.foodwise.platform.application.facade.PreviousConsultationsFacade;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PreviousConsultationsRequest;
import br.com.foodwise.platform.infrastructure.graphql.dtos.response.PreviousConsultationsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PreviousConsultationsController {

    private final PreviousConsultationsFacade previousConsultationsFacade;

    @MutationMapping
    public PreviousConsultationsResponse createPreviousConsultations(@Argument PreviousConsultationsRequest previousConsultationsRequest) {
        return previousConsultationsFacade.create(previousConsultationsRequest);
    }

    @QueryMapping
    public PreviousConsultationsResponse getPreviousConsultationsById(@Argument Long id) {
        return previousConsultationsFacade.getById(id);
    }

    @QueryMapping
    public List<PreviousConsultationsResponse> listPreviousConsultations() {
        return previousConsultationsFacade.getAll();
    }

    @MutationMapping
    public PreviousConsultationsResponse updatePreviousConsultations(@Argument Long id, @Argument PreviousConsultationsRequest previousConsultationsUpdateRequest) {
        return previousConsultationsFacade.update(id, previousConsultationsUpdateRequest);
    }
}
