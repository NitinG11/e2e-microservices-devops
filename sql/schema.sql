CREATE TABLE users (
                         user_id uuid GENERATED ALWAYS AS IDENTITY ,
                         first_name VARCHAR(128) NOT NULL,
                         last_name VARCHAR(128) NOT NULL,
                         email VARCHAR(128) NOT NULL,
                         national_identification VARCHAR(128) NOT NULL,
                         PRIMARY KEY (user_id)
);
