package br.com.foodwise.platform.application.facade.converter;

import br.com.foodwise.platform.domain.PreviousConsultations;
import br.com.foodwise.platform.infrastructure.graphql.dtos.response.PreviousConsultationsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PreviousConsultationsToResponseConverter {

    public PreviousConsultationsResponse convert(PreviousConsultations previousConsultations) {
        return PreviousConsultationsResponse.builder()
                .id(previousConsultations.getId())
                .consultation(previousConsultations.getConsultation())
                .patient(previousConsultations.getPatient())
                .doctor(previousConsultations.getDoctor())
                .nurse(previousConsultations.getNurse())
                .scheduleAt(previousConsultations.getScheduledAt())
                .completedAt(previousConsultations.getCompletedAt())
                .status(previousConsultations.getStatus())
                .diagnostics(previousConsultations.getDiagnostics())
                .createdAt(previousConsultations.getCreatedAt())
                .build();
    }
}
