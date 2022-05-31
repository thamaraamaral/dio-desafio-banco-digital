create database bd_banco_digital;
use bd_banco_digital;

create table cliente(
	idcliente			integer			auto_increment,
    nome				varchar(150)	not null,
    email				varchar(100)	not null,
    celular				varchar(50)		not	null,
    primary key(idcliente)
);

desc cliente;