package br.com.foodwise.platform.gateway.database.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "symptoms")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SymptomsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();
}
