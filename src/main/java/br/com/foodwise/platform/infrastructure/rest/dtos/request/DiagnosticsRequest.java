package br.com.foodwise.platform.infrastructure.rest.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticsRequest {

    private Long id;
    private Long consultation;
    private Long patient;
    private Long doctor;
    private Long symptoms;
    private Long prescriptionsDetails;
}
