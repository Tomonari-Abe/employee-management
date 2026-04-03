INSERT INTO department (department_name, created_at, updated_at)
VALUES ('営業部', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO employee (last_name, first_name, birth_date, hire_date, retirement_date, created_at, updated_at)
VALUES ('山田', '太郎', '1990-01-01', '2020-04-01', NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO employee_department_history (employee_id, department_id, start_date, created_at, updated_at)
VALUES (1, 1, '2020-04-01', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);