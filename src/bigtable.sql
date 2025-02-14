CREATE TABLE IF NOT EXISTS public.bigtable
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(20) NOT NULL,
    created_at DATE        NOT NULL
);

CREATE TABLE bigtable_y2021m01 (
    CHECK (created_at >= '2021-01-01'::DATE AND created_at < '2022-01-01'::DATE)
) INHERITS (bigtable);

CREATE TABLE bigtable_y2021m02 (
    CHECK (created_at >= '2022-01-01'::DATE AND created_at < '2023-01-01'::DATE)
) INHERITS (bigtable);

CREATE TABLE bigtable_y2021m03 (
    CHECK (created_at >= '2023-01-01'::DATE AND created_at < '2024-01-01'::DATE)
) INHERITS (bigtable);

CREATE TABLE bigtable_y2021m04 (
    CHECK (created_at >= '2024-01-01'::DATE AND created_at < '2025-01-01'::DATE)
) INHERITS (bigtable);

CREATE TABLE bigtable_y2021m05 (
    CHECK (created_at >= '2025-01-01'::DATE AND created_at < '2026-01-01'::DATE)
) INHERITS (bigtable);
-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

-- CREATE INDEX bigtable_y2021m01n ON bigtable_y2021m01 (created_at);
-- CREATE INDEX bigtable_y2021m02n ON bigtable_y2021m02 (created_at);
-- CREATE INDEX bigtable_y2021m03n ON bigtable_y2021m03 (created_at);
-- CREATE INDEX bigtable_y2021m04n ON bigtable_y2021m04 (created_at);
-- CREATE INDEX bigtable_y2021m05n ON bigtable_y2021m05 (created_at);


-- ТРИГГЕР

-- CREATE OR REPLACE FUNCTION
--     bigtable_insert_trigger()
--     RETURNS TRIGGER AS $$
-- BEGIN
--     IF ( NEW.created_at >= '2021-01-01'::DATE AND
--          NEW.created_at < '2022-01-01'::DATE ) THEN
--         INSERT INTO bigtable_y2021m01 VALUES (NEW.*);
--     ELSIF ( NEW.created_at >= '2022-01-01'::DATE AND
--             NEW.created_at < '2023-01-01'::DATE ) THEN
--         INSERT INTO bigtable_y2021m02 VALUES (NEW.*);
--     ELSIF ( NEW.created_at >= '2023-01-01'::DATE AND
--             NEW.created_at < '2024-01-01'::DATE ) THEN
--         INSERT INTO bigtable_y2021m03 VALUES (NEW.*);
--     ELSIF ( NEW.created_at >= '2024-01-01'::DATE AND
--             NEW.created_at < '2025-01-01'::DATE ) THEN
--         INSERT INTO bigtable_y2021m04 VALUES (NEW.*);
--     ELSIF ( NEW.created_at >= '2025-01-01'::DATE AND
--             NEW.created_at < '2026-01-01'::DATE ) THEN
--         INSERT INTO bigtable_y2021m05 VALUES (NEW.*);
--     ELSE
--         RAISE EXCEPTION 'Date out of range.
--         Fix the bigtable_insert_trigger() function!';
--     END IF;
--     RETURN NULL;
-- END;
-- $$
--     LANGUAGE plpgsql;
--

CREATE OR REPLACE FUNCTION bigtable_insert_trigger()
    RETURNS TRIGGER AS $$
DECLARE
    current_date_part DATE;
    current_date_part_text TEXT;
    partition_table_name TEXT;
    second_year DATE;
BEGIN
    current_date_part := CAST(DATE_TRUNC('year', NEW.created_at) AS DATE);
    current_date_part_text := REGEXP_REPLACE(current_date_part::TEXT, '-','_','g');
    partition_table_name := FORMAT('bigtable_%s', current_date_part_text::TEXT);
    IF (TO_REGCLASS(partition_table_name::TEXT) ISNULL) THEN
        second_year := current_date_part + '1 year'::INTERVAL;
        EXECUTE FORMAT(
                'CREATE TABLE %I ('
                    '  CHECK (created_at >= DATE %L AND created_at < DATE %L)'
                    ') INHERITS (bigtable);'
            , partition_table_name, current_date_part, second_year);
        EXECUTE FORMAT(
                'ALTER TABLE ONLY %1$I ADD CONSTRAINT %1$s__pkey PRIMARY KEY (id);'
            , partition_table_name);
        EXECUTE FORMAT(
                'CREATE INDEX %1$s__created_at ON %1$I (created_at);'
            , partition_table_name);
    END IF;
    EXECUTE FORMAT('INSERT INTO %I VALUES ($1.*)', partition_table_name) USING NEW;

    RETURN NULL;
END;
$$
    LANGUAGE plpgsql;

CREATE TRIGGER insert_bigtable
    BEFORE INSERT ON bigtable
    FOR EACH ROW EXECUTE FUNCTION bigtable_insert_trigger();

-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
INSERT INTO bigtable(name, created_at)
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

TRUNCATE TABLE ONLY bigtable;
-- TRUNCATE TABLE bigtable_y2021m01;
-- TRUNCATE TABLE bigtable_y2021m02;
-- TRUNCATE TABLE bigtable_y2021m03;
-- TRUNCATE TABLE bigtable_y2021m04;
-- TRUNCATE TABLE bigtable_y2021m05;

EXPLAIN
SELECT name
FROM only bigtable
WHERE name = 'Юра1'
  and created_at = '2021-12-01';

ALTER TABLE bigtable ADD CHECK ( 1 <> 1 );

SELECT conname
FROM pg_constraint
WHERE conrelid = 'bigtable'::regclass AND contype = 'c';

ALTER TABLE bigtable drop constraint bigtable_check;