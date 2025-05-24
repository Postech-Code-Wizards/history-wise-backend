package br.com.foodwise.platform.gateway.database.jpa.converter;

import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.gateway.database.jpa.entities.SymptomsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SymptomsEntityToDomainConverter {

    public Symptoms convert(SymptomsEntity source) {
        return new Symptoms(source.getId(), source.getName(), source.getCreatedAt());
    }
}
