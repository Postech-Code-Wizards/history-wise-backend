package br.com.foodwise.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PrescriptionsDetails {

    private Long id;
    private String medicationName;
    private String dosage;
    private String frequency;
    private String routeOfAdministration;
    private String instruction;
    private ZonedDateTime createdAt;
}
