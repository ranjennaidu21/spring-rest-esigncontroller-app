CREATE TABLE customer(
    id INT IDENTITY (1, 1) NOT NULL,
    first_name VARCHAR(MAX),
    last_name VARCHAR(MAX),
	email VARCHAR(MAX)
);

INSERT INTO customer (first_name, last_name, email)
  VALUES
      ('Rara','Baba','rara@test.com');

INSERT INTO customer (first_name, last_name, email)
  VALUES
      ('Kaka','Sasa','kaka@test.com');

INSERT INTO customer (first_name, last_name, email)
  VALUES
      ('Mama','Lala','mama@test.com');