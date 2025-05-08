package br.com.foodwise.platform.application.usecase.diagnostics;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.gateway.database.DiagnosticsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDiagnosticsUseCase {

    private final DiagnosticsGateway diagnosticsGateway;

    public Diagnostics execute(Diagnostics diagnostics) {
        return diagnosticsGateway.save(diagnostics);
    }
}
