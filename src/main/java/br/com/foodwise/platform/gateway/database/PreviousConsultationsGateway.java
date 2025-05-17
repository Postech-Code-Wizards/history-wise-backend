package br.com.foodwise.platform.gateway.database;

import br.com.foodwise.platform.domain.PreviousConsultations;

import java.util.List;

public interface PreviousConsultationsGateway {
    PreviousConsultations save(PreviousConsultations previousConsultations);

    PreviousConsultations findById(Long id);

    List<PreviousConsultations> findAll();
}
