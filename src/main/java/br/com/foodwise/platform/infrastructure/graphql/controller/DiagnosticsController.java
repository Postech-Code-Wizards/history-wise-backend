package br.com.foodwise.platform.infrastructure.graphql.controller;

import br.com.foodwise.platform.application.facade.DiagnosticsFacade;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.DiagnosticsRequest;
import br.com.foodwise.platform.infrastructure.graphql.dtos.response.DiagnosticsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DiagnosticsController {
    
    private final DiagnosticsFacade diagnosticsFacade;

    @QueryMapping
    public DiagnosticsResponse getDiagnosticsById(@Argument Long id) {
        return diagnosticsFacade.getById(id);
    }

    @QueryMapping
    public List<DiagnosticsResponse> listDiagnostics() {
        return diagnosticsFacade.getAll();
    }

}
