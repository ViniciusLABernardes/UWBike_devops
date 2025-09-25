
create table tb_ancora (
                           id bigint identity not null,
                           posicao_x float(53),
                           posicao_y float(53),
                           id_patio bigint,
                           primary key (id)
)
    
create table tb_funcionario (
                                id_funcionario bigint identity not null,
                                cargo varchar(255) not null,
                                cpf varchar(30) not null,
                                nome_func varchar(150) not null,
                                salario float(53) not null,
                                primary key (id_funcionario)
)
    
create table tb_login (
                          id_funcionario bigint not null,
                          login varchar(50) not null,
                          senha varchar(180) not null,
                          primary key (id_funcionario)
)
    
create table tb_moto (
                         id_moto bigint identity not null,
                         chassi varchar(30) not null,
                         modelo varchar(100) not null,
                         placa varchar(10) not null,
                         primary key (id_moto)
)
    
create table tb_moto_patio (
                               id bigint identity not null,
                               data_hora_entrada datetime2(6) not null,
                               data_hora_saida datetime2(6),
                               id_moto bigint not null,
                               id_patio bigint not null,
                               primary key (id)
)
    
create table tb_patio (
                          id_patio bigint identity not null,
                          cep varchar(255) not null,
                          cidade varchar(100) not null,
                          complemento varchar(255),
                          logradouro varchar(450) not null,
                          lotacao_max int not null,
                          numero int not null,
                          pais varchar(100) not null,
                          uf varchar(6) not null,
                          primary key (id_patio)
)
    
create table tb_patio_funcionario (
                                      id_funcionario bigint not null,
                                      id_patio bigint not null
)
    
alter table tb_funcionario
    drop constraint if exists UKh483q8xwbxkhk56ceeww2pvhw

alter table tb_funcionario
    add constraint UKh483q8xwbxkhk56ceeww2pvhw unique (cpf)
    
alter table tb_login
    drop constraint if exists UK1txxhgxk8k2n1eu9issoafdof

alter table tb_login
    add constraint UK1txxhgxk8k2n1eu9issoafdof unique (login)
    
alter table tb_moto
    drop constraint if exists UKcp56ooah14ms8kns9lmgwuxyv

alter table tb_moto
    add constraint UKcp56ooah14ms8kns9lmgwuxyv unique (chassi)
    
alter table tb_moto
    drop constraint if exists UK2mlv0ilma7tarj4nuslqhl752

alter table tb_moto
    add constraint UK2mlv0ilma7tarj4nuslqhl752 unique (placa)
    
alter table tb_ancora
    add constraint FKj9f4cicxho94khaoeiqagy5v3
        foreign key (id_patio)
            references tb_patio
    
alter table tb_login
    add constraint FK44vs7f74khoevqtubjj5iqcru
        foreign key (id_funcionario)
            references tb_funcionario
    
alter table tb_moto_patio
    add constraint FKrhjugtlekx6wtbdfgvo4i9pgi
        foreign key (id_moto)
            references tb_moto
 
alter table tb_moto_patio
    add constraint FKivt4tdtirrks9gai5suy1ls4i
        foreign key (id_patio)
            references tb_patio

alter table tb_patio_funcionario
    add constraint FKn46uky8ds8t3ncqwyvq8702w9
        foreign key (id_patio)
            references tb_patio
    
alter table tb_patio_funcionario
    add constraint FKf64x2417bas6801f18beblvhv
        foreign key (id_funcionario)
            references tb_funcionario


INSERT INTO TB_FUNCIONARIO (nome_func, cpf, salario,cargo)
VALUES ('Garibaldo', '12345678910', 2342.90,'Gerente');
INSERT INTO TB_FUNCIONARIO (nome_func, cpf, salario,cargo)
VALUES ('Armando', '01987654321', 3192.00,'Auxiliar de Pátio');
INSERT INTO TB_LOGIN (id_funcionario, login, senha) VALUES (1, 'garibaldo.torres', '$2a$10$Lw8SGo.eLeIEGYcGlLGazubq3vuL/irmEpTzcV1uVbfUn.lSnqbsu');
INSERT INTO TB_LOGIN (id_funcionario, login, senha) VALUES (2, 'armando.pontes', '$2a$10$DP/soKIfWMW6yjCZeQwn8eLgN3mkJY9iNM39bYkCuTMPvI.Ca7tvG');
INSERT INTO TB_PATIO(logradouro,numero,cep,cidade,uf,pais,lotacao_max)
values('Avenida Professor Celestino Bourroul',363,'02710-000','São Paulo','SP','Brasil',150);
INSERT INTO TB_PATIO_FUNCIONARIO(id_patio,id_funcionario) values (1,1);
INSERT INTO TB_PATIO_FUNCIONARIO(id_patio,id_funcionario) values (1,2);