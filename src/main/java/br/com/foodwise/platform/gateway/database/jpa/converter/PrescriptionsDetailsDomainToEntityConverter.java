package br.com.foodwise.platform.gateway.database.jpa.converter;

import br.com.foodwise.platform.domain.PrescriptionsDetails;
import br.com.foodwise.platform.gateway.database.jpa.entities.PrescriptionsDetailsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrescriptionsDetailsDomainToEntityConverter {

    public PrescriptionsDetailsEntity convert(PrescriptionsDetails source) {
        var modelMapper = new org.modelmapper.ModelMapper();
        return modelMapper.map(source, PrescriptionsDetailsEntity.class);
    }
}
