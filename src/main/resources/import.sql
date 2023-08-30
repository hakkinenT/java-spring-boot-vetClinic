INSERT INTO tb_address(street, neighborhood, city, state, number, zip_code) VALUES ('Rua Laranjeiras', 'Centro', 'Riachuelo', 'Sergipe', '120', '49130000') ;
INSERT INTO tb_address(street, neighborhood, city, state, number, zip_code) VALUES ('Rua Santa Maria', 'Centro', 'Riachuelo', 'Sergipe', '1890', '49025050');
INSERT INTO tb_address(street, neighborhood, city, state, number, zip_code) VALUES ('Avenida Engenheiro Gentil Tavares', 'Aeroporto', 'Aracaju', 'Sergipe', '1920', '49055260');
INSERT INTO tb_address(street, neighborhood, city, state, number, zip_code) VALUES ('Avenida Juscelino Kubitschek', 'Aeroporto', 'Aracaju', 'Sergipe', '820', '49060550');

INSERT INTO tb_client(name, email, phone, address_id) VALUES ('José Fernandes', 'jose@gmail.com', '79988888888', 1);
INSERT INTO tb_client(name, email, phone, address_id) VALUES ('Maria Paula', 'maria@gmail.com', '79999999999', 2);

INSERT INTO tb_vet(name, email, phone, address_id) VALUES ('João Emanuel', 'joao@gmail.com', '79977777777', 3);
INSERT INTO tb_vet(name, email, phone, address_id) VALUES ('Caroline Conceição', 'caroline@gmail.com', '79955555555', 4);

INSERT INTO tb_species(name) VALUES ('Cachorro');
INSERT INTO tb_species(name) VALUES ('Gato');
INSERT INTO tb_species(name) VALUES ('Réptil');
INSERT INTO tb_species(name) VALUES ('Ave');
INSERT INTO tb_species(name) VALUES ('Roedor');

INSERT INTO tb_animal(name, age, gender, species_id, client_id) VALUES ('Flora', 9, 1, 1, 1);
INSERT INTO tb_animal(name, age, gender, species_id, client_id) VALUES ('Noa', 2, 0, 2, 1);
INSERT INTO tb_animal(name, age, gender, species_id, client_id) VALUES ('Nana', 5, 1, 3, 2);
INSERT INTO tb_animal(name, age, gender, species_id, client_id) VALUES ('Chico', 6, 0, 3, 2);

