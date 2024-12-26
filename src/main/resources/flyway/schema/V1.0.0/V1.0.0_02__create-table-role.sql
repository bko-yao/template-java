-- Create table role (V1.0.0)
CREATE TABLE role
(
    id              INT8 PRIMARY KEY,
    audit_create_by VARCHAR(100),
    audit_create_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    audit_update_by VARCHAR(100),
    audit_update_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    version         INTEGER DEFAULT 0,
    designation     VARCHAR(255) NOT NULL,
    CONSTRAINT r_designation_unique UNIQUE (designation)
);

-- Créer les séquences.
DROP SEQUENCE IF EXISTS role_seq;
CREATE SEQUENCE role_seq START WITH 1 INCREMENT BY 1;
ALTER TABLE role
    ALTER COLUMN id SET DEFAULT nextval('role_seq');

-- Créer les index
CREATE INDEX r_designation_idx on role (designation);
