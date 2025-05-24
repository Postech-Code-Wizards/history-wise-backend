package br.com.foodwise.platform.gateway.database;

import br.com.foodwise.platform.domain.Diagnostics;

import java.util.List;

public interface DiagnosticsGateway {
    Diagnostics save(Diagnostics diagnostics);

    List<Diagnostics> findAll();

    Diagnostics findById(Long id);
}
