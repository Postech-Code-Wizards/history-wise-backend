package br.com.foodwise.platform.gateway.database.jpa.repositories;

import br.com.foodwise.platform.gateway.database.jpa.entities.PreviousConsultationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface PreviousConsultationsRepository extends JpaRepository<PreviousConsultationsEntity, Long> {

    List<PreviousConsultationsEntity> findAllByScheduledAtAfter(ZonedDateTime now);
}
