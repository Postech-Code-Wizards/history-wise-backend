package br.com.foodwise.platform.gateway.database;

import br.com.foodwise.platform.domain.Symptoms;

import java.util.List;

public interface SymptomsGateway {
    Symptoms save(Symptoms symptoms);

    Symptoms findById(Long id);

    List<Symptoms> findAll();
}
