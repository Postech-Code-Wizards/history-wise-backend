package br.com.foodwise.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Diagnostics {

    private Long id;
    private Long diagnosticId;
    private Long consultation;
    private Long patient;
    private Long doctor;
    private Long symptoms;
    private Long prescriptionsDetails;
}
