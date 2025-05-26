package br.com.foodwise.platform.application.facade.converter;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.DiagnosticsRequest;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PreviousConsultationsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiagnosticsRequestToDomain {

    public Diagnostics convert(DiagnosticsRequest source) {
        return Diagnostics.builder()
                .id(null)
                .consultation(source.getConsultation())
                .patient(source.getPatient())
                .doctor(source.getDoctor())
                .symptoms(source.getSymptoms())
                .prescriptionsDetails(source.getPrescriptionsDetails())
                .build();
    }

    public Diagnostics convert(PreviousConsultationsRequest previousConsultationsUpdateRequest) {
        return Diagnostics.builder()
                .id(null)
                .diagnosticId(previousConsultationsUpdateRequest.getDiagnostics())
                .consultation(previousConsultationsUpdateRequest.getConsultationId())
                .patient(previousConsultationsUpdateRequest.getPatientId())
                .doctor(previousConsultationsUpdateRequest.getDoctorId())
                .symptoms(previousConsultationsUpdateRequest.getSymptoms())
                .prescriptionsDetails(previousConsultationsUpdateRequest.getPrescriptionsDetails())
                .build();
    }
}
