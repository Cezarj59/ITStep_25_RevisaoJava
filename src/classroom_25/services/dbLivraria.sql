CREATE TABLE genero(
	id int PRIMARY KEY AUTO_INCREMENT,
    nome varchar(20) NOT NULL   
);

CREATE TABLE livro(
	id int PRIMARY KEY AUTO_INCREMENT,
    titulo varchar(20) NOT NULL   ,
    idGenero int NOT NULL,
    autor varchar(100),
    preco double DEFAULT 0,
    CONSTRAINT FK_Livro_Genero
    FOREIGN KEY livro(idGenero) REFERENCES genero(id)
);

USE livrariajava;
CREATE TABLE cliente (
     id int PRIMARY KEY AUTO_INCREMENT,
     nome varchar(30) NOT NULL,
     cpf varchar(14) DEFAULT "000.000.000-00",
     telefone varchar(14) DEFAULT "(xx)00000-0000"
);