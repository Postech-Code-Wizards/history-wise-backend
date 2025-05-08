package br.com.foodwise.platform.application.usecase.prescriptionsDetails;

import br.com.foodwise.platform.domain.PrescriptionsDetails;
import br.com.foodwise.platform.gateway.database.PrescriptionsDetailsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrievePrescriptionsDetailsUseCase {

    private final PrescriptionsDetailsGateway prescriptionsDetailsGateway;

    public PrescriptionsDetails execute(Long id) {
        return prescriptionsDetailsGateway.findById(id);
    }
}
