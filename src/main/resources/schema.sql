CREATE TABLE IF NOT EXISTS cities (
    id SERIAL PRIMARY KEY,
    name VARCHAR (32) NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS clubs (
    id SERIAL PRIMARY KEY,
    name VARCHAR (32) NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS activities (
    id SERIAL PRIMARY KEY,
    name VARCHAR (128) NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS arenas (
    id SERIAL PRIMARY KEY,
    name VARCHAR (32) NOT NULL UNIQUE,
    club_id INT REFERENCES clubs (id),
    city_id INT REFERENCES cities (id),
    capacity INT NOT NULL,
    entry_year INT NOT NULL,
    gallery_url VARCHAR (64) NOT NULL,
    tickets_url VARCHAR (64) NOT NULL,
    attendance INT NOT NULL,
    fill_percentage INT GENERATED ALWAYS AS (ROUND(( attendance::NUMERIC/capacity::NUMERIC ) * 100)) STORED,
    prices VARCHAR (16) NOT NULL,
    revenue INT GENERATED ALWAYS AS 
    ((split_part(prices, '-', 1)::INT + split_part(prices, '-', 2)::INT) / 2 * attendance) STORED,
    activities_id INT REFERENCES activities (id)
    );
