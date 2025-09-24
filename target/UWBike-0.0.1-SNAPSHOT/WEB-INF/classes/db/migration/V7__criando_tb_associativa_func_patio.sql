CREATE TABLE tb_patio_funcionario (
                                      id_patio       INTEGER NOT NULL,
                                      id_funcionario INTEGER NOT NULL
);
ALTER TABLE tb_patio_funcionario
    ADD CONSTRAINT tb_patio_funcionario_id_funcionario_fk FOREIGN KEY ( id_funcionario )
        REFERENCES tb_funcionario ( id_funcionario ) ON DELETE CASCADE ;

ALTER TABLE tb_patio_funcionario
    ADD CONSTRAINT tb_patio_funcionario_id_patio_fk FOREIGN KEY ( id_patio )
        REFERENCES tb_patio ( id_patio ) ON DELETE CASCADE;