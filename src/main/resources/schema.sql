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
    gallery_url VARCHAR (128) GENERATED ALWAYS AS ('https://raw.githubusercontent.com/romanyukalexandr84/Images/main/' || REPLACE(name,' ','%20') || '/') STORED NOT NULL,
    tickets_url VARCHAR (64) NOT NULL,
    attendance INT NOT NULL,
    fill_percentage INT GENERATED ALWAYS AS (ROUND(( attendance::NUMERIC/capacity::NUMERIC ) * 100)) STORED NOT NULL,
    prices VARCHAR (16) NOT NULL,
    revenue INT GENERATED ALWAYS AS 
    ((split_part(prices, '-', 1)::INT + split_part(prices, '-', 2)::INT) / 2 * attendance) STORED NOT NULL,
    activities_id INT REFERENCES activities (id)
    );

CREATE TABLE IF NOT EXISTS messages (
    id SERIAL PRIMARY KEY,
    from_user VARCHAR (32) NOT NULL,
    body VARCHAR (256) NOT NULL UNIQUE
    );