CREATE TABLE "symptoms" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMPTZ DEFAULT current_timestamp NOT NULL
);

CREATE TABLE "prescriptions_details" (
    id BIGSERIAL PRIMARY KEY,
    medication_name VARCHAR(255) NOT NULL,
    dosage VARCHAR(100) NOT NULL,
    frequency VARCHAR(100) NOT NULL,
    route_of_administration VARCHAR(100) NOT NULL,
    instruction TEXT,
    created_at TIMESTAMPTZ DEFAULT current_timestamp NOT NULL
);

CREATE TABLE "diagnostics" (
    id BIGSERIAL PRIMARY KEY,
    consultation_id BIGSERIAL NOT NULL,
    patient_id BIGSERIAL NOT NULL,
    doctor_id BIGSERIAL NOT NULL,
    symptoms_id BIGSERIAL NOT NULL,
    prescription_details_id BIGSERIAL NOT NULL,

    CONSTRAINT fk_prescriptions FOREIGN KEY (prescription_details_id) REFERENCES "prescriptions_details" (id),
    CONSTRAINT fk_symptoms FOREIGN KEY (symptoms_id) REFERENCES "symptoms" (id)
);

CREATE TYPE consultations_status AS ENUM ('REALIZADA', 'CANCELADA');

CREATE TABLE "previous_consultations" (
    id BIGSERIAL PRIMARY KEY,
    consultation_id BIGSERIAL NOT NULL,
    patient_id BIGSERIAL NOT NULL,
    doctor_id BIGSERIAL NOT NULL,
    nurse_id BIGSERIAL NOT NULL,
    scheduled_at TIMESTAMPTZ NOT NULL,
    completed_at TIMESTAMPTZ,
    status consultations_status NOT NULL,
    diagnostics_id BIGSERIAL NOT NULL,
    created_at TIMESTAMPTZ DEFAULT current_timestamp NOT NULL,

    CONSTRAINT fk_diagnostics FOREIGN KEY (diagnostics_id) REFERENCES "diagnostics" (id)
);
