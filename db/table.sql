CREATE TABLE IF NOT EXISTS court(
 id SERIAL PRIMARY KEY,
 court_name text,
 court_address text
);

CREATE TABLE IF NOT EXISTS position(
 id SERIAL PRIMARY KEY,
 position_name text
);

insert into position(position_name) values('Председатель суда');
insert into position(position_name) values('Судья');
insert into position(position_name) values('Помощник судьи');
insert into position(position_name) values('Секретарь суда');
insert into position(position_name) values('Сотрудник суда');

CREATE TABLE IF NOT EXISTS employee(
 id SERIAL PRIMARY KEY,
 first_name text,
 middle_name text,
 last_name text,
 address text
 court_id int NOT NULL REFERENCES court(id),
 position_id int NOT NULL REFERENCES position(id),
 users_id int NOT NULL REFERENCES users(id)
);

CREATE TABLE users(
 id SERIAL PRIMARY KEY,
 name text,
 phone text,
 email text,
 password text
);