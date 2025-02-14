create table if not exists public.users
(
    id BIGSERIAL PRIMARY KEY,
    name varchar (30),
    data date
) PARTITION BY RANGE (extract(YEAR FROM data));

CREATE TABLE users1 PARTITION OF users
    FOR VALUES FROM (MINVALUE) TO (2022);

CREATE TABLE users2 PARTITION OF users
    FOR VALUES FROM (2022) TO (2023);

CREATE TABLE users3 PARTITION OF users
    FOR VALUES FROM (2023) TO (MAXVALUE);

drop table "users";

truncate table users;

INSERT INTO users(name, data)
VALUES ('Юра1', '2021-12-01'),
       ('Юра2', '2021-12-01'),
       ('Юра3', '2022-12-01'),
       ('Юра4', '2022-12-01'),
       ('Юра5', '2023-12-01'),
       ('Юра6', '2023-12-01'),
       ('Юра7', '2024-12-01'),
       ('Юра8', '2024-12-01'),
       ('Юра9', '2025-12-01'),
       ('Юра10', '2025-12-01');

