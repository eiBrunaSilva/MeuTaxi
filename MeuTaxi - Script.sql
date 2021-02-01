CREATE DATABASE integrador;
USE integrador;

CREATE TABLE proprietario ( 
id_proprietario BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
senha VARCHAR(150) NOT NULL,
rua VARCHAR(150) NOT NULL,
bairro VARCHAR(150) NOT NULL,
cidade VARCHAR(150) NOT NULL,
estado VARCHAR(150) NOT NULL,
telefone BIGINT NOT NULL UNIQUE,
login VARCHAR(150) NOT NULL UNIQUE,
cep LONG NOT NULL,
email VARCHAR(150) NOT NULL UNIQUE,
numero INT NOT NULL,
nome VARCHAR(150) NOT NULL,
PRIMARY KEY(id_proprietario));

CREATE TABLE motorista(
id_motorista BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
senha VARCHAR(150) NOT NULL,
rua VARCHAR(150) NOT NULL,
bairro VARCHAR(150) NOT NULL,
cidade VARCHAR(150) NOT NULL,
estado VARCHAR(150) NOT NULL,
telefone BIGINT NOT NULL UNIQUE,
login VARCHAR(150) NOT NULL UNIQUE,
cep LONG NOT NULL,
email VARCHAR(150) NOT NULL UNIQUE,
numero INT NOT NULL,
nome VARCHAR(150) NOT NULL,
id_proprietario BIGINT NOT NULL,
PRIMARY KEY(id_motorista),
FOREIGN KEY(id_proprietario) REFERENCES proprietario(id_proprietario) ON DELETE CASCADE);

CREATE TABLE veiculo(
id_veiculo BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
placa VARCHAR(150) NOT NULL UNIQUE,
marca VARCHAR(150) NOT NULL,
modelo VARCHAR(150) NOT NULL,
ano INT NOT NULL,
prefixo BIGINT NOT NULL UNIQUE,
id_proprietario BIGINT NOT NULL,
PRIMARY KEY(id_veiculo),
FOREIGN KEY(id_proprietario) REFERENCES proprietario(id_proprietario) ON DELETE CASCADE);

CREATE TABLE veiculo_motorista(
id_veiculo_motorista BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
id_veiculo BIGINT NOT NULL,
id_motorista BIGINT NOT NULL,
PRIMARY KEY(id_veiculo_motorista),
FOREIGN KEY(id_veiculo) REFERENCES veiculo(id_veiculo) ON DELETE CASCADE,
FOREIGN KEY(id_motorista) REFERENCES motorista(id_motorista) ON DELETE CASCADE);

CREATE TABLE diaria(
id_diaria BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
hora_inicial TIME NOT NULL,
hora_final TIME NOT NULL,
dia VARCHAR(150) NOT NULL,
comissao FLOAT NOT NULL,
km_inicial FLOAT NOT NULL,
km_final FLOAT NOT NULL,
preco_km FLOAT NOT NULL,
combustivel FLOAT NOT NULL,
id_proprietario BIGINT NOT NULL,
id_veiculo BIGINT NOT NULL,
id_motorista BIGINT NOT NULL,
PRIMARY KEY(id_diaria),
FOREIGN KEY(id_proprietario) REFERENCES proprietario(id_proprietario) ON DELETE CASCADE,
FOREIGN KEY(id_veiculo) REFERENCES veiculo(id_veiculo) ON DELETE CASCADE,
FOREIGN KEY(id_motorista) REFERENCES motorista(id_motorista) ON DELETE CASCADE); 

CREATE TABLE gasto(
id_gasto BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
descricao VARCHAR(150) NOT NULL,
valor FLOAT NOT NULL,
id_diaria BIGINT NOT NULL,
PRIMARY KEY(id_gasto),
FOREIGN KEY(id_diaria) REFERENCES diaria(id_diaria) ON DELETE CASCADE);

CREATE TABLE corrida(
id_corrida BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
hora_inicial TIME NOT NULL,
hora_final TIME NOT NULL,
preco FLOAT NOT NULL,
cartao BOOLEAN NOT NULL,
id_diaria BIGINT NOT NULL,
PRIMARY KEY(id_corrida),
FOREIGN KEY(id_diaria) REFERENCES diaria(id_diaria) ON DELETE CASCADE);
