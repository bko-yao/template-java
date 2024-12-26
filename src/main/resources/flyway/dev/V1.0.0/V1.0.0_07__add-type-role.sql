INSERT INTO role(id, audit_create_by, audit_create_at, audit_update_by, audit_update_at, name)
VALUES (nextval('role_seq'::regclass), 'system', now(), 'system', now(), 'IT') ON CONFLICT (id) DO NOTHING;
INSERT INTO role(id, audit_create_by, audit_create_at, audit_update_by, audit_update_at, name)
VALUES (nextval('role_seq'::regclass), 'system', now(), 'system', now(), 'ENTREPRISE') ON CONFLICT (id) DO NOTHING;
INSERT INTO role(id, audit_create_by, audit_create_at, audit_update_by, audit_update_at, name)
VALUES (nextval('role_seq'::regclass), 'system', now(), 'system', now(), 'CUSTOMER') ON CONFLICT (id) DO NOTHING;
INSERT INTO role(id, audit_create_by, audit_create_at, audit_update_by, audit_update_at, name)
VALUES (nextval('role_seq'::regclass), 'system', now(), 'system', now(), 'PROFESSIONAL_PROVIDER') ON CONFLICT (id) DO NOTHING;
INSERT INTO role(id, audit_create_by, audit_create_at, audit_update_by, audit_update_at, name)
VALUES (nextval('role_seq'::regclass), 'system', now(), 'system', now(), 'PROFESSIONAL_ADVISOR') ON CONFLICT (id) DO NOTHING;
INSERT INTO role(id, audit_create_by, audit_create_at, audit_update_by, audit_update_at, name)
VALUES (nextval('role_seq'::regclass), 'system', now(), 'system', now(), 'ENTREPRISE_ADVISOR') ON CONFLICT (id) DO NOTHING;
INSERT INTO role(id, audit_create_by, audit_create_at, audit_update_by, audit_update_at, name)
VALUES (nextval('role_seq'::regclass), 'system', now(), 'system', now(), 'SALES') ON CONFLICT (id) DO NOTHING;
INSERT INTO role(id, audit_create_by, audit_create_at, audit_update_by, audit_update_at, name)
VALUES (nextval('role_seq'::regclass), 'system', now(), 'system', now(), 'COMPLIANCE') ON CONFLICT (id) DO NOTHING;
INSERT INTO role(id, audit_create_by, audit_create_at, audit_update_by, audit_update_at, name)
VALUES (nextval('role_seq'::regclass), 'system', now(), 'system', now(), 'DIRECTOR') ON CONFLICT (id) DO NOTHING;
INSERT INTO role(id, audit_create_by, audit_create_at, audit_update_by, audit_update_at, name)
VALUES (nextval('role_seq'::regclass), 'system', now(), 'system', now(), 'WORKER') ON CONFLICT (id) DO NOTHING;
