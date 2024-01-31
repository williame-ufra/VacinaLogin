-- senha a
insert into usuario (id, nome, celular, email, senha, perfil) values (1, 'Fulano de Tal', '91999991111', 'fulano@seila.com.br', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'A');
insert into usuario (id, nome, celular, email, senha, perfil) values (2, 'Beltrano Jr', '91999992222', 'beltrano@seila.com.br', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'V');
insert into usuario (id, nome, celular, email, senha, perfil) values (3, 'Ciclano da Silva', '91999993333', 'ciclano@seila.com.br', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'U');

INSERT INTO raca (id, nome) VALUES (1, 'Pug');
INSERT INTO raca (id, nome) VALUES (2, 'Boxer');
INSERT INTO raca (id, nome) VALUES (3, 'Shih Tzu');
INSERT INTO raca (id, nome) VALUES (4, 'Dachshund');
INSERT INTO raca (id, nome) VALUES (5, 'Siamese cat');
INSERT INTO raca (id, nome) VALUES (6, 'Persian cat');
INSERT INTO raca (id, nome) VALUES (7, 'Russian Blue');

insert into animal (nome, dono, telefone, raca, tipo, nascimento) 
values ('Don', 'Diego', '912345678', 2, 'C', '2015-07-01');
insert into animal (nome, dono, telefone, raca, tipo, nascimento) 
values ('Tel', 'Alessandra', '945678123', 2, 'C', '2014-10-07');
insert into animal (nome, dono, telefone, raca, tipo, nascimento) 
values ('Petrus', 'Augusto', '956781234', 1, 'C', '2016-01-05');
insert into animal (nome, dono, telefone, raca, tipo, nascimento) 
values ('Viseu', 'Diego', '912345678', 7, 'G', '2015-07-01');
insert into animal (nome, dono, telefone, raca, tipo, nascimento) 
values ('Duelo', 'Alessandra', '945678123', 6, 'G', '2014-10-07');
insert into animal (nome, dono, telefone, raca, tipo, nascimento) 
values ('Gargamel', 'Augusto', '956781234', 5, 'G', '2016-01-05');