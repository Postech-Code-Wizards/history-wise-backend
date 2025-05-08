package br.com.foodwise.platform.application.facade.converter;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.infrastructure.rest.dtos.response.DiagnosticsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiagnosticsDomainToResponseConverter {

    public DiagnosticsResponse convert(Diagnostics source) {
        return DiagnosticsResponse.builder()
                .id(source.getId())
                .consultation(source.getConsultation())
                .patient(source.getPatient())
                .doctor(source.getDoctor())
                .symptoms(source.getSymptoms())
                .prescriptionsDetails(source.getPrescriptionsDetails())
                .build();
    }
}
