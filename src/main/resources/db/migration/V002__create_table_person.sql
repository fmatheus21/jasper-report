CREATE TABLE person (
  id int NOT NULL AUTO_INCREMENT,
  id_person_type int NOT NULL,
  name varchar(70) NOT NULL,
  document varchar(20) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  UNIQUE KEY document_UNIQUE (document),
  KEY fk_person_type_idx (id_person_type),
  CONSTRAINT fk_person_type FOREIGN KEY (id_person_type) REFERENCES person_type (id) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO person (id, id_person_type, name, document) VALUES(1, 1, Upper('Anderson Henrique Yuri Peixoto'), '18983429380');
INSERT INTO person (id, id_person_type, name, document) VALUES(2, 1, Upper('Sônia Isabelle Freitas'), '34911145005');
INSERT INTO person (id, id_person_type, name, document) VALUES(3, 1, Upper('Eloá Luana de Paula'), '84009284749');
INSERT INTO person (id, id_person_type, name, document) VALUES(4, 1, Upper('Isis Eduarda Fátima das Neves'), '73521853802');
INSERT INTO person (id, id_person_type, name, document) VALUES(5, 1, Upper('Miguel Diogo Farias'), '46317473404');
INSERT INTO person (id, id_person_type, name, document) VALUES(6, 1, Upper('Fernanda Clarice Caldeira'), '50999268007');
INSERT INTO person (id, id_person_type, name, document) VALUES(7, 1, Upper('Cauã Gustavo Silva'), '67194872137');
INSERT INTO person (id, id_person_type, name, document) VALUES(8, 1, Upper('Murilo Nicolas Breno Baptista'), '49570025093');
INSERT INTO person (id, id_person_type, name, document) VALUES(9, 1, Upper('Carolina Márcia Priscila Melo'), '25570340297');
INSERT INTO person (id, id_person_type, name, document) VALUES(10, 1, Upper('Enrico Luís Otávio Fogaça'), '81576856801');
INSERT INTO person (id, id_person_type, name, document) VALUES(11, 1, Upper('José Pietro Renan Costa'), '19115413403');
INSERT INTO person (id, id_person_type, name, document) VALUES(12, 1, Upper('Carlos Eduardo Igor Nunes'), '92380592330');
INSERT INTO person (id, id_person_type, name, document) VALUES(13, 1, Upper('Mário Erick Ferreira'), '72529277923');
INSERT INTO person (id, id_person_type, name, document) VALUES(14, 1, Upper('Tânia Helena Sara de Paula'), '92854347544');
INSERT INTO person (id, id_person_type, name, document) VALUES(15, 1, Upper('Raimunda Lúcia Oliveira'), '62254697960');
INSERT INTO person (id, id_person_type, name, document) VALUES(16, 1, Upper('Márcio Fernando Kauê Galvão'), '19084780396');
INSERT INTO person (id, id_person_type, name, document) VALUES(17, 1, Upper('Luan Otávio Assis'), '10767534000');
INSERT INTO person (id, id_person_type, name, document) VALUES(18, 1, Upper('Jéssica Lara Duarte'), '95464093249');
INSERT INTO person (id, id_person_type, name, document) VALUES(19, 1, Upper('Isabela Vera Viana'), '90955734940');
INSERT INTO person (id, id_person_type, name, document) VALUES(20, 1, Upper('Isaac Murilo Pereira'), '97358189493');
INSERT INTO person (id, id_person_type, name, document) VALUES(21, 1, Upper('Bento Giovanni Lima'), '58701290100');
INSERT INTO person (id, id_person_type, name, document) VALUES(22, 1, Upper('Danilo Arthur Pires'), '57416060753');
INSERT INTO person (id, id_person_type, name, document) VALUES(23, 1, Upper('Letícia Analu Lorena das Neves'), '21535924101');
INSERT INTO person (id, id_person_type, name, document) VALUES(24, 1, Upper('Amanda Isabella Cecília da Rocha'), '99183808108');
INSERT INTO person (id, id_person_type, name, document) VALUES(25, 1, Upper('Caio Victor Almada'), '08977613914');
INSERT INTO person (id, id_person_type, name, document) VALUES(26, 1, Upper('Manuel Ricardo Levi Moreira'), '06700572827');
INSERT INTO person (id, id_person_type, name, document) VALUES(27, 1, Upper('Regina Letícia Bianca Costa'), '39351828565');
INSERT INTO person (id, id_person_type, name, document) VALUES(28, 1, Upper('Benedita Luciana da Mata'), '20629570507');
INSERT INTO person (id, id_person_type, name, document) VALUES(29, 1, Upper('Pietra Maya da Cruz'), '57539155159');
INSERT INTO person (id, id_person_type, name, document) VALUES(30, 1, Upper('Joana Márcia Raimunda Mendes'), '49159989670');