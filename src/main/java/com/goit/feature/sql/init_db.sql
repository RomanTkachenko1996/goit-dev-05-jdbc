CREATE TABLE worker(
  id BIGINT PRIMARY KEY,
  name VARCHAR CHECK (LENGTH(name) BETWEEN 2 AND 1000),
  birthday DATE CHECK (birthday > '1900-01-01'),
  level VARCHAR NOT NULL CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior')),
  salary BIGINT CHECK(salary BETWEEN 100 AND 100000)
);

CREATE TABLE client(
  id BIGINT PRIMARY KEY,
  name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) BETWEEN 2 AND 1000)
);

CREATE TABLE project(
  id BIGINT PRIMARY KEY,
  client_id BIGINT,
  FOREIGN KEY (client_id) REFERENCES client(id),
  start_date DATE,
  finish_date DATE
);

CREATE TABLE project_worker(
  project_id BIGINT,
  worker_id BIGINT,
  FOREIGN KEY (project_id) REFERENCES project(id),
  FOREIGN KEY (worker_id) REFERENCES worker(id),
  PRIMARY KEY (project_id, worker_id)
);
