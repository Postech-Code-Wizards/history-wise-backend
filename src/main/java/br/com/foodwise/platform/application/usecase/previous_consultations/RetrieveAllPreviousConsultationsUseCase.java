package br.com.foodwise.platform.application.usecase.previous_consultations;

import br.com.foodwise.platform.domain.PreviousConsultations;
import br.com.foodwise.platform.gateway.database.PreviousConsultationsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveAllPreviousConsultationsUseCase {

    private final PreviousConsultationsGateway previousConsultationsGateway;

    public List<PreviousConsultations> execute() {
        return previousConsultationsGateway.findAll();
    }
}
