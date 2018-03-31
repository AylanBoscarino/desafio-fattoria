# desafio-fattoria
Código do sistema com CRUD de produtos solitiado 


Abaixo o script da tabela MySQL usada no exercício.

CREATE DATABASE entrevista;

USE entrevista;
CREATE TABLE produto (

id INT(11) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(255),
preco DECIMAL(19,4),
quantidade INT(11),
data_cadastro DATE
);
