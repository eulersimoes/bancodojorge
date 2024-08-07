CREATE SEQUENCE CLIENTE_ID_SEQ;
CREATE SEQUENCE DOCUMENTO_CLIENTE_ID_SEQ;
CREATE SEQUENCE AGENCIA_ID_SEQ;
CREATE SEQUENCE CONTA_ID_SEQ;
CREATE SEQUENCE MOVIMENTACAO_CONTA_ID_SEQ;

CREATE TABLE CLIENTE (
CLIE_CD_CLIENTE integer NOT NULL DEFAULT nextval('CLIENTE_ID_SEQ'),
CLIE_NM_CLIENTE VARCHAR(50) NOT NULL,
CLIE_DS_ENDERECO VARCHAR(50) NOT NULL,
CLIE_DT_NASCIMENTO DATE,
CLIE_CD_CPF VARCHAR(15),
CONSTRAINT PK_CLIENTE PRIMARY KEY (CLIE_CD_CLIENTE)
);

CREATE TABLE DOCUMENTO_CLIENTE (
DOCL_CD_DOCUMENTO  integer NOT NULL DEFAULT nextval('DOCUMENTO_CLIENTE_ID_SEQ'),
DOCL_CD_CLIENTE integer NOT NULL,
DOCL_NM_DOCUMENTO varchar(50) NOT NULL,
DOCL_VL_DOCUMENTO VARCHAR(50) NOT NULL,
DOCL_DT_EMISSAO DATE,
DOCL_DT_VENCIMENTO DATE,
DOCL_FT_DOCUMENTO BYTEA,
CONSTRAINT PK_DOCUMENTO_CLIENTE PRIMARY KEY (DOCL_CD_DOCUMENTO),
CONSTRAINT UK_DOCUMENTO_CLIENTE UNIQUE (DOCL_NM_DOCUMENTO,DOCL_DT_EMISSAO),
CONSTRAINT FK_CLIENTE FOREIGN KEY (DOCL_CD_CLIENTE) REFERENCES CLIENTE(CLIE_CD_CLIENTE)
);

CREATE TABLE AGENCIA (
AGEN_CD_AGENCIA  integer NOT NULL DEFAULT nextval('AGENCIA_ID_SEQ'),
AGEN_NM_AGENCIA VARCHAR(50) NOT NULL,
AGEN_DS_ENDERECO VARCHAR(50) NOT NULL,
AGEN_UF_AGENCIA VARCHAR(2) NOT NULL,
CONSTRAINT PK_AGENCIA PRIMARY KEY (AGEN_CD_AGENCIA)
);

CREATE TABLE CONTA (
CONT_CD_CONTA  integer NOT NULL DEFAULT nextval('CONTA_ID_SEQ'),
CONT_CD_AGENCIA INTEGER NOT NULL,
CONT_CD_CLIENTE INTEGER NOT NULL,
CONT_DT_CRIACAO DATE NOT NULL,
CONSTRAINT PK_CONTA PRIMARY KEY (CONT_CD_CONTA),
CONSTRAINT FK_CONTA_CLIENTE FOREIGN KEY (CONT_CD_CLIENTE) REFERENCES CLIENTE(CLIE_CD_CLIENTE),
CONSTRAINT FK_CONTA_AGENCIA FOREIGN KEY (CONT_CD_AGENCIA) REFERENCES AGENCIA(AGEN_CD_AGENCIA)
);

CREATE TABLE MOVIMENTACAO_CONTA (
MOCO_CD_MOVIMENTACAO  integer NOT NULL DEFAULT nextval('MOVIMENTACAO_CONTA_ID_SEQ'),
MOCO_CD_CONTA  integer NOT NULL,
MOCO_VL_MOVIMENTACAO  NUMERIC (18,2) NOT NULL,
MOCO_DT_MOVIMENTACAO DATE NOT NULL,
MOCO_TP_MOVIMENTACAO VARCHAR(1) NOT NULL,
CONSTRAINT PK_MOVIMENTACAO_CONTA PRIMARY KEY (MOCO_CD_MOVIMENTACAO),
CONSTRAINT FK_MOVIMENTACAO_CONTA_CLIENTE FOREIGN KEY (MOCO_CD_CONTA) REFERENCES CONTA(CONT_CD_CONTA)
);

--INSERTS
insert into CLIENTE (CLIE_NM_CLIENTE,CLIE_DS_ENDERECO,CLIE_DT_NASCIMENTO) values ('JOAO JEAN','RUA 22 SALVADOR BA', '1990-01-01');
insert into CLIENTE (CLIE_NM_CLIENTE,CLIE_DS_ENDERECO,CLIE_DT_NASCIMENTO) values ('GUILHERME HERN','RUA 1 SALVADOR BA', '1990-01-01');
insert into CLIENTE (CLIE_NM_CLIENTE,CLIE_DS_ENDERECO,CLIE_DT_NASCIMENTO) values ('JOE VESTAPEN','RUA 2 RIO DE JANEIRO RJ', '1990-02-01');
insert into CLIENTE (CLIE_NM_CLIENTE,CLIE_DS_ENDERECO,CLIE_DT_NASCIMENTO) values ('MICHAEL XULISH','RUA 22 BELO HORIZONTE MG', '2002-02-01');
insert into CLIENTE (CLIE_NM_CLIENTE,CLIE_DS_ENDERECO,CLIE_DT_NASCIMENTO) values ('JIMY CRAFTER','RUA 3 BELO HORIZONTE MG', '2001-04-09');
insert into CLIENTE (CLIE_NM_CLIENTE,CLIE_DS_ENDERECO,CLIE_DT_NASCIMENTO) values ('JOSE DA MOTA','RUA 4 SAO PAULO SP', '1997-07-05');
insert into CLIENTE (CLIE_NM_CLIENTE,CLIE_DS_ENDERECO,CLIE_DT_NASCIMENTO) values ('HYRING HYUR','RUA 5 CURITIBA PR', '1990-07-08');

insert into agencia (AGEN_NM_AGENCIA,AGEN_DS_ENDERECO,AGEN_UF_AGENCIA) values ('CENTRO DE SALVADOR','RUA CENTRAL DE SALVADOR','BA');
insert into agencia (AGEN_NM_AGENCIA,AGEN_DS_ENDERECO,AGEN_UF_AGENCIA) values ('PORTO DE SALVADOR','RUA DO CAIS , SALVADOR','BA');
insert into agencia (AGEN_NM_AGENCIA,AGEN_DS_ENDERECO,AGEN_UF_AGENCIA) values ('AG DA ROCINHA','RUA PRINCIPAL, ROCINHA, RIO DE JANEIRO','RJ');
insert into agencia (AGEN_NM_AGENCIA,AGEN_DS_ENDERECO,AGEN_UF_AGENCIA) values ('JORGE','PRACINHA DA CIDADE, JORGE','MG');
insert into agencia (AGEN_NM_AGENCIA,AGEN_DS_ENDERECO,AGEN_UF_AGENCIA) values ('AGENCIA DA SAVASSI','SAVASSI, BELO HORIZONTE','MG');

insert into conta (CONT_CD_AGENCIA,CONT_CD_CLIENTE,CONT_DT_CRIACAO) values (1,1,'2023-12-14');
insert into conta (CONT_CD_AGENCIA,CONT_CD_CLIENTE,CONT_DT_CRIACAO) values (1,2,'2023-12-13');
insert into conta (CONT_CD_AGENCIA,CONT_CD_CLIENTE,CONT_DT_CRIACAO) values (2,4,'2023-05-14');
insert into conta (CONT_CD_AGENCIA,CONT_CD_CLIENTE,CONT_DT_CRIACAO) values (3,3,'2023-12-07');
insert into conta (CONT_CD_AGENCIA,CONT_CD_CLIENTE,CONT_DT_CRIACAO) values (4,5,'2023-05-14');
