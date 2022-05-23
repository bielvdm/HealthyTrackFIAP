--CRIAR TABELAS
DROP TABLE T_ATIVIDADE_FISICA PURGE;

CREATE TABLE T_USUARIO (
ID_USUARIO          VARCHAR(20) NOT NULL, 
NOME_USUARIO        VARCHAR(70) NOT NULL,
EMAIL_USUARIO       VARCHAR(90) NOT NULL,
SENHA_USUARIO		VARCHAR(50) NOT NULL,
NUMERO_USUARIO		LONG NOT NULL,
ALTURA_USUARIO		FLOAT,
CONSTRAINT PK_USUARIO PRIMARY KEY (ID_USUARIO)
);

CREATE TABLE T_HISTORICO_PESO (
ID_HIST_PESO    VARCHAR(20) CONSTRAINT PK_ID_HIST_PESO PRIMARY KEY,
DATA_LISTA      DATE NOT NULL,
PESO_LISTA		FLOAT NOT NULL,
ID_USUARIO		VARCHAR(20) REFERENCES T_USUARIO (ID_USUARIO)
);

CREATE TABLE T_INTENSIDADE_ATIVIDADE (
ID_INTESIDADE          VARCHAR(20) NOT NULL, 
NOME_INTENSIDADE       VARCHAR(50) NOT NULL,
CONSTRAINT PK_INTENSIDADE PRIMARY KEY (ID_INTESIDADE)
);

CREATE TABLE T_ATIVIDADE_FISICA (
ID_ATIVIDADE_FISICA    VARCHAR(20) CONSTRAINT T_ATIVIDADE_FISICA PRIMARY KEY,
ID_INTESIDADE		VARCHAR(20) REFERENCES T_INTENSIDADE_ATIVIDADE (ID_INTESIDADE),
ID_USUARIO		    VARCHAR(20) REFERENCES T_USUARIO (ID_USUARIO),
NOME_ATIVIDADE      VARCHAR(50) NOT NULL,
TEMPO_ATIVIDADE		FLOAT NOT NULL,
DATA_ATIVIDADE      DATE NOT NULL
);

CREATE TABLE T_ALIMENTOS (
ID_USUARIO		    VARCHAR(20) REFERENCES T_USUARIO (ID_USUARIO),
NOME_ALIMENTOS      VARCHAR(80) NOT NULL,
QNT_ALIMENTOS	    FLOAT NOT NULL
);

CREATE TABLE T_PRES_USUARIO(
P_ID                VARCHAR(20) NOT NULL,
P_ARTERIAL          VARCHAR(10) NOT NULL,
P_DATA_HORA         DATE NOT NULL,
CONSTRAINT PK_P_ID PRIMARY KEY (P_ID),
ID_USUARIO		    VARCHAR(20) REFERENCES T_USUARIO (ID_USUARIO)
);

-- INSERT (CADASTRAR DADOS)

INSERT INTO T_USUARIO (ID_USUARIO, NOME_USUARIO, EMAIL_USUARIO, SENHA_USUARIO, NUMERO_USUARIO, ALTURA_USUARIO) 
    VALUES  (2, 'CARLOS ALBERTO', 'CARLOSALBE@GMAIL.COM', 'CARLOS123', '1654321', '1,78');


INSERT INTO T_HISTORICO_PESO (ID_HIST_PESO, DATA_LISTA, PESO_LISTA, ID_USUARIO)
    VALUES  (6,
        TO_DATE('30/05/2022', 'DD/MM/YYYY'),
        '68,6', 1);
        
INSERT INTO T_PRES_USUARIO (P_ID, P_ARTERIAL, P_DATA_HORA, ID_USUARIO)
    VALUES (3,'12,0/8,0',
        TO_DATE('12/05/2022 17:30', 'DD/MM/YYYY HH24:MI'),1);
        
INSERT INTO T_INTENSIDADE_ATIVIDADE (ID_INTESIDADE, NOME_INTENSIDADE)
    VALUES (1,'PESADO');
    
INSERT INTO T_ATIVIDADE_FISICA (ID_ATIVIDADE_FISICA, ID_INTESIDADE, ID_USUARIO, NOME_ATIVIDADE, TEMPO_ATIVIDADE, DATA_ATIVIDADE)
    VALUES (1, 1, 1, 'BARRA FIXA', '15,5', 
    TO_DATE('12/05/2022', 'DD/MM/YYYY')
    );
  

-- UPDATE (ATUALIZAR DADOS)

UPDATE T_USUARIO
    SET NOME_USUARIO = 'RODRIGO MARTINS',
        EMAIL_USUARIO = 'RODRIGOM2@GMAIL.COM',
        SENHA_USUARIO = 'ROGER123',
        NUMERO_USUARIO = '11923456789',
        ALTURA_USUARIO = '1,70'
    WHERE ID_USUARIO = 1;

UPDATE T_HISTORICO_PESO
    SET DATA_LISTA = TO_DATE('15/05/2022', 'DD/MM/YYYY'),
        PESO_LISTA = '70,5'

UPDATE T_PRES_USUARIO
    SET P_ARTERIAL = '15.5/10.5',
        ID_USUARIO = '1'
        

UPDATE  T_ATIVIDADE_FISICA
    SET ID_INTESIDADE = 1,
        ID_USUARIO	 = 1,
        NOME_ATIVIDADE = 'CORRIDA LEVE',
        TEMPO_ATIVIDADE = '25,0',
        DATA_ATIVIDADE = TO_DATE('18/05/2022', 'DD/MM/YYYY')
        
        

-- SELECT (CONSULTAR DADOS)

SELECT NOME_USUARIO, EMAIL_USUARIO, SENHA_USUARIO, NUMERO_USUARIO, ALTURA_USUARIO 
   FROM T_USUARIO 
   WHERE ID_USUARIO = 1;

SELECT DATA_LISTA, PESO_LISTA
    FROM T_HISTORICO_PESO
    WHERE ID_USUARIO = 1
    ORDER BY DATA_LISTA DESC;

    
SELECT ID_HIST_PESO, ID_USUARIO, DATA_LISTA, PESO_LISTA
    FROM T_HISTORICO_PESO
    WHERE ID_HIST_PESO = 1;
    
SELECT P_ID, ID_USUARIO, P_ARTERIAL,P_DATA_HORA
    FROM T_PRES_USUARIO
    WHERE ID_USUARIO = 1
    ORDER BY P_DATA_HORA DESC;

SELECT ID_USUARIO, P_ID, P_ARTERIAL, P_DATA_HORA
    FROM T_PRES_USUARIO
    WHERE ID_USUARIO = 1 AND P_ID = 1;

SELECT NOME_ATIVIDADE, TEMPO_ATIVIDADE, DATA_ATIVIDADE, ID_INTESIDADE
    FROM T_ATIVIDADE_FISICA
    WHERE ID_USUARIO = 1
    ORDER BY DATA_ATIVIDADE DESC;

SELECT NOME_ATIVIDADE, TEMPO_ATIVIDADE, ID_INTESIDADE, DATA_ATIVIDADE
    FROM T_ATIVIDADE_FISICA
    WHERE ID_USUARIO = 1 AND ID_INTESIDADE = 1;
    
