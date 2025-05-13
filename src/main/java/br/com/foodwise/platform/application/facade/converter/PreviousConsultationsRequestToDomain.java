package br.com.foodwise.platform.application.facade.converter;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.domain.PreviousConsultations;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PreviousConsultationsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class PreviousConsultationsRequestToDomain {

    public PreviousConsultations convert(PreviousConsultationsRequest source, Diagnostics diagnostics) {
        return PreviousConsultations.builder()
                .id(null)
                .consultation(source.getConsultation())
                .patient(source.getPatient())
                .doctor(source.getDoctor())
                .nurse(source.getNurse())
                .scheduledAt(source.getScheduleAt())
                .completedAt(source.getCompletedAt())
                .status(source.getStatus())
                .diagnostics(diagnostics)
                .createdAt(ZonedDateTime.now())
                .build();
    }

    public PreviousConsultations convert(PreviousConsultations existingPreviousConsultations,
                                         Diagnostics existingDiagnostics, PreviousConsultationsRequest previousConsultationsUpdateRequest) {
        return PreviousConsultations.builder()
                .id(existingPreviousConsultations.getId())
                .consultation(previousConsultationsUpdateRequest.getConsultation())
                .patient(previousConsultationsUpdateRequest.getPatient())
                .doctor(previousConsultationsUpdateRequest.getDoctor())
                .nurse(previousConsultationsUpdateRequest.getNurse())
                .scheduledAt(previousConsultationsUpdateRequest.getScheduleAt())
                .completedAt(previousConsultationsUpdateRequest.getCompletedAt())
                .status(previousConsultationsUpdateRequest.getStatus())
                .diagnostics(existingDiagnostics)
                .createdAt(existingPreviousConsultations.getCreatedAt())
                .build();
    }
}
