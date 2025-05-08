package br.com.foodwise.platform.application.facade.converter;

import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.infrastructure.rest.dtos.response.SymptomsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SymptomsDomainToResponse {

    public SymptomsResponse convert(Symptoms symptoms) {
        return SymptomsResponse.builder()
                .id(symptoms.getId())
                .name(symptoms.getName())
                .createdAt(symptoms.getCreatedAt())
                .build();
    }
}
