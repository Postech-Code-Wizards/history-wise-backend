package br.com.foodwise.platform.infrastructure.graphql.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SchemaMapping(typeName = "DiagnosticsResponse")
public class DiagnosticsResponse {

    private Long id;
    private Long consultation;
    private Long patient;
    private Long doctor;
    private Long symptoms;
    private Long prescriptionsDetails;
}
