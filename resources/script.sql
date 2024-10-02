create database pontual24h;

create table funcionarios(
    id_funcionario int not null auto_increment primary key,
    nome varchar(40),
    data_nascimento date,
    cargo varchar(40),
    dataAdmissao date,
    status varchar
);
