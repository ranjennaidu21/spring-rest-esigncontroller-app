
CREATE TABLE customer(
    id INT PRIMARY KEY,
    first_name VARCHAR(MAX),
    last_name VARCHAR(MAX),
	email VARCHAR(MAX)
);

INSERT INTO customer (id, first_name, last_name, email)
  VALUES
      (1, 'Rara','Baba','rara@test.com');

INSERT INTO customer (id, first_name, last_name, email)
  VALUES
      (2, 'Kaka','Sasa','kaka@test.com');

INSERT INTO customer (id, first_name, last_name, email)
  VALUES
      (3, 'Mama','Lala','mama@test.com');