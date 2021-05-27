create database forum;

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
/*
user's password = 123
*/
insert into users (username, password) values ('user', '$2a$10$CIOtBEoDodsLTff9psABW.yvXCF1JXwADvXUqFUCILy/g6sguv.OW');

insert into posts (name, description) values ('What is this forum about?','bla-bla-bla');
insert into posts (name, description) values ('The rules','bla-bla-bla');

