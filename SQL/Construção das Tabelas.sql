CREATE DATABASE escambomoney;

CREATE TABLE categoria(
	id serial,
	nome varchar(100) NOT NULL,

	CONSTRAINT pk_categoria PRIMARY KEY(id)
);

CREATE TABLE tipo(
	id serial,
	descricao varchar(100),

	CONSTRAINT pk_tipo PRIMARY KEY(id)
);

CREATE TABLE usuario(
	id serial,
	nome varchar(100) NOT NULL,
	sobrenome varchar(100) NOT NULL,
	email varchar(50) NOT NULL,
	senha varchar(100) NOT NULL,
	tipo int NOT NULL,
	
	CONSTRAINT pk_usuario PRIMARY KEY(id),
	CONSTRAINT fk_tipo_usuario FOREIGN KEY(tipo)
		REFERENCES tipo(id)
);

CREATE TABLE produto(
	id serial,
	nome varchar(100) NOT NULL,
	preco float NOT NULL,
	categoria int NOT NULL,

	CONSTRAINT pk_produto PRIMARY KEY(id),
	CONSTRAINT fk_cateoria_produto FOREIGN KEY(categoria)
		REFERENCES categoria(id)
);

CREATE TABLE carrinho(
	id serial,
	produtos int,
	usuario int,
	
	CONSTRAINT pk_carrinho PRIMARY KEY(id),
	CONSTRAINT fk_produto_carrinho FOREIGN KEY(produtos)
		REFERENCES produto(id),
	CONSTRAINT fk_usuario_carrinh FOREIGN KEY(usuario)
		REFERENCES usuario(id)
);