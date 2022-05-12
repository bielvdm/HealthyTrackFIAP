--DDL
CREATE DATABASE HealthyTrack

USE HealthyTrack

CREATE TABLE Usuario (

id_usuario          INT PRIMARY KEY IDENTITY, 
email_usuario       VARCHAR(150) NOT NULL,
senha_usuario		VARCHAR(100) NOT NULL,
numero_usuario		INT NOT NULL,
altura_usuario		INT NOT NULL		
);

CREATE TABLE HistoricoPeso (

id_usuario		INT FOREIGN KEY REFERENCES Usuario (id_usuario),
data_lista      DATE NOT NULL,
peso_lista		FLOAT NOT NULL

);

CREATE TABLE PressaoUsuario (

id_usuario		INT FOREIGN KEY REFERENCES Usuario (id_usuario),
p_arterial      INT NOT NULL

);

CREATE TABLE IntensidadeAtividade (
id_intesidade        INT PRIMARY KEY IDENTITY, 
nome_atividade       VARCHAR(50) NOT NULL,
)

CREATE TABLE AtividadeFisica (

id_usuario			INT FOREIGN KEY REFERENCES Usuario (id_usuario),
nome_atividade      VARCHAR(50) NOT NULL,
tempo_atividade		FLOAT NOT NULL,
id_intesidade		INT FOREIGN KEY REFERENCES IntensidadeAtividade (id_intesidade),
data_atividade      DATE NOT NULL

);

CREATE TABLE Alimentos (

id_usuario		INT FOREIGN KEY REFERENCES Usuario (id_usuario),
nome_alimentos  VARCHAR(100) NOT NULL,
qnt_alimentos	FLOAT NOT NULL

);