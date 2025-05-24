package br.com.foodwise.platform.application.usecase.previous_consultations;

import br.com.foodwise.platform.domain.PreviousConsultations;
import br.com.foodwise.platform.gateway.database.PreviousConsultationsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePreviousConsultationsUseCase {

    private final PreviousConsultationsGateway previousConsultationsGateway;

    public void execute(PreviousConsultations previousConsultations) {
        previousConsultationsGateway.save(previousConsultations);
    }
}
