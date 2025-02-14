CREATE TABLE IF NOT EXISTS public.dec
(
    id         BIGSERIAL primary key ,
    name       VARCHAR(20) NOT NULL,
    created_at DATE        NOT NULL
) PARTITION BY RANGE (created_at);

CREATE TABLE dec2021 PARTITION OF dec
    FOR VALUES FROM ('2021-01-01') TO ('2022-01-01');
CREATE TABLE dec2022 PARTITION OF dec
    FOR VALUES FROM ('2022-01-01') TO ('2023-01-01');
CREATE TABLE dec2023 PARTITION OF dec
    FOR VALUES FROM ('2023-01-01') TO ('2024-01-01');
CREATE TABLE dec2024 PARTITION OF dec
    FOR VALUES FROM ('2024-01-01') TO ('2025-01-01');
CREATE TABLE dec2025 PARTITION OF dec
    FOR VALUES FROM ('2025-01-01') TO ('2026-01-01');

-- по хэшу

CREATE TABLE part_0 PARTITION OF dec FOR VALUES WITH (MODULUS 5, REMAINDER 0);
CREATE TABLE part_1 PARTITION OF dec FOR VALUES WITH (MODULUS 5, REMAINDER 1);
CREATE TABLE part_2 PARTITION OF dec FOR VALUES WITH (MODULUS 5, REMAINDER 2);
CREATE TABLE part_3 PARTITION OF dec FOR VALUES WITH (MODULUS 5, REMAINDER 3);
CREATE TABLE part_5 PARTITION OF dec FOR VALUES WITH (MODULUS 5, REMAINDER 4);

drop table dec;

-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

-- CREATE INDEX dec_y2021m01n ON dec_y2021m01 (created_at);
-- CREATE INDEX dec_y2021m02n ON dec_y2021m02 (created_at);
-- CREATE INDEX dec_y2021m03n ON dec_y2021m03 (created_at);
-- CREATE INDEX dec_y2021m04n ON dec_y2021m04 (created_at);
-- CREATE INDEX dec_y2021m05n ON dec_y2021m05 (created_at);


-- ТРИГГЕР

-- CREATE OR REPLACE FUNCTION
--     dec_insert_trigger()
--     RETURNS TRIGGER AS $$
-- BEGIN
--     IF ( NEW.created_at >= '2021-01-01'::DATE AND
--          NEW.created_at < '2022-01-01'::DATE ) THEN
--         INSERT INTO dec_y2021m01 VALUES (NEW.*);
--     ELSIF ( NEW.created_at >= '2022-01-01'::DATE AND
--             NEW.created_at < '2023-01-01'::DATE ) THEN
--         INSERT INTO dec_y2021m02 VALUES (NEW.*);
--     ELSIF ( NEW.created_at >= '2023-01-01'::DATE AND
--             NEW.created_at < '2024-01-01'::DATE ) THEN
--         INSERT INTO dec_y2021m03 VALUES (NEW.*);
--     ELSIF ( NEW.created_at >= '2024-01-01'::DATE AND
--             NEW.created_at < '2025-01-01'::DATE ) THEN
--         INSERT INTO dec_y2021m04 VALUES (NEW.*);
--     ELSIF ( NEW.created_at >= '2025-01-01'::DATE AND
--             NEW.created_at < '2026-01-01'::DATE ) THEN
--         INSERT INTO dec_y2021m05 VALUES (NEW.*);
--     ELSE
--         RAISE EXCEPTION 'Date out of range.
--         Fix the dec_insert_trigger() function!';
--     END IF;
--     RETURN NULL;
-- END;
-- $$
--     LANGUAGE plpgsql;
--

CREATE OR REPLACE FUNCTION dec_insert_trigger()
    RETURNS TRIGGER AS
$$
DECLARE
    current_date_part      DATE;
    current_date_part_text TEXT;
    partition_table_name   TEXT;
    second_year            DATE;
BEGIN
    current_date_part := CAST(DATE_TRUNC('year', NEW.created_at) AS DATE);
    current_date_part_text := REGEXP_REPLACE(current_date_part::TEXT, '-', '_', 'g');
    partition_table_name := FORMAT('dec_%s', current_date_part_text::TEXT);
    IF (TO_REGCLASS(partition_table_name::TEXT) ISNULL) THEN
        second_year := current_date_part + '1 year'::INTERVAL;

        EXECUTE FORMAT(
                'CREATE TABLE %I PARTITION OF dec
                FOR VALUES FROM (%L) TO (%L)'
            , partition_table_name, current_date_part, second_year
            );

    END IF;

    EXECUTE FORMAT('INSERT INTO %I (name, created_at) VALUES ($1, $2)', partition_table_name)
        USING NEW.name, NEW.created_at;

    RETURN NULL;
END;
$$
    LANGUAGE plpgsql;

CREATE TRIGGER insert_dec
    BEFORE INSERT
    ON dec
    FOR EACH ROW
EXECUTE FUNCTION dec_insert_trigger();

-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
INSERT INTO dec(name, created_at)
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
--        ('Юра11', '2026-12-01');

TRUNCATE TABLE ONLY dec;
-- TRUNCATE TABLE dec_y2021m01;
-- TRUNCATE TABLE dec_y2021m02;
-- TRUNCATE TABLE dec_y2021m03;
-- TRUNCATE TABLE dec_y2021m04;
-- TRUNCATE TABLE dec_y2021m05;

EXPLAIN
SELECT name
FROM dec
WHERE name = 'Юра1'
  and created_at = '2025-12-01';
--         WHERE name = 'Юра2'
--         group by name;

ALTER TABLE dec
    ADD CHECK ( 1 <> 1 );

SELECT conname
FROM pg_constraint
WHERE conrelid = 'dec'::regclass
  AND contype = 'c';

ALTER TABLE dec
    drop constraint dec_check;


