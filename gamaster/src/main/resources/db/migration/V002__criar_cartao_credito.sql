CREATE TABLE tb_cartao (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    numero VARCHAR(20) NOT NULL,
    cod_seguranca VARCHAR(3) NOT NULL,
    bandeira VARCHAR(20) NOT NULL,
    portador VARCHAR(50) NOT NULL,
    limite DECIMAL(10,2) NOT NULL,
    limite_disponivel DECIMAL(10,2)    
) ENGINE=InnoDB DEFAULT CHARSET=utf8;