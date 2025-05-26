package br.com.foodwise.platform.gateway.database.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "diagnostics")
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "diagnostic_id")
    private Long diagnosticId;

    @Column(name = "consultation_id", nullable = false)
    private Long consultation;

    @Column(name = "patient_id", nullable = false)
    private Long patient;

    @Column(name = "doctor_id", nullable = false)
    private Long doctor;

    @Column(name = "symptoms_id", nullable = false)
    private Long symptoms;

    @Column(name = "prescription_details_id", nullable = false)
    private Long prescriptionsDetails;

}
