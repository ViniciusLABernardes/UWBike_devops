
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (1,'garibaldo.torres','armando123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (2,'armando.pontes','pontes123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (3,'giovanna.madeira','gm123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (4,'jonathan.carr','jonanthan123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (5,'ana.torres','torres123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (6,'miguel.chavo','chaves123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (7,'carlos.silva','carlos123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (8,'fernanda.alves','fernanda123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (9,'ricardo.moura','ricardo123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (10,'patricia.lima','patricia123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (11,'joao.souza','joao123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (12,'mariana.rocha','mariana123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (13,'rodrigo.pires','rodrigo123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (14,'beatriz.oliveira','beatriz123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (15,'felipe.costa','felipe123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (16,'camila.ramos','camila123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (17,'santiago.lopez','santiago123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (18,'valentina.morales','valentina123');
INSERT INTO TB_LOGIN(id_funcionario,login,senha) VALUES (19,'emilio.garcia','emilio123');


INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada)
VALUES (1, 1, 1, TIMESTAMP '2024-03-22 08:15:47.321');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada, data_hora_saida)
VALUES (2, 2, 5, TIMESTAMP '2024-09-10 19:42:03.875', TIMESTAMP '2024-09-12 13:42:03.875');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada)
VALUES (3, 2, 5, TIMESTAMP '2024-10-10 19:42:03.875');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada, data_hora_saida)
VALUES (4, 3, 2, TIMESTAMP '2025-01-05 13:07:29.045', TIMESTAMP '2025-01-06 08:27:39.045');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada)
VALUES (5, 4, 3, TIMESTAMP '2024-12-01 23:59:59.999');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada)
VALUES (6, 5, 3, TIMESTAMP '2024-07-18 05:30:11.210');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada, data_hora_saida)
VALUES (7, 6, 4, TIMESTAMP '2024-08-09 11:25:33.456', TIMESTAMP '2024-08-12 21:25:33.456');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada)
VALUES (8, 7, 2, TIMESTAMP '2025-02-27 16:44:12.789');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada)
VALUES (9, 8, 4, TIMESTAMP '2024-10-14 03:19:55.102');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada)
VALUES (10, 9, 2, TIMESTAMP '2024-11-05 22:08:01.670');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada, data_hora_saida)
VALUES (11, 10, 5, TIMESTAMP '2025-04-18 09:12:47.888', TIMESTAMP '2025-04-23 19:16:47.888');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada, data_hora_saida)
VALUES (12, 6, 2, TIMESTAMP '2024-08-13 13:45:33.456', TIMESTAMP '2024-08-16 11:25:33.456');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada, data_hora_saida)
VALUES (13, 6, 1, TIMESTAMP '2024-08-22 17:13:33.456', TIMESTAMP '2024-08-23 21:44:33.456');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada, data_hora_saida)
VALUES (14, 6, 3, TIMESTAMP '2024-08-26 08:23:33.456', TIMESTAMP '2024-08-30 23:54:33.456');
INSERT INTO TB_MOTO_PATIO(id, id_moto, id_patio, data_hora_entrada, data_hora_saida)
VALUES (15, 6, 1, TIMESTAMP '2024-09-02 13:30:33.456', TIMESTAMP '2024-09-07 10:48:33.456');


INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (1, 2, 2, 1);
INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (2, 18, 2, 1);
INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (3, 10, 18, 1);

INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (4, 2, 2, 2);
INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (5, 20, 2, 2);
INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (6, 11, 20, 2);

INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (7, 2, 2, 3);
INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (8, 19, 2, 3);
INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (9, 10, 19, 3);

INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (10, 2, 2, 4);
INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (11, 22, 2, 4);
INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (12, 12, 22, 4);

INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (13, 2, 2, 5);
INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (14, 23, 2, 5);
INSERT INTO tb_ancora(id, posicao_x, posicao_y, id_patio) VALUES (15, 12, 23, 5);