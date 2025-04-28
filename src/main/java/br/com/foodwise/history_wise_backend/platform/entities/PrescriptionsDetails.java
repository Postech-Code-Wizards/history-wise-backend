package br.com.foodwise.history_wise_backend.platform.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "prescriptions_details")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medication_name", nullable = false)
    private String medicationName;

    @Column(nullable = false)
    private String dosage;

    @Column(nullable = false)
    private String frequency;

    @Column(name = "route_of_administration", nullable = false)
    private String routeOfAdministration;

    @Column
    private String instruction;

    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();
}
