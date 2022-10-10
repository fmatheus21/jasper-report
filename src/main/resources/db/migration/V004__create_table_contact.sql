CREATE TABLE contact (
  id int NOT NULL AUTO_INCREMENT,
  id_person int NOT NULL,
  phone varchar(20) NOT NULL,
  email varchar(200) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  UNIQUE KEY id_person_UNIQUE (id_person),
  UNIQUE KEY phone_UNIQUE (phone),
  UNIQUE KEY email_UNIQUE (email),
  CONSTRAINT fk_person_contact FOREIGN KEY (id_person) REFERENCES person (id) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO contact (id, id_person, phone, email) VALUES (1, 1, '21998064942', Upper('anderson@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (2, 2, '84998023648', Upper('sonia@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (3, 3, '88996385939', Upper('eloa@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (4, 4, '81982286428', Upper('isis@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (5, 5, '65989598567', Upper('miguel@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (6, 6, '92982981611', Upper('fernanda@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (7, 7, '79999810672', Upper('caua@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (8, 8, '92993733573', Upper('murilo@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (9, 9, '65989406658', Upper('carolina@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (10, 10, '82997955581', Upper('enrico@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (11, 11, '96992249529', Upper('jose@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (12, 12, '79981516972', Upper('carlos@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (13, 13, '81986110969', Upper('mario@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (14, 14, '53991056708', Upper('tania@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (15, 15, '27983458354', Upper('raimunda@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (16, 16, '17982490922', Upper('marcio@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (17, 17, '88988147351', Upper('luan@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (18, 18, '86999342450', Upper('jessica@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (19, 19, '81994278911', Upper('isabela@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (20, 20, '71988788263', Upper('isaac@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (21, 21, '27983316675', Upper('bento@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (22, 22, '69981377201', Upper('danilo@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (23, 23, '96992752613', Upper('leticia@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (24, 24, '63998255115', Upper('amanda@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (25, 25, '84983959615', Upper('caio@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (26, 26, '96984105305', Upper('manuel@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (27, 27, '82995512094', Upper('regina@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (28, 28, '43987048924', Upper('benedita@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (29, 29, '81998639192', Upper('pietra@domain.com'));
INSERT INTO contact (id, id_person, phone, email) VALUES (30, 30, '79995171457', Upper('joana@domain.com'));