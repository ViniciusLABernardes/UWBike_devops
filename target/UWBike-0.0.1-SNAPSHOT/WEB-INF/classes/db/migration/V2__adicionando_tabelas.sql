CREATE SEQUENCE tb_funcionario_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE tb_moto_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE tb_ancora_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE tb_patio_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE tb_moto_patio_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE tb_funcionario (
                                id_funcionario NUMBER(10,0) NOT NULL,
                                nome_func VARCHAR2(150 CHAR) NOT NULL,
                                cpf VARCHAR2(30 CHAR) NOT NULL,
                                salario NUMBER(8,2) NOT NULL,
                                PRIMARY KEY (id_funcionario)
);

CREATE TABLE tb_login (
                          id_funcionario NUMBER(10,0) NOT NULL,
                          login VARCHAR2(50 CHAR) NOT NULL,
                          senha VARCHAR2(90 CHAR) NOT NULL,
                          PRIMARY KEY (id_funcionario)
);

CREATE TABLE tb_moto (
                         id_moto NUMBER(19,0) NOT NULL,
                         modelo VARCHAR2(100 CHAR) NOT NULL,
                         placa VARCHAR2(10 CHAR) NOT NULL,
                         chassi VARCHAR2(30 CHAR) NOT NULL,
                         PRIMARY KEY (id_moto)
);

CREATE TABLE tb_patio (
                          id_patio NUMBER(19,0) NOT NULL,
                          logradouro VARCHAR2(300 CHAR) NOT NULL,
                          numero NUMBER(10,0) NOT NULL,
                          complemento VARCHAR2(120 CHAR),
                          cep VARCHAR2(10 CHAR) NOT NULL,
                          cidade VARCHAR2(100 CHAR) NOT NULL,
                          uf VARCHAR2(6 CHAR) NOT NULL,
                          pais VARCHAR2(100 CHAR) NOT NULL,
                          lotacao_max NUMBER(10,2) NOT NULL,
                          PRIMARY KEY (id_patio)
);

CREATE TABLE tb_moto_patio (
                               id NUMBER (19,0) NOT NULL,
                               id_moto NUMBER(19,0) NOT NULL,
                               id_patio NUMBER(19,0) NOT NULL,
                               data_hora_entrada TIMESTAMP WITH LOCAL TIME ZONE NOT NULL,
                               data_hora_saida TIMESTAMP WITH LOCAL TIME ZONE,
                               PRIMARY KEY (id)
);

CREATE TABLE tb_ancora (
                           id NUMBER(19,0) NOT NULL,
                           posicao_x FLOAT(53),
                           posicao_y FLOAT(53),
                           id_patio NUMBER(19,0),
                           PRIMARY KEY (id)
);

ALTER TABLE tb_ancora ADD CONSTRAINT fk_ancora_patio FOREIGN KEY (id_patio) REFERENCES tb_patio ON DELETE CASCADE;
ALTER TABLE tb_login ADD CONSTRAINT fk_funcionario_login FOREIGN KEY (id_funcionario) REFERENCES tb_funcionario ON DELETE CASCADE;
ALTER TABLE tb_moto_patio ADD CONSTRAINT fk_motopatio_moto FOREIGN KEY (id_moto) REFERENCES tb_moto ON DELETE CASCADE;
ALTER TABLE tb_moto_patio ADD CONSTRAINT fk_motopatio_patio FOREIGN KEY (id_patio) REFERENCES tb_patio ON DELETE CASCADE;

CREATE OR REPLACE TRIGGER trg_funcionario_id
    BEFORE INSERT ON tb_funcionario
    FOR EACH ROW
BEGIN
    :NEW.id_funcionario := tb_funcionario_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER trg_moto_id
    BEFORE INSERT ON tb_moto
    FOR EACH ROW
BEGIN
    :NEW.id_moto := tb_moto_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER trg_patio_id
    BEFORE INSERT ON tb_patio
    FOR EACH ROW
BEGIN
    :NEW.id_patio := tb_patio_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER trg_ancora_id
    BEFORE INSERT ON tb_ancora
    FOR EACH ROW
BEGIN
    :NEW.id := tb_ancora_seq.NEXTVAL;
END;
/
CREATE OR REPLACE TRIGGER trg_moto_patio_id
    BEFORE INSERT ON tb_moto_patio
    FOR EACH ROW
BEGIN
    :NEW.id := tb_moto_patio_seq.NEXTVAL;
END;