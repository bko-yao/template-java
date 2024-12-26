-- Create table service_account_role (V1.0.0)
CREATE TABLE service_account_role
(
    id                 INT8 PRIMARY KEY,
    audit_create_by    VARCHAR(100),
    audit_create_at    TIMESTAMP WITHOUT TIME ZONE,
    audit_update_by    VARCHAR(100),
    audit_update_at    TIMESTAMP WITHOUT TIME ZONE,
    version            INTEGER DEFAULT 0,
    id_service_account INT8 NOT NULL,
    id_role            INT8 NOT NULL,
    CONSTRAINT sar_id_service_account_fk FOREIGN KEY (id_service_account) REFERENCES service_account (id),
    CONSTRAINT sar_id_role_fk FOREIGN KEY (id_role) REFERENCES role (id)
);

-- Créer les séquences
DROP SEQUENCE IF EXISTS service_account_role_seq;
CREATE SEQUENCE service_account_role_seq START WITH 1 INCREMENT BY 5;
ALTER TABLE service_account_role
    ALTER COLUMN id SET DEFAULT nextval('service_account_role_seq');

-- Créer les index
CREATE INDEX sar_id_service_account_idx ON service_account_role (id_service_account);
CREATE INDEX sar_id_role_idx ON service_account_role (id_role);