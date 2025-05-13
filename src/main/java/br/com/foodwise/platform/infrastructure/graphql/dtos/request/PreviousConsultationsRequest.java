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

    private Long consultation;
    private Long patient;
    private Long doctor;
    private Long nurse;
    private ZonedDateTime scheduleAt;
    private ZonedDateTime completedAt;
    private Status status;
    private Long diagnostics;
}
