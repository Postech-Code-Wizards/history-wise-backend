package br.com.foodwise.platform.infrastructure.rest.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionsDetailsRequest {
    private String medicationName;
    private String dosage;
    private String frequency;
    private String routeOfAdministration;
    private String instruction;
}
