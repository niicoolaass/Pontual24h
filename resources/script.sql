create database pontual24h;

CREATE TABLE horario_trabalho (
    id INT AUTO_INCREMENT PRIMARY KEY,
    diasSemana VARCHAR(50),
    horarioEntrada TIME,
    horarioSaida TIME,
    intervalo TIME
);

CREATE TABLE funcionarios (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(40),
    dataNascimento DATE,
    cargo VARCHAR(40),
    setor VARCHAR(40),
    dataAdmissao DATE,
    id_horarioTrabalho INT,
    status ENUM('Ativo', 'Inativo') DEFAULT 'Ativo',
    FOREIGN KEY (id_horarioTrabalho) REFERENCES horario_trabalho(id)
);

CREATE TABLE registro_ponto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_funcionario INT,
    data DATE,
    hora TIME,
    tipoRegistro ENUM('Entrada', 'Saída'),
    FOREIGN KEY (id_funcionario) REFERENCES Funcionarios(id)
);


