CREATE TABLE client (
  id int NOT NULL AUTO_INCREMENT,
  id_person int NOT NULL,
  created_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id),
  UNIQUE KEY id_person_UNIQUE (id_person),
  CONSTRAINT fk_person_client FOREIGN KEY (id_person) REFERENCES person (id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO client (id, id_person) VALUES (1, 1);
INSERT INTO client (id, id_person) VALUES (2, 2);
INSERT INTO client (id, id_person) VALUES (3, 3);
INSERT INTO client (id, id_person) VALUES (4, 4);
INSERT INTO client (id, id_person) VALUES (5, 5);
INSERT INTO client (id, id_person) VALUES (6, 6);
INSERT INTO client (id, id_person) VALUES (7, 7);
INSERT INTO client (id, id_person) VALUES (8, 8);
INSERT INTO client (id, id_person) VALUES (9, 9);
INSERT INTO client (id, id_person) VALUES (10, 10);
INSERT INTO client (id, id_person) VALUES (11, 11);
INSERT INTO client (id, id_person) VALUES (12, 12);
INSERT INTO client (id, id_person) VALUES (13, 13);
INSERT INTO client (id, id_person) VALUES (14, 14);
INSERT INTO client (id, id_person) VALUES (15, 15);
INSERT INTO client (id, id_person) VALUES (16, 16);
INSERT INTO client (id, id_person) VALUES (17, 17);
INSERT INTO client (id, id_person) VALUES (18, 18);
INSERT INTO client (id, id_person) VALUES (19, 19);
INSERT INTO client (id, id_person) VALUES (20, 20);
INSERT INTO client (id, id_person) VALUES (21, 21);
INSERT INTO client (id, id_person) VALUES (22, 22);
INSERT INTO client (id, id_person) VALUES (23, 23);
INSERT INTO client (id, id_person) VALUES (24, 24);
INSERT INTO client (id, id_person) VALUES (25, 25);
INSERT INTO client (id, id_person) VALUES (26, 26);
INSERT INTO client (id, id_person) VALUES (27, 27);
INSERT INTO client (id, id_person) VALUES (28, 28);
INSERT INTO client (id, id_person) VALUES (29, 29);
INSERT INTO client (id, id_person) VALUES (30, 30);
