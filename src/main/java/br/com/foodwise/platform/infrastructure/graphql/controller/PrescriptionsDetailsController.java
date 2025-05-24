package br.com.foodwise.platform.infrastructure.graphql.controller;

import br.com.foodwise.platform.application.facade.PrescriptionsDetailsFacade;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PrescriptionsDetailsRequest;
import br.com.foodwise.platform.infrastructure.graphql.dtos.response.PrescriptionsDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PrescriptionsDetailsController {

    private final PrescriptionsDetailsFacade prescriptionsDetailsFacade;

    @MutationMapping
    public PrescriptionsDetailsResponse createPrescriptionsDetails(@Argument PrescriptionsDetailsRequest prescriptionsDetailsRequest) {
        return prescriptionsDetailsFacade.create(prescriptionsDetailsRequest);
    }

    @QueryMapping
    public PrescriptionsDetailsResponse getPrescriptionsDetailsById(@Argument Long id) {
        return prescriptionsDetailsFacade.getById(id);
    }

    @QueryMapping
    public List<PrescriptionsDetailsResponse> listPrescriptionsDetails() {
        return prescriptionsDetailsFacade.getAll();
    }

    @MutationMapping
    public PrescriptionsDetailsResponse updatePrescriptionsDetails(@Argument Long id, @Argument PrescriptionsDetailsRequest prescriptionsDetailsUpdateRequest) {
        return prescriptionsDetailsFacade.update(id, prescriptionsDetailsUpdateRequest);
    }
}
