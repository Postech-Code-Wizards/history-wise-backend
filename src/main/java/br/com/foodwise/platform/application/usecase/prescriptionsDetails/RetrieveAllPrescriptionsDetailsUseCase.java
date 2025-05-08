package br.com.foodwise.platform.application.usecase.prescriptionsDetails;

import br.com.foodwise.platform.domain.PrescriptionsDetails;
import br.com.foodwise.platform.gateway.database.PrescriptionsDetailsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveAllPrescriptionsDetailsUseCase {

    private final PrescriptionsDetailsGateway prescriptionsDetailsGateway;

    public List<PrescriptionsDetails> execute() {
        return prescriptionsDetailsGateway.findAll();
    }
}
