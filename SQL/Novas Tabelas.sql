CREATE TABLE tipo(
	id serial, 
	nome varchar(100),

	CONSTRAINT pk_tipo PRIMARY KEY(id)
);

CREATE TABLE usuario(
	id serial, 
	nome varchar(100),
	sobrenome varchar(100),
	email varchar(100),
	senha varchar(100),
	tipo integer,

	CONSTRAINT pk_usuario PRIMARY KEY(id),
	CONSTRAINT fk_tipo_usuario FOREIGN KEY(tipo)
		REFERENCES tipo(id)
);

CREATE TABLE categoria(
	id serial, 
	nome varchar(100),

	CONSTRAINT pk_categoria PRIMARY KEY(id)
);

CREATE TABLE produto(
	id serial, 
	nome varchar(100),
	descricao varchar(100),
	categoria integer,
	preco float,

	CONSTRAINT pk_produto PRIMARY KEY(id),
	CONSTRAINT fk_categoria_produto FOREIGN KEY(categoria)
		REFERENCES categoria(id)
);