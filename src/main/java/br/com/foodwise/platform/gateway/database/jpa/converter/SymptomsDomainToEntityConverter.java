package br.com.foodwise.platform.gateway.database.jpa.converter;

import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.gateway.database.jpa.entities.SymptomsEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SymptomsDomainToEntityConverter {

    public SymptomsEntity convert(Symptoms source) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(source, SymptomsEntity.class);
    }
}
