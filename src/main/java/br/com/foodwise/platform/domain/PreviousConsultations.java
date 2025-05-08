package br.com.foodwise.platform.domain;

import br.com.foodwise.platform.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class PreviousConsultations {

    private Long id;
    private Long consultation;
    private Long patient;
    private Long doctor;
    private Long nurse;
    private ZonedDateTime scheduledAt;
    private ZonedDateTime completedAt;
    private Status status;
    private Diagnostics diagnostics;
    private ZonedDateTime createdAt;
}
