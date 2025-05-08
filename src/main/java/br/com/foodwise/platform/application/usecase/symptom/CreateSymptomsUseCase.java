package br.com.foodwise.platform.application.usecase.symptom;

import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.gateway.database.SymptomsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSymptomsUseCase {

    private final SymptomsGateway symptomsGateway;

    public Symptoms execute(Symptoms symptoms) {
        return symptomsGateway.save(symptoms);
    }
}
