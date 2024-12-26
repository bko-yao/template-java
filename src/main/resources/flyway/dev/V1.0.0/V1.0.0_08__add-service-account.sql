INSERT INTO public.service_account
(id, audit_create_by, audit_create_at, audit_update_by,
 audit_update_at, "version", email, phone_number, "password",
 last_connexion_date, first_connexion_date, login_with_phone_number, login_with_email, asset, id_person)
VALUES (nextval('service_account_seq'::regclass), 'system', '2024-07-05 00:03:24.366', NULL, NULL, 0,
        'tacheron@email.com', '0102030405', '$2a$10$ZGxEN5MBNFvPvP3.Daj4VutPMP9br3SUA/j8Hze7u.OTNCMuYfxsC',
        NULL, NULL, false, true, true, (select id from person where code = 'CU65690'));