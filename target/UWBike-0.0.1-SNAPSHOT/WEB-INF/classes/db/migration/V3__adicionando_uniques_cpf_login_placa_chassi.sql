ALTER TABLE TB_FUNCIONARIO
    ADD CONSTRAINT uk_tb_funcionario_cpf UNIQUE (cpf);

ALTER TABLE TB_MOTO
    ADD CONSTRAINT uk_tb_moto_placa UNIQUE (placa);

ALTER TABLE TB_LOGIN
    ADD CONSTRAINT uk_tb_login_login UNIQUE (login);

ALTER TABLE TB_MOTO
    ADD CONSTRAINT uk_tb_moto_chassi UNIQUE(chassi);