package br.com.foodwise.platform.infrastructure.graphql.dtos.response;

import br.com.foodwise.platform.domain.Diagnostics;
import br.com.foodwise.platform.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SchemaMapping(typeName = "PreviousConsultationsResponse")
public class PreviousConsultationsResponse {
    private Long id;
    private Long consultation;
    private Long patient;
    private Long doctor;
    private Long nurse;
    private ZonedDateTime scheduleAt;
    private ZonedDateTime completedAt;
    private Status status;
    private Diagnostics diagnostics;
    private ZonedDateTime createdAt;
}
