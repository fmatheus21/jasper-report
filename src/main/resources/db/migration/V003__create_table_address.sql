CREATE TABLE address (
  id int NOT NULL AUTO_INCREMENT,
  id_person int NOT NULL,
  place varchar(70) NOT NULL,
  number varchar(10) NOT NULL,
  complement varchar(50) DEFAULT NULL,
  district varchar(70) NOT NULL,
  city varchar(70) NOT NULL,
  state varchar(2) NOT NULL,
  zip_code varchar(15) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  UNIQUE KEY id_person_UNIQUE (id_person),
  CONSTRAINT fk_person_address FOREIGN KEY (id_person) REFERENCES person (id) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (1, 1, Upper('Rua Cristiano Olsen'), '364', Upper('apt 101'), Upper('Jardim Sumaré'), Upper('Araçatuba'), Upper('SP'), '16015244');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (2, 2, Upper('Rua Pereira Estéfano'), '23', null, Upper('Vila da Saúde'), Upper('São Paulo'), Upper('SP'), '04144070');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (3, 3, Upper('Rua das Fiandeiras'), '971', Upper('apt 702'), Upper('Vila Olímpia'), Upper('São Paulo'), Upper('SP'), '04545005');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (4, 4, Upper('Avenida Afonso Pena'), '1374', Upper('apt 605'), Upper('Boa Viagem'), Upper('Belo Horizonte'), Upper('MG'), '30130005');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (5, 5, Upper('Avenida Governador José Malcher'), '571', Upper('apt 407'), Upper('Nazaré'), Upper('Belém'), Upper('PA'), '66055260');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (6, 6, Upper('Rua da Imprensa'), '23', null, Upper('Monte Castelo'), Upper('Campo Grande'), Upper('MS'), '79002290');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (7, 7, Upper('Rua Arlindo Nogueira'), '640', null, Upper('Centro'), Upper('Teresina'), Upper('PI'), '64000290');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (8, 8, Upper('Avenida Desembargador Moreira'), '1500', Upper('apt 701'), Upper('Aldeota'), Upper('Fortaleza'), Upper('CE'), '60170001');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (9, 9, Upper('Avenida Almirante Maximiano Fonseca'), '983', Upper('apt 505'), Upper('Zona Portuária'), Upper('Rio Grande'), Upper('RS'), '96204040');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (10, 10, Upper('QE 11 Área Especial C'), '71', null, Upper('Guará I'), Upper('Brasília'), Upper('DF'), '88113350');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (11, 11, Upper('Rua Pereira Estéfano'), '104', null, Upper('Vila da Saúde'), Upper('São Paulo'), Upper('SP'), '04144070');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (12, 12, Upper('Avenida Rio Branco'), '743', Upper('apt 902'), Upper('Centro'), Upper('Rio de Janeiro'), Upper('RJ'), '20040002');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (13, 13, Upper('Rua Carlos Augusto Cornelsen'), '240', null, Upper('Bom Retiro'), Upper('Curitiba'), Upper('PR'), '80520560');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (14, 14, Upper('Travessa da CDL'), '49', null, Upper('Centro'), Upper('Ji-Paraná'), Upper('RO'), '76900032');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (15, 15, Upper('Rua Domingos Olímpio'), '247', Upper('apt 104'), Upper('Centro'), Upper('Sobral'), Upper('CE'), '62011140');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (16, 16, Upper('Avenida São João'), '573', Upper('apt 407'), Upper('Vila Joana'), Upper('Jundiaí'), Upper('SP'), '13216000');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (17, 17, Upper('Avenida Inglaterra'), '512', Upper('apt 702'), Upper('São José'), Upper('Macapá'), Upper('AP'), '68906175');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (18, 18, Upper('Rua E'), '650', null, Upper('Pedrinhas'), Upper('Macapá'), Upper('AP'), '68903118');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (19, 19, Upper('Rua Angico'), '155', null, Upper('Mocambinho'), Upper('Teresina'), Upper('PI'), '64010615');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (20, 20, Upper('Rua Antônio Fernandes da Silva'), '594', Upper('apt 202'), Upper('Jardim Marajó'), Upper('Campinas'), Upper('SP'), '13057104');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (21, 21, Upper('Rua Mônica'), '807', null, Upper('Dom Lustosa'), Upper('Fortaleza'), Upper('CE'), '60526015');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (22, 22, Upper('Travessa Pinhui'), '428', null, Upper('Lourdes'), Upper('Governador Valadares'), Upper('MG'), '35032412');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (23, 23, Upper('Rua das Fontes'), '700', null, Upper('Terra do Sol'), Upper('Aparecida de Goiânia'), Upper('GO'), '74993740');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (24, 24, Upper('Rua Alberto Motta'), '876', null, Upper('Morrotes'), Upper('Tubarão'), Upper('SC'), '88704140');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (25, 25, Upper('Rua A8'), '616', null, Upper('Residencial Park dos Buritis'), Upper('Gurupi'), Upper('TO'), '77426024');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (26, 26, Upper('Alameda Bom Jardim I'), '136', Upper('apt 401'), Upper('Aparecida'), Upper('Altamira'), Upper('PA'), '68377435');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (27, 27, Upper('Rua A'), '872', null, Upper('Cidade Nova'), Upper('Aracaju'), Upper('SE'), '49070608');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (28, 28, Upper('Rua Osvaldo Cruz'), '362', null, Upper('Paraíso'), Upper('Santana'), Upper('AP'), '68928003');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (29, 29, Upper('Rua Pedro Bacelar'), '832', Upper('apt 604'), Upper('Cajuru'), Upper('Curitiba'), Upper('PR'), '82990482');
INSERT INTO address (id, id_person, place, number, complement, district, city, state, zip_code) VALUES (30, 30, Upper('Rua Albaniza Soares Pereira'), '473', null, Upper('Bela Vista'), Upper('Mossoró'), Upper('RN'), '59609510');