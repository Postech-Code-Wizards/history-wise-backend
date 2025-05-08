package br.com.foodwise.platform.infrastructure.rest.controller;

import br.com.foodwise.platform.application.facade.SymptomFacade;
import br.com.foodwise.platform.infrastructure.rest.dtos.request.SymptomsRequest;
import br.com.foodwise.platform.infrastructure.rest.dtos.response.SymptomsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SymptomController {

    private final SymptomFacade symptomFacade;

    @MutationMapping
    public SymptomsResponse createSymptom(@Argument SymptomsRequest symptomsRequest) {
        return symptomFacade.create(symptomsRequest);
    }

    @QueryMapping
    public SymptomsResponse getSymptomById(@Argument Long id) {
        return symptomFacade.getById(id);
    }

    @QueryMapping
    public List<SymptomsResponse> listSymptoms() {
        return symptomFacade.getAllSymptoms();
    }

    @MutationMapping
    public SymptomsResponse updateSymptom(@Argument Long id, @Argument SymptomsRequest symptomsUpdateRequest) {
        return symptomFacade.updateSymptom(id, symptomsUpdateRequest);
    }


}
