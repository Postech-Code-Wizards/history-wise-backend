package br.com.foodwise.platform.repository.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "diagnostics")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreviousConsultations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consultation_id", nullable = false)
    private Long consultation;

    @Column(name = "patient_id", nullable = false)
    private Long patient;

    @Column(name = "doctor_id", nullable = false)
    private Long doctor;

    @Column(name = "nurse_id", nullable = false)
    private Long nurse;

    @Column(name = "scheduled_at", nullable = false, updatable = false)
    private ZonedDateTime scheduledAt;

    @Column(name = "completed_at", updatable = false)
    private ZonedDateTime completedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status role;

    @ManyToOne
    @JoinColumn(name = "diagnostics_id", nullable = false)
    private Diagnostics diagnostics;

    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();

    public enum Status {
        REALIZADA,
        CANCELADA
    }
}
