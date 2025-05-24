package br.com.foodwise.platform.gateway.database.jpa.repositories;

import br.com.foodwise.platform.gateway.database.jpa.entities.DiagnosticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticsRepository extends JpaRepository<DiagnosticsEntity, Long> {
}
