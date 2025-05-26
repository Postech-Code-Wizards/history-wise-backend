package br.com.foodwise.platform.application.usecase.diagnostics;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.gateway.database.DiagnosticsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveDiagnosticsUseCase {

    private final DiagnosticsGateway diagnosticsGateway;

    public Diagnostics execute(Diagnostics diagnostics) {
        return diagnosticsGateway.findByIdOrSave(diagnostics);
    }

    public Diagnostics execute(Long id) {
        return diagnosticsGateway.findById(id);
    }
}
