package br.com.foodwise.platform.infrastructure.rest.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SchemaMapping(typeName = "DiagnosticsRequest")
public class DiagnosticsRequest {

    private Long id;
    private Long consultation;
    private Long patient;
    private Long doctor;
    private Long symptoms;
    private Long prescriptionsDetails;
}
