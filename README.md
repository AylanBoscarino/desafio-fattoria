Um CRUD de produtos feito em Java 8  e JQuery.


Abaixo o script da tabela MySQL usada.

CREATE DATABASE entrevista;

USE entrevista;
CREATE TABLE produto (

id INT(11) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(255),
preco DECIMAL(19,4),
quantidade INT(11),
data_cadastro DATE
);
