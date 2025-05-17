package br.com.foodwise.platform.application.facade.converter;

import br.com.foodwise.platform.domain.PrescriptionsDetails;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PrescriptionsDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrescriptionsDetailsUpdateRequestToDomainConverter {

    public PrescriptionsDetails convert(PrescriptionsDetails source, PrescriptionsDetailsRequest request) {
        return PrescriptionsDetails.builder()
                .id(source.getId())
                .medicationName(request.getMedicationName())
                .dosage(request.getDosage())
                .frequency(request.getFrequency())
                .routeOfAdministration(request.getRouteOfAdministration())
                .instruction(request.getInstruction())
                .createdAt(source.getCreatedAt())
                .build();
    }
}
