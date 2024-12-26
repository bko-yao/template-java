INSERT INTO public.service_account_role
(id, audit_create_by, audit_create_at, audit_update_by, audit_update_at, "version", id_service_account, id_role)
VALUES (nextval('service_account_role_seq'::regclass), NULL, NULL, NULL, NULL, 0, (select id from service_account where email = 'tacheron@email.com'),
        (select id from "role" where name = 'IT'));