package br.com.foodwise.platform.gateway.database;

import br.com.foodwise.platform.domain.PrescriptionsDetails;

import java.util.List;

public interface PrescriptionsDetailsGateway {
    PrescriptionsDetails save(PrescriptionsDetails prescriptionsDetails);

    PrescriptionsDetails findById(Long id);

    List<PrescriptionsDetails> findAll();
}
