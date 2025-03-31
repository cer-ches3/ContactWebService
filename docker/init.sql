-- Создание схемы tasks_schema
CREATE SCHEMA IF NOT EXISTS contacts_schema;

-- Создание таблицы task в схеме tasks_schema
CREATE TABLE IF NOT EXISTS contacts_schema.contact
(
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL
);