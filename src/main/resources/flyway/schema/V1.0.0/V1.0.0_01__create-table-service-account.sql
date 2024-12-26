-- Create table service_account (V1.0.0)
CREATE TABLE service_account
(
    id                      INT8 PRIMARY KEY,
    audit_create_by         VARCHAR(100),
    audit_create_at         TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    audit_update_by         VARCHAR(100),
    audit_update_at         TIMESTAMP WITHOUT TIME ZONE,
    version                 INTEGER DEFAULT 0,
    email                   VARCHAR(255) NOT NULL,
    phone_number            VARCHAR(255) NOT NULL,
    password                VARCHAR(255) NOT NULL,
    last_connexion_date     TIMESTAMP WITHOUT TIME ZONE,
    first_connexion_date TIMESTAMP WITHOUT TIME ZONE,
    login_with_phone_number boolean DEFAULT false,
    login_with_email        boolean DEFAULT false,
    asset                   boolean DEFAULT false,
    id_person               INT8         NOT NULL,
    CONSTRAINT sa_id_person_fk FOREIGN KEY (id_person) REFERENCES person (id),
    CONSTRAINT sa_email_unique UNIQUE (email),
    CONSTRAINT sa_phone_number_unique UNIQUE (phone_number)
);

-- Créer les séquences.
DROP SEQUENCE IF EXISTS service_account_seq;
CREATE SEQUENCE service_account_seq START WITH 1 INCREMENT BY 1;
ALTER TABLE service_account
    ALTER COLUMN id SET DEFAULT nextval('service_account_seq');

-- Créer les index
CREATE INDEX sa_email_idx on service_account (email);
CREATE INDEX sa_phone_number_idx on service_account (phone_number);
CREATE INDEX sa_id_person_idx on service_account (id_person);