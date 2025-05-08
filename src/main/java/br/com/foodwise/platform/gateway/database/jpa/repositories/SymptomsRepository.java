package br.com.foodwise.platform.gateway.database.jpa.repositories;

import br.com.foodwise.platform.gateway.database.jpa.entities.SymptomsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomsRepository extends JpaRepository<SymptomsEntity, Long> {
}
