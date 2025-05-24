package br.com.foodwise.platform.application.facade.converter;

import br.com.foodwise.platform.domain.PrescriptionsDetails;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PrescriptionsDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class PrescriptionsDetailsRequestToDomain {

    public PrescriptionsDetails convert(PrescriptionsDetailsRequest source) {
        return PrescriptionsDetails.builder()
                .id(null)
                .medicationName(source.getMedicationName())
                .dosage(source.getDosage())
                .frequency(source.getFrequency())
                .routeOfAdministration(source.getRouteOfAdministration())
                .instruction(source.getInstruction())
                .createdAt(ZonedDateTime.now())
                .build();

    }
}
