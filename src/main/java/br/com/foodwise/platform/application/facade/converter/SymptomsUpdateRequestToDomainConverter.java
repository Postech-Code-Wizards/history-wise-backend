package br.com.foodwise.platform.application.facade.converter;

import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.infrastructure.rest.dtos.request.SymptomsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SymptomsUpdateRequestToDomainConverter {

    public Symptoms convert(Symptoms symptoms, SymptomsRequest symptomsRequest) {
        return Symptoms.builder()
                .id(symptoms.getId())
                .name(symptomsRequest.getName())
                .createdAt(symptoms.getCreatedAt())
                .build();
    }
}
