INSERT INTO worker (id, name, birthday, level, salary)
VALUES
(1, 'John Smith', '1985-01-04', 'Trainee', 800),
(2, 'Jane Doe', '1990-05-05', 'Junior', 1200),
(3, 'Robert Johnson', '1982-06-06', 'Middle', 3000),
(4, 'Maria Rodriguez', '1985-06-7', 'Senior', 5000),
(5, 'David Lee', '1990-05-01', 'Trainee', 900),
(6, 'Emily Chen',' 1989-06-08', 'Junior', 1500),
(7, 'Michael Brown', '1980-09-09', 'Middle', 4000),
(8, 'Amanda Wilson', '1975-10-10', 'Senior', 7000),
(9, 'William Davis', '1987-11-11', 'Trainee', 1000),
(10, 'Olivia Taylor', '1995-12-12', 'Junior', 2000);

INSERT INTO client (id, name)
VALUES
(1, 'Larry Bird'),
(2, 'Jason Tatum'),
(3, 'Bill Russel'),
(4, 'Jaylen Brown'),
(5, 'Kyrie Irving');

INSERT INTO project (id, client_id, start_date, finish_date)
VALUES
(1, 1, '2022-01-01', '2022-03-31'),
(2, 2, '2022-02-15', '2022-06-30'),
(3, 3, '2022-04-01', '2022-07-31'),
(4, 4, '2022-05-01', '2022-08-31'),
(5, 5, '2022-06-01', '2022-09-30'),
(6, 1, '2022-07-01', '2022-10-31'),
(7, 2, '2022-08-01', '2022-11-30'),
(8, 3, '2022-09-01', '2022-12-31'),
(9, 4, '2022-10-01', '2023-01-31'),
(10, 5, '2022-11-01', '2023-02-28');

INSERT INTO project_worker (project_id, worker_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(3, 6),
(3, 7),
(4, 8),
(4, 9),
(4, 10),
(5, 1),
(5, 4),
(6, 2),
(6, 5),
(6, 8),
(7, 3),
(7, 6),
(7, 9),
(8, 1),
(8, 5),
(8, 7),
(9, 2),
(9, 6),
(9, 10),
(10, 3),
(10, 4),
(10, 8);
