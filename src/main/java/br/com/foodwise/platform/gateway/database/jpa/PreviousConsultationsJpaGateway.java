package br.com.foodwise.platform.gateway.database.jpa;

import br.com.foodwise.platform.domain.PreviousConsultations;
import br.com.foodwise.platform.gateway.database.PreviousConsultationsGateway;
import br.com.foodwise.platform.gateway.database.jpa.converter.PreviousConsultationsDomainToEntityConverter;
import br.com.foodwise.platform.gateway.database.jpa.converter.PreviousConsultationsEntityToDomainConverter;
import br.com.foodwise.platform.gateway.database.jpa.repositories.PreviousConsultationsRepository;
import br.com.foodwise.platform.infrastructure.graphql.controller.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PreviousConsultationsJpaGateway implements PreviousConsultationsGateway {

    private final PreviousConsultationsDomainToEntityConverter previousConsultationsDomainToEntityConverter;
    private final PreviousConsultationsEntityToDomainConverter previousConsultationsEntityToDomainConverter;
    private final PreviousConsultationsRepository previousConsultationsRepository;

    @Override
    public PreviousConsultations save(PreviousConsultations previousConsultations) {
        var prevToSave = previousConsultationsDomainToEntityConverter.convert(previousConsultations);
        var saved = previousConsultationsRepository.save(prevToSave);
        return previousConsultationsEntityToDomainConverter.convert(saved);
    }

    @Override
    public PreviousConsultations findById(Long id) {
        var prevEntity = previousConsultationsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Previous consultation with id " + id));
        return previousConsultationsEntityToDomainConverter.convert(prevEntity);
    }

    @Override
    public List<PreviousConsultations> findAll() {
        var prevList = previousConsultationsRepository.findAll();
        return prevList.stream()
                .map(previousConsultationsEntityToDomainConverter::convert)
                .toList();
    }
}
