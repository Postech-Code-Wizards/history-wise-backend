CREATE TABLE "diagnostics" (
    id BIGSERIAL PRIMARY KEY,
    diagnostic_id BIGINT UNIQUE,
    consultation_id BIGINT NOT NULL,
    patient_id BIGINT NOT NULL,
    doctor_id BIGINT NOT NULL,
    symptoms_id BIGINT NOT NULL,
    prescription_details_id BIGINT NOT NULL
);

CREATE TYPE consultations_status AS ENUM ('SCHEDULED', 'ACCOMPLISHED', 'CANCELLED', 'RESCHEDULED');

CREATE TABLE "previous_consultations" (
    id BIGSERIAL PRIMARY KEY,
    consultation_id BIGINT NOT NULL,
    patient_id BIGINT NOT NULL,
    doctor_id BIGINT NOT NULL,
    nurse_id BIGINT NOT NULL,
    scheduled_at TIMESTAMPTZ NOT NULL,
    completed_at TIMESTAMPTZ,
    status consultations_status NOT NULL,
    diagnostics_id BIGSERIAL NOT NULL,
    created_at TIMESTAMPTZ DEFAULT current_timestamp NOT NULL,

    CONSTRAINT fk_diagnostics FOREIGN KEY (diagnostics_id) REFERENCES "diagnostics" (id)
);
