ALTER TABLE TB_FUNCIONARIO ADD cargo VARCHAR2(50);

UPDATE TB_FUNCIONARIO SET cargo = 'Gerente'
WHERE id_funcionario IN (1, 3, 4, 5, 6);


UPDATE TB_FUNCIONARIO SET cargo = 'Mecanico'
WHERE id_funcionario IN (2, 8, 9, 10, 11);


UPDATE TB_FUNCIONARIO SET cargo = 'Auxiliar de Patio'
WHERE id_funcionario NOT IN (1, 2, 3, 4, 5, 6, 8, 9, 10, 11);