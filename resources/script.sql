create database pontual24h;

create table funcionarios(
    id int not null auto_increment primary key,
    nome varchar(40),
    dataNascimento date,
    cargo varchar(40),
    setor varchar(40),
    dataAdmissao date,
    status ENUM('Ativo', 'Inativo') DEFAULT 'Ativo',
);

CREATE TABLE Horarios_Trabalho (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_funcionario INT,
    diasSemana VARCHAR(50),
    horarioEntrada TIME,
    horarioSaida TIME,
    intervalo TIME,
    FOREIGN KEY (id_funcionario) REFERENCES Funcionarios(id)
);

CREATE TABLE Registro_Ponto (
    id_registro INT AUTO_INCREMENT PRIMARY KEY,
    id_funcionario INT,
    dataHora DATETIME,
    tipoRegistro ENUM('Entrada', 'Saída'),
    FOREIGN KEY (id_funcionario) REFERENCES Funcionarios(id)
);


