package br.com.foodwise.platform.infrastructure.rest.dtos.response;

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
@SchemaMapping(typeName = "PrescriptionsDetailsResponse")
public class PrescriptionsDetailsResponse {
    private Long id;
    private String medicationName;
    private String dosage;
    private String frequency;
    private String routeOfAdministration;
    private String instruction;
    private ZonedDateTime createdAt;
}
