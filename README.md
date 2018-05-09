A página feita em HTML e CSS puro e JQuery
A API em Maven, Java8 com banco de dados em Hibernate integrado ao MySQL


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
