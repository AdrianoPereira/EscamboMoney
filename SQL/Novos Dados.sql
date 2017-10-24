INSERT INTO categoria
	(nome)
	VALUES('Informática');
	
INSERT INTO categoria
	(nome)
	VALUES('Papelaria');

INSERT INTO tipo
	(nome)
	VALUES('Administrador');
	
INSERT INTO tipo
	(nome)
	VALUES('Usuario');

INSERT INTO produto
	(nome, descricao, categoria, preco)
	VALUES('Notebook', 'Notebook game i7 Inspirion', 1, 6320.42);

INSERT INTO produto
	(nome, descricao, categoria, preco)
	VALUES('Agenda Pequena', '200 flohas', 2, 25.50);

INSERT INTO usuario
	(nome, sobrenome, email, senha, tipo)
	VALUES('admin', 'root', 'admin@root', '123', 1);