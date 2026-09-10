-- DROP DATABASE IF EXISTS loja_pet;
-- CREATE DATABASE loja_pet;
-- USE loja_pet;

-- create
CREATE TABLE MARCA (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL
);

CREATE TABLE CATEGORIA (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE PROMOCAO (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  valor FLOAT NOT NULL,
  data_inicio DATETIME NOT NULL,
  data_fim DATETIME,
  ativa BOOLEAN NOT NULL
);

CREATE TABLE ENDERECO_FORNECEDOR (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  cep char(8) NOT NULL,
  uf char(2) NOT NULL,
  cidade VARCHAR(50) NOT NULL,
  rua VARCHAR(50) NOT NULL,
  numero INT NOT NULL,
  complemento VARCHAR(255)
);

-- insert
INSERT INTO MARCA (nome)
VALUES ('Premier'),
       ('Royal Canin'),
       ('Golden'),
       ('Dog Chow'),
       ('Purina'),
       ('Whiskas'),
       ('Premier Pet'),
       ('Friskies'),
       ('Adaptil'),
       ('Pedigree');
       
INSERT INTO CATEGORIA (nome)
VALUES ('Alimentação e Ração'),
       ('Higiene e Beleza'),
       ('Brinquedos'),
       ('Camas, Casinhas e Transporte'),
       ('Comedouros e Bebedouros'),
       ('Saúde e Bem-estar'),
       ('Aves'),
       ('Roedores'),
       ('Cães'),
       ('Gatos');

INSERT INTO PROMOCAO (nome, valor,  data_inicio, data_fim, ativa)
VALUES ('quarta'),
       ('Royal Canin'),
       ('Golden'),
       ('Dog Chow'),
       ('Purina'),
       ('Whiskas'),
       ('Premier Pet'),
       ('Friskies'),
       ('Adaptil'),
       ('Pedigree');

INSERT INTO ENDERECO_FORNECEDOR (nome)
VALUES ('Premier'),
       ('Royal Canin'),
       ('Golden'),
       ('Dog Chow'),
       ('Purina'),
       ('Whiskas'),
       ('Premier Pet'),
       ('Friskies'),
       ('Adaptil'),
       ('Pedigree');

-- fetch 
SELECT * FROM MARCA;
SELECT * FROM CATEGORIA;
SELECT * FROM PROMOCAO;

