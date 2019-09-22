create database catdog;

use catdog;

CREATE TABLE fornecedor (
  Id int NOT NULL auto_increment,
  Nome varchar(150) NOT NULL,
  RazaoSocial varchar(100) DEFAULT NULL,
  Documento varchar(14) NOT NULL,
  Ativo bit(1) NOT NULL,
  Cep varchar(8) NOT NULL,
    DataHoraCriacao datetime NOT NULL default now(),
  PRIMARY KEY (Id)
  );

  CREATE TABLE categoria (
  Id int NOT NULL auto_increment,
  Nome varchar(50) NOT NULL,
  DataHoraCriacao datetime NOT NULL default now(),
  PRIMARY KEY (Id)
  );
  
  CREATE TABLE raca(
  Id int NOT NULL auto_increment,
  Nome varchar (100) NOT NULL,
  DataHoraCriacao datetime NOT NULL default now(),
  PRIMARY KEY (Id)
  );
  
  CREATE TABLE produto (
  Id int NOT NULL auto_increment,
  Nome varchar(100) NOT NULL,
  Descricao varchar(100) NOT NULL,
  Especificacao varchar(300) NOT NULL,
  PrecoCompra decimal(18,2) NOT NULL,
  PrecoVenda decimal(18,2) NOT NULL,
  Quantidade int(11) NOT NULL,
  Ativo bit(1) NOT NULL,
  IdRaca int not null,
  IdCategoria int NOT NULL,
  IdFornecedor int NOT NULL,
  TipoAnimal int,
  DataHoraCriacao datetime NOT NULL default now(),
  PRIMARY KEY (Id),
  KEY IX_Produto_IdCategoria (IdCategoria),
  KEY IX_Produto_IdFornecedor (IdFornecedor),
  KEY IX_Produto_IdRaca (IdRaca),
  CONSTRAINT FK_Produto_Categoria_IdCategoria FOREIGN KEY (IdCategoria) REFERENCES categoria (Id) ON DELETE RESTRICT,
  CONSTRAINT FK_Produto_Fornecedor_IdFornecedor FOREIGN KEY (IdFornecedor) REFERENCES fornecedor (Id) ON DELETE RESTRICT,
  CONSTRAINT FK_Produto_Raca_IdRaca FOREIGN KEY (IdRaca) REFERENCES raca (Id) ON DELETE RESTRICT
  );
  
  CREATE TABLE imagem (
  Id int  NOT NULL auto_increment,
  IdProduto int NOT NULL,
  Nome varchar(150) NOT NULL,
  Caminho varchar(20) NOT NULL,
  Tipo varchar(100) DEFAULT NULL,
  DataHoraCriacao datetime NOT NULL default now(),
  PRIMARY KEY (Id),
  KEY IX_Imagem_IdProduto (IdProduto),
  CONSTRAINT FK_Imagem_Produto_IdProduto FOREIGN KEY (IdProduto) REFERENCES 
  produto (Id) ON DELETE RESTRICT
  );
  
create table usuario(
 Id int  NOT NULL auto_increment primary key,
 Nome varchar(80) not null,
 Cpf varchar(11) not null unique,
 Email varchar(80) not null unique,
 DataNasc datetime not null,
 Login varchar(20) not null,
 Permissao int not null,
 Senha varchar(16) not null,
 DataHoraCriacao datetime NOT NULL default now()
);

create table cliente(
 Id int  NOT NULL auto_increment primary key,
 Nome varchar(80) not null,
 Cpf varchar(11) not null unique,
 Email varchar(80) not null unique,
 DataNasc datetime not null,
 Login varchar(20) not null,
 Permissao int not null,
 Senha varchar(16) not null,
 Cep varchar(8),
 DataHoraCriacao datetime NOT NULL default now()
)