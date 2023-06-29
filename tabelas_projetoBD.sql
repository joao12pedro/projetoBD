CREATE DATABASE cap2

CREATE TABLE pessoa(
	idpessoa INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50),
	e_mail VARCHAR(50)
);


CREATE TABLE produto(
	idCarro INT PRIMARY KEY AUTO_INCREMENT,
	numeroChassi CHAR(10),
	placa CHAR(7),
	modelo VARCHAR(50),
	nome VARCHAR(50),
	valor FLOAT 
	
);