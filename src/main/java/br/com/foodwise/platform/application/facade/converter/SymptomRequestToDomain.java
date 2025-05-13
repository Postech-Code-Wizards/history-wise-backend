package br.com.foodwise.platform.application.facade.converter;

import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.SymptomsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class SymptomRequestToDomain {

    public Symptoms convert(SymptomsRequest source) {
        return Symptoms.builder()
                .id(null)
                .name(source.getName())
                .createdAt(ZonedDateTime.now())
                .build();
    }
}
