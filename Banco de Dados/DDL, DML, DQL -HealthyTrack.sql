--CRIAR TABELAS

CREATE DATABASE HEALTHYTRACK
GO

USE HEALTHYTRACK
GO

CREATE TABLE T_USUARIO (

ID_USUARIO          INT PRIMARY KEY IDENTITY, 
NOME_USUARIO        VARCHAR(100) NOT NULL,
EMAIL_USUARIO       VARCHAR(150) NOT NULL,
SENHA_USUARIO		VARCHAR(100) NOT NULL,
NUMERO_USUARIO		INT NOT NULL,
ALTURA_USUARIO		INT NOT NULL		
);
GO

CREATE TABLE T_HISTORICO_PESO (

ID_PESO         INT PRIMARY KEY IDENTITY,
ID_USUARIO		INT FOREIGN KEY REFERENCES T_USUARIO (ID_USUARIO),
DATA_LISTA      DATE NOT NULL,
PESO_LISTA		FLOAT NOT NULL

);
GO

CREATE TABLE T_INTENSIDADE_ATIVIDADE (
ID_INTESIDADE        INT PRIMARY KEY IDENTITY, 
NOME_ATIVIDADE       VARCHAR(50) NOT NULL,
);
GO

CREATE TABLE T_ATIVIDADE_FISICA (

ID_USUARIO			INT FOREIGN KEY REFERENCES T_USUARIO (ID_USUARIO),
ID_ATIVIDADE		INT PRIMARY KEY IDENTITY,
NOME_ATIVIDADE      VARCHAR(50) NOT NULL,
TEMPO_ATIVIDADE		FLOAT NOT NULL,
ID_INTESIDADE		INT FOREIGN KEY REFERENCES T_INTENSIDADE_ATIVIDADE (ID_INTESIDADE),
DATA_ATIVIDADE      DATE NOT NULL

);
GO

CREATE TABLE T_ALIMENTOS (

ID_USUARIO		INT FOREIGN KEY REFERENCES T_USUARIO (ID_USUARIO),
ID_ALIMENTO		INT PRIMARY KEY IDENTITY,
NOME_ALIMENTOS  VARCHAR(100) NOT NULL,
QNT_ALIMENTOS	FLOAT NOT NULL

);

GO
CREATE TABLE PRES_USUARIO(
ID_USUARIO		INT FOREIGN KEY REFERENCES T_USUARIO (ID_USUARIO),
P_ID INT PRIMARY KEY IDENTITY,
P_ARTERIAL  FLOAT NOT NULL,
P_ARTERIAL_POR  FLOAT NOT NULL,
P_DATA_HORA TIMESTAMP NOT NULL
);
GO

-- DML

-- Cadastrar os dados do usuário. 

INSERT INTO T_USUARIO (NOME_USUARIO, EMAIL_USUARIO, SENHA_USUARIO, NUMERO_USUARIO, ALTURA_USUARIO) 
    VALUES    ('CARLOS ALBERTO', 'CARLOSALBERTO1@GMAIL.COM', 'CARLOS123', 1198765432, 178);


-- Cadastrar os dados para o peso do usuário.

INSERT INTO T_HISTORICO_PESO (ID_USUARIO, DATA_LISTA, PESO_LISTA)
    VALUES  (2, '20220514', 69.6);


-- Cadastrar os dados para a pressão arterial do usuário.
-- nao funcionou aq
        
INSERT INTO PRES_USUARIO ( P_ARTERIAL, P_ARTERIAL_POR, P_DATA_HORA, ID_USUARIO)
    VALUES ('12', '8', 
        TO_DATETIME('12/05/2022T15:30:50', 'DD/MM/YYYYTHH:MM:SS'));
        

-- Cadastrar os dados para o alimento consumido pelo usuário.

INSERT INTO T_ALIMENTOS (ID_USUARIO, NOME_ALIMENTOS, QNT_ALIMENTOS)
VALUES					(2, 'Chocolate', 3)


-- Alterar todos os dados do usuário, utilizando seu código como referência. 

UPDATE T_USUARIO
    SET NOME_USUARIO = 'RODRIGO MARTINS',
        EMAIL_USUARIO = 'RODRIGOM2@GMAIL.COM',
        SENHA_USUARIO = 'ROGER123',
        NUMERO_USUARIO = 1192345678,
        ALTURA_USUARIO = 170
    WHERE ID_USUARIO = 2;

-- Alterar todos os dados de peso do usuário, utilizando o código como referência.

UPDATE T_HISTORICO_PESO
    SET DATA_LISTA = '20220520',
        PESO_LISTA = 70.5

-- Alterar todos os dados de peso do usuário, utilizando o código como referência. 
-- dar uma olhada
UPDATE PRES_USUARIO
    SET P_ARTERIAL = '15.5',
        P_ARTERIAL_POR = '10'


-- Alterar todos os dados para o alimento consumido pelo usuário, utilizando o código como referência.

UPDATE T_ALIMENTOS 
SET
	NOME_ALIMENTOS = 'Morango',
	QNT_ALIMENTOS = 4
WHERE ID_ALIMENTO = 1


--DQL

-- Consultar os dados de um determinado usuário (filtrar a partir do seu código). 

SELECT * FROM T_USUARIO WHERE ID_USUARIO = 2;

-- Consultar todos os dados de todos os registros de peso de um determinado usuário, ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código).
-- nao funcionou aq

SELECT DATA_LISTA, PESO_LISTA
    FROM T_HISTORICO_PESO
    WHERE ID_USUARIO = 2;
    ORDER BY DATA_LISTA
    AND DATA = (SELECT MAX(DATA))
    SELECT DATA_LISTA
    FROM T_HISTORICO_PESO


-- Consultar todos os dados de um único registro de peso de um determinado usuário (filtrar a partir do código do usuário e do código de peso).

SELECT * FROM T_HISTORICO_PESO
WHERE ID_PESO = 3 AND ID_USUARIO = 2

-- Consultar todos os dados de todos os registros de alimentos ingeridos de um determinado usuário, ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código).

SELECT * FROM T_ALIMENTOS 
WHERE ID_USUARIO = 2
ORDER BY ID_ALIMENTO DESC

-- Consultar todos os dados de um único registro de alimento ingerido de um determinado usuário (filtrar a partir do código do usuário e do código de alimento).

SELECT * FROM T_ALIMENTOS
WHERE ID_ALIMENTO = 1 AND ID_USUARIO = 2

-- Consultar os dados básicos de um determinado usuário, o último peso registrado e a última pressão arterial registrada (filtrar a partir do código de usuário – consulta necessária para o dashboard. Dica: veja consulta com junções).
-- faltam dados da pressao arterial

SELECT * FROM T_USUARIO
INNER JOIN T_HISTORICO_PESO 
ON T_HISTORICO_PESO.ID_USUARIO = T_USUARIO.ID_USUARIO

 -- Consultar todos os dados de todos os registros de pressão arterial de um determinado usuário, ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código). 

SELECT P_ID, ID_USUARIO, P_ARTERIAL, P_ARTERIAL_POR,P_DATA_HORA
    FROM PRES_USUARIO
    WHERE ID_USUARIO = 1;
    ORDER BY P_DATA_HORA(DESC)


-- Consultar todos os dados de um único registro de pressão arterial de um determinado usuário (filtrar a partir do código do usuário e do código de pressão).

SELECT ID_USUARIO, P_ID, P_ARTERIAL, P_ARTERIAL_POR, P_DATA_HORA
    FROM PRES_USUARIO
    WHERE ID_USUARIO = 1;
    WHERE P_ID = 1;

