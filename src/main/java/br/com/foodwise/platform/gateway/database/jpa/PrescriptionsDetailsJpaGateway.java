package br.com.foodwise.platform.gateway.database.jpa;

import br.com.foodwise.platform.domain.PrescriptionsDetails;
import br.com.foodwise.platform.gateway.database.PrescriptionsDetailsGateway;
import br.com.foodwise.platform.gateway.database.jpa.converter.PrescriptionsDetailsDomainToEntityConverter;
import br.com.foodwise.platform.gateway.database.jpa.converter.PrescriptionsDetailsEntityToDomainConverter;
import br.com.foodwise.platform.gateway.database.jpa.repositories.PrescriptionsDetailsRepository;
import br.com.foodwise.platform.infrastructure.graphql.controller.exception.CustomExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PrescriptionsDetailsJpaGateway implements PrescriptionsDetailsGateway {

    private final PrescriptionsDetailsRepository prescriptionsDetailsRepository;
    private final PrescriptionsDetailsDomainToEntityConverter prescriptionsDetailsDomainToEntityConverter;
    private final PrescriptionsDetailsEntityToDomainConverter prescriptionsDetailsEntityToDomainConverter;

    @Override
    public PrescriptionsDetails save(PrescriptionsDetails prescriptionsDetails) {
        var prescriptionsDetailsEntity = prescriptionsDetailsDomainToEntityConverter.convert(prescriptionsDetails);
        var prescriptionsDetailsSaved = prescriptionsDetailsRepository.save(prescriptionsDetailsEntity);
        return prescriptionsDetailsEntityToDomainConverter.convert(prescriptionsDetailsSaved);
    }

    @Override
    public PrescriptionsDetails findById(Long id) {
        var prescriptionsDetailsEntity = prescriptionsDetailsRepository.findById(id)
                .orElseThrow(() -> new CustomExceptionHandler("error.not_found", "Prescriptions Details " +id));
        return prescriptionsDetailsEntityToDomainConverter.convert(prescriptionsDetailsEntity);
    }

    @Override
    public List<PrescriptionsDetails> findAll() {
        var prescriptionsDetailsEntityList = prescriptionsDetailsRepository.findAll();
        return prescriptionsDetailsEntityList.stream().map(prescriptionsDetailsEntityToDomainConverter::convert).toList();
    }
}
