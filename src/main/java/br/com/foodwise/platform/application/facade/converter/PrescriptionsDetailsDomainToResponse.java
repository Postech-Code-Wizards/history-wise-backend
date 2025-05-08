package br.com.foodwise.platform.application.facade.converter;

import br.com.foodwise.platform.domain.PrescriptionsDetails;
import br.com.foodwise.platform.infrastructure.rest.dtos.response.PrescriptionsDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrescriptionsDetailsDomainToResponse {

    public PrescriptionsDetailsResponse convert(PrescriptionsDetails source) {
        return PrescriptionsDetailsResponse.builder()
                .id(source.getId())
                .medicationName(source.getMedicationName())
                .dosage(source.getDosage())
                .frequency(source.getFrequency())
                .routeOfAdministration(source.getRouteOfAdministration())
                .instruction(source.getInstruction())
                .createdAt(source.getCreatedAt())
                .build();
    }
}
