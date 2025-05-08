package br.com.foodwise.platform.application.facade;

import br.com.foodwise.platform.application.facade.converter.PrescriptionsDetailsDomainToResponse;
import br.com.foodwise.platform.application.facade.converter.PrescriptionsDetailsRequestToDomain;
import br.com.foodwise.platform.application.facade.converter.PrescriptionsDetailsUpdateRequestToDomainConverter;
import br.com.foodwise.platform.application.usecase.prescriptionsDetails.CreatePrescriptionsDetailsUseCase;
import br.com.foodwise.platform.application.usecase.prescriptionsDetails.RetrieveAllPrescriptionsDetailsUseCase;
import br.com.foodwise.platform.application.usecase.prescriptionsDetails.RetrievePrescriptionsDetailsUseCase;
import br.com.foodwise.platform.application.usecase.prescriptionsDetails.UpdatePrescriptionsDetailsUseCase;
import br.com.foodwise.platform.domain.PrescriptionsDetails;
import br.com.foodwise.platform.infrastructure.rest.dtos.request.PrescriptionsDetailsRequest;
import br.com.foodwise.platform.infrastructure.rest.dtos.response.PrescriptionsDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionsDetailsFacade {

    private final PrescriptionsDetailsRequestToDomain prescriptionsDetailsRequestToDomain;
    private final PrescriptionsDetailsDomainToResponse prescriptionsDetailsDomainToResponse;
    private final PrescriptionsDetailsUpdateRequestToDomainConverter prescriptionsDetailsUpdateRequestToDomainConverter;

    private final CreatePrescriptionsDetailsUseCase createPrescriptionsDetailsUseCase;
    private final RetrievePrescriptionsDetailsUseCase retrievePrescriptionsDetailsUseCase;
    private final UpdatePrescriptionsDetailsUseCase updatePrescriptionsDetailsUseCase;
    private final RetrieveAllPrescriptionsDetailsUseCase retrieveAllPrescriptionsDetailsUseCase;

    public PrescriptionsDetailsResponse create(PrescriptionsDetailsRequest prescriptionsDetailsRequest) {
        PrescriptionsDetails prescriptionsDetails = prescriptionsDetailsRequestToDomain.convert(prescriptionsDetailsRequest);
        PrescriptionsDetails prescriptionsDetailsSaved = createPrescriptionsDetailsUseCase.execute(prescriptionsDetails);
        return prescriptionsDetailsDomainToResponse.convert(prescriptionsDetailsSaved);
    }

    public PrescriptionsDetailsResponse getById(Long id) {
        var prescriptonsDetails = retrievePrescriptionsDetailsUseCase.execute(id);
        return prescriptionsDetailsDomainToResponse.convert(prescriptonsDetails);
    }

    public List<PrescriptionsDetailsResponse> getAll() {
        var prescriptionsDetailsList = retrieveAllPrescriptionsDetailsUseCase.execute();
        return prescriptionsDetailsList.stream().map(prescriptionsDetailsDomainToResponse::convert).toList();
    }

    public PrescriptionsDetailsResponse update(Long id, PrescriptionsDetailsRequest prescriptionsDetailsUpdateRequest) {
        var existingPrescriptionsDetails = retrievePrescriptionsDetailsUseCase.execute(id);
        var prescriptionsDetailsConverter = prescriptionsDetailsUpdateRequestToDomainConverter.convert(existingPrescriptionsDetails, prescriptionsDetailsUpdateRequest);
        var prescriptionsDetailsUpdated = updatePrescriptionsDetailsUseCase.execute(prescriptionsDetailsConverter);
        return prescriptionsDetailsDomainToResponse.convert(prescriptionsDetailsUpdated);
    }
}
