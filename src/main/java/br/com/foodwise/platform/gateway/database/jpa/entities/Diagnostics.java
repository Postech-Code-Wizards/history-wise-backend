package br.com.foodwise.platform.gateway.database.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "diagnostics")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Diagnostics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consultation_id", nullable = false)
    private Long consultation;

    @Column(name = "patient_id", nullable = false)
    private Long patient;

    @Column(name = "doctor_id", nullable = false)
    private Long doctor;

    @ManyToOne
    @JoinColumn(name = "symptoms_id", nullable = false)
    private Symptoms symptoms;

    @ManyToOne
    @JoinColumn(name = "prescription_details_id", nullable = false)
    private PrescriptionsDetails prescriptionsDetails;

}
