package br.com.foodwise.platform.gateway.database.jpa;

import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.gateway.database.SymptomsGateway;
import br.com.foodwise.platform.gateway.database.jpa.converter.SymptomsDomainToEntityConverter;
import br.com.foodwise.platform.gateway.database.jpa.converter.SymptomsEntityToDomainConverter;
import br.com.foodwise.platform.gateway.database.jpa.repositories.SymptomsRepository;
import br.com.foodwise.platform.infrastructure.rest.controller.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SymptomsJpaGateway implements SymptomsGateway {

    private final SymptomsRepository symptomsRepository;
    private final SymptomsDomainToEntityConverter symptomsDomainToEntityConverter;
    private final SymptomsEntityToDomainConverter symptomsEntityToDomainConverter;

    @Override
    public Symptoms save(Symptoms symptoms) {
        var symptomsEntity = symptomsDomainToEntityConverter.convert(symptoms);
        var symptomsSaved = symptomsRepository.save(symptomsEntity);
        return symptomsEntityToDomainConverter.convert(symptomsSaved);
    }

    @Override
    public Symptoms findById(Long id) {
        var symptomsEntity = symptomsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Symptom " + id));
        return symptomsEntityToDomainConverter.convert(symptomsEntity);
    }

    @Override
    public List<Symptoms> findAll() {
        var symptomsEntityList = symptomsRepository.findAll();
        return symptomsEntityList.stream().map(symptomsEntityToDomainConverter::convert).toList();
    }
}
