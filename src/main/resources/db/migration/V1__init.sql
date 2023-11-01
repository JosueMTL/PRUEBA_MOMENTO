CREATE TABLE IF NOT EXISTS conference (
    id SERIAL,
    title VARCHAR(50),
    description VARCHAR(50),
    city VARCHAR(50),
    total_assistants INT,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS assistant (
    id SERIAL,
    full_name VARCHAR(100),
    rols VARCHAR(20),
    age INT,
    conference_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (conference_id) REFERENCES conference(id)
    );
