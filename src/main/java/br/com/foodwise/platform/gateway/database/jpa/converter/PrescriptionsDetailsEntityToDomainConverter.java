package br.com.foodwise.platform.gateway.database.jpa.converter;

import br.com.foodwise.platform.domain.PrescriptionsDetails;
import br.com.foodwise.platform.gateway.database.jpa.entities.PrescriptionsDetailsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrescriptionsDetailsEntityToDomainConverter {

    public PrescriptionsDetails convert(PrescriptionsDetailsEntity source) {
        return new PrescriptionsDetails(source.getId(),
                source.getMedicationName(),
                source.getDosage(),
                source.getFrequency(),
                source.getRouteOfAdministration(),
                source.getInstruction(),
                source.getCreatedAt());
    }
}
