package br.com.foodwise.platform.application.usecase.symptom;

import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.gateway.database.SymptomsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveSymptomUseCase {

    private final SymptomsGateway symptomsGateway;

    public Symptoms execute(Long id) {
        return symptomsGateway.findById(id);
    }
}
