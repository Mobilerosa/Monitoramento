-- Criação da sequência para a tabela de usuários
CREATE SEQUENCE SEQ_USUARIOS
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Criação da tabela tbl_usuarios
CREATE TABLE tbl_usuarios (
    id NUMBER(10) DEFAULT SEQ_USUARIOS.NEXTVAL NOT NULL,
    nome VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) NOT NULL,
    senha VARCHAR2(100) NOT NULL,
    PRIMARY KEY (id)
);
