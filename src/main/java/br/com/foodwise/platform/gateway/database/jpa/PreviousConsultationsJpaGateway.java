package br.com.foodwise.platform.gateway.database.jpa;

import br.com.foodwise.platform.domain.PreviousConsultations;
import br.com.foodwise.platform.gateway.database.PreviousConsultationsGateway;
import br.com.foodwise.platform.gateway.database.jpa.converter.PreviousConsultationsDomainToEntityConverter;
import br.com.foodwise.platform.gateway.database.jpa.converter.PreviousConsultationsEntityToDomainConverter;
import br.com.foodwise.platform.gateway.database.jpa.repositories.PreviousConsultationsRepository;
import br.com.foodwise.platform.infrastructure.graphql.controller.exception.CustomExceptionHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PreviousConsultationsJpaGateway implements PreviousConsultationsGateway {

    private final PreviousConsultationsDomainToEntityConverter previousConsultationsDomainToEntityConverter;
    private final PreviousConsultationsEntityToDomainConverter previousConsultationsEntityToDomainConverter;
    private final PreviousConsultationsRepository previousConsultationsRepository;

    @Override
    public void save(PreviousConsultations previousConsultations) {
        var prevToSave = previousConsultationsDomainToEntityConverter.convert(previousConsultations);
        previousConsultationsRepository.save(prevToSave);
    }

    @Override
    public PreviousConsultations findById(Long id) {
        var prevEntity = previousConsultationsRepository.findById(id)
                .orElseThrow(() -> new CustomExceptionHandler("error.not_found", "Previous Consultations with id: " +id));
        return previousConsultationsEntityToDomainConverter.convert(prevEntity);
    }

    @Override
    public List<PreviousConsultations> findAll() {
        var prevList = previousConsultationsRepository.findAll();
        return prevList.stream()
                .map(previousConsultationsEntityToDomainConverter::convert)
                .toList();
    }

    @Override
    public List<PreviousConsultations> findAllFuture() {
        var prevList = previousConsultationsRepository.findAllByScheduledAtAfter(ZonedDateTime.now());
        return prevList.stream()
                .map(previousConsultationsEntityToDomainConverter::convert)
                .toList();
    }
}
