-- Create table produit (V1.0.0)
CREATE TABLE produit
(
    id               INT8 PRIMARY KEY,
    audit_create_by  VARCHAR(100),
    audit_create_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    audit_update_by  VARCHAR(100),
    audit_update_at  TIMESTAMP WITHOUT TIME ZONE,
    version          INTEGER DEFAULT 0,
    code             VARCHAR(255) NOT NULL,
    designation             VARCHAR(255) NOT NULL,
    description      VARCHAR(255) NOT NULL,
    prix            INT4         NOT NULL,
    quantite         INT4         NOT NULL,
    statut_inventaire VARCHAR(255) NOT NULL,
    image            VARCHAR(255),
    notation           INT4,
    categorie_id      INT8         NOT NULL,
    CONSTRAINT p_categorie_id FOREIGN KEY (categorie_id) REFERENCES categorie (id)
);

-- Créer la séquence
DROP SEQUENCE IF EXISTS produit_seq;
CREATE SEQUENCE produit_seq START WITH 1 INCREMENT BY 1;
ALTER TABLE produit
    ALTER COLUMN id SET DEFAULT nextval('produit_seq');

-- Créer les index
CREATE INDEX p_categorie_id_idx on produit (categorie_id);
