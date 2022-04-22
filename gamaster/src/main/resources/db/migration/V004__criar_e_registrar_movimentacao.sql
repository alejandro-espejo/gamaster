create table tb_movimentacao (
	id bigint primary key auto_increment,
    data_movimentacao datetime,
    tipo_movimentacao int,
    valor decimal(19,2) null,
    conta_destino_id bigint null,
    conta_origem_id bigint null,
    foreign key (conta_destino_id) references tb_conta(codigo),
    foreign key (conta_origem_id) references tb_conta(codigo)
);
-- ENTRADA
insert into tb_movimentacao (data_movimentacao, tipo_movimentacao, valor, conta_destino_id) values (utc_timestamp, 1, 100, 1);
insert into tb_movimentacao (data_movimentacao, tipo_movimentacao, valor, conta_destino_id) values (utc_timestamp, 1, 200, 2);
insert into tb_movimentacao (data_movimentacao, tipo_movimentacao, valor, conta_destino_id) values (utc_timestamp, 1, 300, 3);
-- TRANSFERENCIA
insert into tb_movimentacao (data_movimentacao, tipo_movimentacao, valor, conta_destino_id, conta_origem_id) values (utc_timestamp, 3, 20, 1, 2);
insert into tb_movimentacao (data_movimentacao, tipo_movimentacao, valor, conta_destino_id, conta_origem_id) values (utc_timestamp, 3, 230, 1, 3);
insert into tb_movimentacao (data_movimentacao, tipo_movimentacao, valor, conta_destino_id, conta_origem_id) values (utc_timestamp, 3, 100, 1, 2);
insert into tb_movimentacao (data_movimentacao, tipo_movimentacao, valor, conta_destino_id, conta_origem_id) values (utc_timestamp, 3, 70, 2, 3);
-- SAIDA
insert into tb_movimentacao (data_movimentacao, tipo_movimentacao, valor, conta_origem_id) values (utc_timestamp, 2, 450, 1);
insert into tb_movimentacao (data_movimentacao, tipo_movimentacao, valor, conta_origem_id) values (utc_timestamp, 2, 150, 2);