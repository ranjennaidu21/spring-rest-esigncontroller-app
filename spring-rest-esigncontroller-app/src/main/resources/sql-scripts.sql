CREATE TABLE customer(
    id INT IDENTITY (1, 1) NOT NULL,
    first_name VARCHAR(MAX),
    last_name VARCHAR(MAX),
	email VARCHAR(MAX)
);

CREATE TABLE users (
    user_id BIGINT IDENTITY (1, 1) NOT NULL PRIMARY KEY,
    username VARCHAR(450),
    password VARCHAR(MAX),
    enabled BIT,
	CONSTRAINT AK_Username UNIQUE(username)
);

INSERT INTO customer (first_name, last_name, email) VALUES
('Rara','Baba','rara@test.com'),
('Kaka','Sasa','kaka@test.com'),
('Mama','Lala','mama@test.com');

INSERT INTO users (username, password, enabled) VALUES 
	('user1@test.com', 'user1', 1),
	('user2@test.com', 'user2', 1),
	('user3@test.com', 'user3', 1);