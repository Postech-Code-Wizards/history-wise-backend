package br.com.foodwise.platform.application.facade.converter;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.domain.PrescriptionsDetails;
import br.com.foodwise.platform.domain.Symptoms;
import br.com.foodwise.platform.infrastructure.rest.dtos.request.DiagnosticsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiagnosticsRequestToDomain {

    public Diagnostics convert(DiagnosticsRequest source, Symptoms symptoms, PrescriptionsDetails prescriptionsDetails) {
        return Diagnostics.builder()
                .id(null)
                .consultation(source.getConsultation())
                .patient(source.getPatient())
                .doctor(source.getDoctor())
                .symptoms(symptoms)
                .prescriptionsDetails(prescriptionsDetails)
                .build();
    }

    public Diagnostics convert(Diagnostics existingDiagnostics, Symptoms existingSymptom,
                               PrescriptionsDetails existingPrescriptionsDetails, DiagnosticsRequest diagnosticsUpdateRequest) {
        return Diagnostics.builder()
                .id(existingDiagnostics.getId())
                .consultation(diagnosticsUpdateRequest.getConsultation())
                .patient(diagnosticsUpdateRequest.getPatient())
                .doctor(diagnosticsUpdateRequest.getDoctor())
                .symptoms(existingSymptom)
                .prescriptionsDetails(existingPrescriptionsDetails)
                .build();
    }
}
