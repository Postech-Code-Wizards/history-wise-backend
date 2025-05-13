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

    @MutationMapping
    public DiagnosticsResponse createDiagnostics(@Argument DiagnosticsRequest diagnosticsRequest) {
        return diagnosticsFacade.create(diagnosticsRequest);
    }

    @QueryMapping
    public DiagnosticsResponse getDiagnosticsById(@Argument Long id) {
        return diagnosticsFacade.getById(id);
    }

    @QueryMapping
    public List<DiagnosticsResponse> listDiagnostics() {
        return diagnosticsFacade.getAll();
    }

    @MutationMapping
    public DiagnosticsResponse updateDiagnostics(@Argument Long id, @Argument DiagnosticsRequest diagnosticsUpdateRequest) {
        return diagnosticsFacade.update(id, diagnosticsUpdateRequest);
    }
}
