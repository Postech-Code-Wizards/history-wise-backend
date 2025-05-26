package br.com.foodwise.platform.infrastructure.graphql.dtos.request;

import br.com.foodwise.platform.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreviousConsultationsRequest {

    private Long consultationId;
    private Long patientId;
    private Long doctorId;
    private Long nurseId;
    private ZonedDateTime scheduleAt;
    private ZonedDateTime completedAt;
    private Status status;
    private Long diagnostics;
    private Long symptoms;
    private Long prescriptionsDetails;
}
