package br.com.foodwise.platform.application.facade;

import br.com.foodwise.platform.application.facade.converter.SymptomRequestToDomain;
import br.com.foodwise.platform.application.facade.converter.SymptomsDomainToResponse;
import br.com.foodwise.platform.application.facade.converter.SymptomsUpdateRequestToDomainConverter;
import br.com.foodwise.platform.application.usecase.symptom.CreateSymptomsUseCase;
import br.com.foodwise.platform.application.usecase.symptom.RetrieveAllSymptomsUseCase;
import br.com.foodwise.platform.application.usecase.symptom.RetrieveSymptomUseCase;
import br.com.foodwise.platform.application.usecase.symptom.UpdateSymptomsUseCase;
import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.SymptomsRequest;
import br.com.foodwise.platform.infrastructure.graphql.dtos.response.SymptomsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SymptomFacade {

    private final SymptomRequestToDomain symptomRequestToDomain;
    private final SymptomsDomainToResponse symptomsDomainToResponse;
    private final SymptomsUpdateRequestToDomainConverter symptomsUpdateRequestToDomainConverter;

    private final CreateSymptomsUseCase createSymptomsUseCase;
    private final RetrieveSymptomUseCase retrieveSymptomUseCase;
    private final RetrieveAllSymptomsUseCase retrieveAllSymptomsUseCase;
    private final UpdateSymptomsUseCase updateSymptomsUseCase;

    public SymptomsResponse create(SymptomsRequest symptomsRequest) {
        Symptoms symptoms = symptomRequestToDomain.convert(symptomsRequest);
        Symptoms symptomsSaved = createSymptomsUseCase.execute(symptoms);
        return symptomsDomainToResponse.convert(symptomsSaved);
    }

    public SymptomsResponse getById(Long id) {
        var symptom = retrieveSymptomUseCase.execute(id);
        return symptomsDomainToResponse.convert(symptom);
    }

    public List<SymptomsResponse> getAllSymptoms() {
        var symptomsList = retrieveAllSymptomsUseCase.execute();
        return symptomsList.stream().map(symptomsDomainToResponse::convert).toList();
    }

    public SymptomsResponse updateSymptom(Long id, SymptomsRequest symptomsUpdateRequest) {
        var existingSymptom = retrieveSymptomUseCase.execute(id);
        var symptomConverter = symptomsUpdateRequestToDomainConverter.convert(existingSymptom, symptomsUpdateRequest);
        var symptomUpdated = updateSymptomsUseCase.execute(symptomConverter);
        return symptomsDomainToResponse.convert(symptomUpdated);
    }
}
