CREATE DATABASE "Integradora"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE cliente (
	id serial primary key,
	nome varchar (60) not null,
	cpf varchar(15) not null,
	dataNascimento date not null,
	email varchar(100) not null,
	telefone varchar(15) not null
);

CREATE TABLE funcionario (
	id serial primary key,
	nome varchar(60) not null,
	cpf varchar(15) not null,
	cargo varchar(2) not null
);

CREATE TABLE quarto (
	id serial primary key,
	tipo varchar(2),
	valor numeric (15,2)
);

CREATE TABLE reserva (
	id serial primary key,
	id_funcionario integer not null,
	id_cliente integer not null,
	id_quarto integer not null,
	valor numeric(15,2) not null,
	data date not null,
	
	FOREIGN KEY (id_funcionario) REFERENCES funcionario (id),
 	FOREIGN KEY (id_cliente) REFERENCES cliente (id),
 	FOREIGN KEY (id_quarto) REFERENCES quarto (id)
);