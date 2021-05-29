create table posts (
                       id serial primary key,
                       name varchar(2000),
                       description text,
                       created timestamp not null default now()
);
create table users (
                       id serial primary key,
                       username VARCHAR(50) NOT NULL unique,
                       password VARCHAR(100) NOT NULL
);


