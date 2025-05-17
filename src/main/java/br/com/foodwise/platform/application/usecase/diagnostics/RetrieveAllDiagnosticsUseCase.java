package br.com.foodwise.platform.application.usecase.diagnostics;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.gateway.database.DiagnosticsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveAllDiagnosticsUseCase {

    private final DiagnosticsGateway diagnosticsGateway;

    public List<Diagnostics> execute() {
        return diagnosticsGateway.findAll();
    }
}
