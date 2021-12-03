create database gamestore;
use gamestore;

CREATE TABLE filiais 
(
  idfiliais int(11) NOT NULL AUTO_INCREMENT,
  cidade varchar(45) DEFAULT NULL,
  idGerente int(11) DEFAULT NULL,
  PRIMARY KEY (idfiliais)
  );
  
  CREATE TABLE usuario (
  idUsuario int(11) NOT NULL AUTO_INCREMENT,
  idFilial int(11) NOT NULL,
  cpf varchar(14) NOT NULL,
  nome varchar(70) NOT NULL,
  nascimento date NOT NULL,
  telefone varchar(20) NOT NULL,
  email varchar(60) NOT NULL,
  sexo char(1) NOT NULL,
  rg varchar(12) NOT NULL,
  endereco varchar(150) NOT NULL,
  senha varchar(60) NOT NULL,
  tipoacesso int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (idUsuario),
  UNIQUE KEY cpf_UNIQUE (cpf),
  CONSTRAINT idFilialUsuario FOREIGN KEY (idFilial) REFERENCES filiais (idfiliais)
);

CREATE TABLE produto
(
    idProduto int(11) NOT NULL AUTO_INCREMENT,
    nome varchar(60) NOT NULL,
    idFilial int(11) NOT NULL,
    preco double NOT NULL,
    fabricante varchar(60) DEFAULT NULL,
    estoque int(11) NOT NULL DEFAULT 0,
    modelo varchar(60) DEFAULT NULL,
    codigodebarras varchar(45) DEFAULT NULL,
    PRIMARY KEY (idProduto)
);
  
  CREATE TABLE pedido
 (
  idPedido int(11) NOT NULL AUTO_INCREMENT,
  idCliente int(11) NOT NULL,
  idFuncionario int(11) NOT NULL,
  idFilial int(11) NOT NULL,
  data date DEFAULT NULL,
  precoVenda double NOT NULL,
  PRIMARY KEY (idPedido),
  CONSTRAINT idCliente FOREIGN KEY (idCliente) REFERENCES usuario (idusuario),
  CONSTRAINT idFilial FOREIGN KEY (idFilial) REFERENCES filiais (idfiliais),
  CONSTRAINT idFuncionario FOREIGN KEY (idFuncionario) REFERENCES usuario (idusuario)
);

CREATE TABLE detalhes_pedido 
(
  idPedido int(11) NOT NULL AUTO_INCREMENT,
  idProduto int(11) DEFAULT NULL,
  quantidade int(11) DEFAULT '1',
  PRIMARY KEY (idPedido),
  KEY idProduto_idx (idProduto),
  CONSTRAINT idProduto FOREIGN KEY (idProduto) REFERENCES produto (idproduto)
  );
  
  CREATE TABLE tipopagamento 
(
  id int(11) NOT NULL AUTO_INCREMENT,
  descricao varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);

insert into filiais (cidade, idGerente) values 
											("São Paulo", 1),
											("Rio de Janeiro", 2),
                                            ("Minas Geraris", 3),
                                            ("Curitiba", 4);

insert into produto (nome, fabricante, estoque, modelo, codigodebarras, preco, idFilial) values
                         ("PLACA MÃE ASUS PRIME H510M-E, INTEL LGA 1200, mATX, DDR4, 11 GER","Asus", 30, "hardware","Placa Mae", '680.00', 1),  /* Placa Mãe */
                         ("PLACA MAE ASUS ROG STRIX Z590-E GAMING INTEL LGA 1200, ATX, DDR4, 11 GER","Asus", 30, "hardware","Placa Mae", '4052.53', 1),
                         ("PLACA MAE GIGABYTE B360 AORUS GAMING, LGA1151","GigaByte", 28, "hardware", "Placa Mae", '652.00', 1),
						 ("PLACA MAE GIGABYTE Z390 LGA1151 ATX","GigaByte", 35, "hardware", "Placa Mae", '1080.00', 1),
						 ("PLACA MÃE ASROCK B450M STEEL LEGEND","asRock", 60, "hardware","Placa Mae", '779.00', 1),
                         ("PLACA MÃE ASROCK AM4 A320M-HD","asRock", 18, "hardware","asRock", '479.90', 1),      /* **********************Ajustar ***************************** */
                         ("PROCESSADOR AMD RYZEN 5 5600G, 3.9GHZ (4.4GHZ TURBO)","AMD", 30, "hardware","Processadores", '1799.90', 1), /* Processadores */
                         ("PROCESSADOR AMD RYZEN 7 5800X 3.8GHZ (TURBO 4.7GHZ)","AMD", 40, "hardware","Processadores", '2699.90', 1),
                         ("PROCESSADOR INTEL CORE I7 11700KF 3.6 GHZ (4.9GHZ TURBO)","Intel", 28, "hardware","Processadores", '2750.00', 1),
						 ("PROCESSADOR INTEL CORE I5 11600K, 3.9GHZ (4.9GHZ TURBO)","Intel", 35, "hardware","Processadores", '1499.00', 1),
						 ("PROCESSADOR AMD ATHLON 3000G 3.5GHZ, 2-CORE, 4-THREAD","AMD", 60, "hardware","Processadores", '350.00', 1),
                         ("PROCESSADOR INTEL CORE I9 9900K 3.60GHZ (5.0GHZ TURBO)","Intel", 24, "hardware","Processadores", '2499.00', 1),  
                         ("MEMÓRIA XPG HUNTER, 8GB, 3200MHZ, DDR4, PRETO","XPG", 50, "hardware","Memoria Ram", '384.00', 1), /* Memoria Ram */
                         ("MEMORIA XPG SPECTRIX D60G RGB 8GB, 3000MHZ, DDR4, CL16, CINZA","XPG", 50, "hardware","Memoria Ram", '410.00', 1),
                         ("MEMÓRIA CORSAIR VENGEANCE LED RGB 3000MHZ DDR4","Corsair", 50, "hardware","Memoria Ram", '370.00', 1),
						 ("MEMÓRIA CORSAIR DOMINATOR PLATINUM, 8GB, 3000MHZ DDR4","Corsair", 50, "hardware","Memoria Ram", '340.00', 1),
						 ("MEMÓRIA HYPERX FURY, 8GB, 2666MHZ, 8GB, DDR4","HyperX", 50, "hardware","Memoria Ram", '400.00', 1),
                         ("MEMORIA KINGSTON HYPERX FURY BLACK 4GB DDR4 2400MHZ","HyperX", 50, "hardware","Memoria Ram", '230.00', 1);
