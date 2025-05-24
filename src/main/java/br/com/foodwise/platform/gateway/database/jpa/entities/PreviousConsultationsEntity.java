package br.com.foodwise.platform.gateway.database.jpa.entities;

import br.com.foodwise.platform.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "previous_consultations")
@AllArgsConstructor
@NoArgsConstructor
public class PreviousConsultationsEntity {

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

    @Column(name = "scheduled_at", nullable = false)
    private ZonedDateTime scheduledAt;

    @Column(name = "completed_at")
    private ZonedDateTime completedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "diagnostics_id", nullable = false)
    private DiagnosticsEntity diagnosticsEntity;

    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();

}
