-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS idosoapp;
USE idosoapp;

-- Tabela Idosa
CREATE TABLE IF NOT EXISTS idosa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    data_nascimento DATE,
    nome_mae VARCHAR(100),
    cartao_sus VARCHAR(30),
    data_entrada DATE
);

-- Tabela ProfissionalSaude
CREATE TABLE IF NOT EXISTS profissional_saude (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    especialidade VARCHAR(100),
    registro_profissional VARCHAR(50)
);

-- Tabela ProntuarioMedico
CREATE TABLE IF NOT EXISTS prontuario_medico (
    id INT PRIMARY KEY AUTO_INCREMENT,
    data_hora_idosa DATETIME,
    idosa_id INT,
    FOREIGN KEY (idosa_id) REFERENCES idosa(id)
);

-- Tabela Consulta
CREATE TABLE IF NOT EXISTS consulta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    data_hora DATETIME,
    profissional_id INT,
    tipo VARCHAR(50),
    motivo VARCHAR(200),
    diagnostico VARCHAR(200),
    prontuario_id INT,
    FOREIGN KEY (profissional_id) REFERENCES profissional_saude(id),
    FOREIGN KEY (prontuario_id) REFERENCES prontuario_medico(id)
);

-- Tabela Prescricao
CREATE TABLE IF NOT EXISTS prescricao (
    id INT PRIMARY KEY AUTO_INCREMENT,
    medicamento VARCHAR(100),
    posologia VARCHAR(100),
    duracao VARCHAR(50),
    observacoes VARCHAR(200),
    prontuario_id INT,
    FOREIGN KEY (prontuario_id) REFERENCES prontuario_medico(id)
);

-- Tabela Vacina
CREATE TABLE IF NOT EXISTS vacina (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    data_ocorrencia DATE,
    prontuario_id INT,
    FOREIGN KEY (prontuario_id) REFERENCES prontuario_medico(id)
);

-- Tabela EventoSentinela
CREATE TABLE IF NOT EXISTS evento_sentinela (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(100),
    data_ocorrencia DATE,
    prontuario_id INT,
    FOREIGN KEY (prontuario_id) REFERENCES prontuario_medico(id)
);

-- Tabela Relatorio
CREATE TABLE IF NOT EXISTS relatorio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(200),
    tipo VARCHAR(100),
    prontuario_id INT,
    FOREIGN KEY (prontuario_id) REFERENCES prontuario_medico(id)
);
