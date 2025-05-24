package br.com.foodwise.platform.application.usecase.symptom;

import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.gateway.database.SymptomsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveAllSymptomsUseCase {

    private final SymptomsGateway symptomsGateway;

    public List<Symptoms> execute() {
        return symptomsGateway.findAll();
    }
}
