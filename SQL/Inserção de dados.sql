INSERT INTO categoria (nome) VALUES('Informática');
INSERT INTO categoria (nome) VALUES('Papelaria');
INSERT INTO categoria (nome) VALUES('Eletrodoméstico');

INSERT INTO produto 
	(nome, preco, categoria)
	VALUES('Mouse Logitech', 32.50, 1)

INSERT INTO produto 
	(nome, preco, categoria)
	VALUES('Agenda Pequena', 25.30, 2)
	

INSERT INTO tipo (descricao) VALUES('administrador');

INSERT INTO usuario 
	(nome, sobrenome, email, senha, tipo)
	VALUES('Adriano', 'Almeida', 'adrianoalmeida.py@gmail.com', 'rpypk', 1);

