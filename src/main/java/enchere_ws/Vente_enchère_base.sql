Drop Database enchere;
create Database enchere;
drop role enchere;
create role enchere login password 'enchere';
ALTER database enchere OWNER to enchere;


drop TABLE client;
CREATE TABLE client(
    id SERIAL PRIMARY KEY,
    username VARCHAR(50),
    motdepasse VARCHAR(50),
    sexe int not null,
    email VARCHAR(50)
);

insert into client (username,motdepasse,sexe,email)values ('Rakoto','123',1,'rakoto@gmail.com');
insert into client (username,motdepasse,sexe,email)values ('Rasoa','123',0,'rasoa@gmail.com');
insert into client (username,motdepasse,sexe,email)values ('Rabe','123',1,'rabe@gmail.com');


CREATE TABLE demande(
    id SERIAL PRIMARY KEY,
    idclient int not null references client(id),
    montant double precision,
    etat int default(0)
);
insert into demande (idclient,montant)values (1,100000);
insert into demande (idclient,montant)values (2,25015);
insert into demande (idclient,montant)values (1,25210);
insert into demande (idclient,montant)values (3,87562);
insert into demande (idclient,montant)values (2,14762);
insert into demande (idclient,montant)values (1,46800);
insert into demande (idclient,montant)values (2,25506);
insert into demande (idclient,montant)values (1,100500);
insert into demande (idclient,montant)values (3,15825);
insert into demande (idclient,montant)values (3,5656);
insert into demande (idclient,montant)values (2,56546);
insert into demande (idclient,montant)values (1,38136);
insert into demande (idclient,montant)values (2,64535);
insert into demande (idclient,montant)values (3,74244);


CREATE TABLE mouvementCompte(
    id SERIAL PRIMARY KEY,
    idclient int not null references client(id),
    typemouvement int,
    montant double precision
);
insert into mouvementCompte(idclient,typemouvement,montant) values(1,1,200);
insert into mouvementCompte(idclient,typemouvement,montant) values(2,1,150);
insert into mouvementCompte(idclient,typemouvement,montant) values(1,0,300);
insert into mouvementCompte(idclient,typemouvement,montant) values(2,0,250);
insert into mouvementCompte(idclient,typemouvement,montant) values(1,1,60);


CREATE TABLE categorie(
    id SERIAL PRIMARY KEY,
    nomcategorie VARCHAR(50),
    pourcentage double precision
);
insert into categorie (nomcategorie,pourcentage)values ('antiquite',3.00);

insert into categorie (nomcategorie,pourcentage)values ('rare',4.00);

insert into categorie (nomcategorie,pourcentage)values ('bibelot',3.69);

insert into categorie (nomcategorie,pourcentage)values ('collection',3.70);




CREATE TABLE produit(
    id SERIAL PRIMARY KEY,
    idclient int,
    nomproduit VARCHAR(50),
    idcategorie int not null references categorie(id),
    dureeenchereminute time,
    dateenchere timestamp default now(),
    prixmin double precision

);
insert into produit (idclient,nomproduit,idcategorie,dureeenchereminute,dateenchere,prixmin)values (1,'produit1',1,'00:30:00','2023-02-03 08:36:21',4000);
insert into produit (idclient,nomproduit,idcategorie,dureeenchereminute,dateenchere,prixmin)values (2,'produit2',2,'00:30:00','2023-02-03 10:36:21',6000);
insert into produit (idclient,nomproduit,idcategorie,dureeenchereminute,dateenchere,prixmin)values (3,'produit3',3,'00:30:00','2023-02-03 11:36:21',3000);
insert into produit (idclient,nomproduit,idcategorie,dureeenchereminute,dateenchere,prixmin)values (2,'produit4',4,'00:30:00','2023-02-03 12:36:21',2000);
insert into produit (idclient,nomproduit,idcategorie,dureeenchereminute,dateenchere,prixmin)values (3,'produit5',1,'00:30:00','2023-02-03 09:36:21',10000);
insert into produit (idclient,nomproduit,idcategorie,dureeenchereminute,dateenchere,prixmin)values (4,'produit6',3,'00:30:00','2023-02-03 05:36:21',6000);
insert into produit (idclient,nomproduit,idcategorie,dureeenchereminute,dateenchere,prixmin)values (6,'produit7',4,'00:30:00','2023-02-03 16:36:21',5000);
insert into produit (idclient,nomproduit,idcategorie,dureeenchereminute,dateenchere,prixmin)values (5,'produit8',2,'00:30:00','2023-02-03 17:36:21',1000);
insert into produit (idclient,nomproduit,idcategorie,dureeenchereminute,dateenchere,prixmin)values (1,'produit9',2,'00:30:00','2023-02-03 10:59:21',1000);
insert into produit (idclient,nomproduit,idcategorie,dureeenchereminute,dateenchere,prixmin)values (1,'produit10',2,'00:30:00','2023-02-03 20:36:21',1000);

insert into produit (idclient,nomproduit,idcategorie,dureeenchereminute,dateenchere,prixmin)values (3,'ProduiT1',1,'00:30:00','2023-02-01 20:36:21',7000);
insert into produit (idclient,nomproduit,idcategorie,dureeenchereminute,dateenchere,prixmin)values (3,'ProduiT2',2,'00:30:00','2023-02-01 10:36:21',5000);
CREATE OR REPLACE VIEW vproduit AS
select id as idproduit ,idclient,idcategorie,prixmin from produit;

CREATE TABLE image(
      id SERIAL PRIMARY KEY,
      image_data bytea NOT NULL,
      image_url text NOT NULL,
    idproduit int not null references produit(id)
);


CREATE TABLE enchere(
    id SERIAL PRIMARY KEY,
    idproduit int not null references produit(id),
    idclient int,
    montantenchere double precision
);

INSERT INTO enchere(idproduit,idclient,montantenchere) VALUES
    (1,2,8000),
    (2,1,7000),
    (4,2,5500),
    (3,3,3500),
    (6,1,6000),
    (7,1,7500);
INSERT INTO enchere(idproduit,idclient,montantenchere) VALUES(11,2,7500);
INSERT INTO enchere(idproduit,idclient,montantenchere) VALUES(12,1,5300);

CREATE OR REPLACE VIEW encherir AS
select idproduit,idclient,montantenchere,email from enchere
 JOIN client ON client.id = enchere.idclient order by montantenchere desc;


------?????????????????-----------
CREATE TABLE encheredone(
    id SERIAL PRIMARY KEY,
    idproduit int not null references produit(id),
    idclient int,
    montantenchere double precision
);
INSERT INTO encheredone(idproduit,idclient,montantenchere) VALUES(1,1,18000);
INSERT INTO encheredone(idproduit,idclient,montantenchere) VALUES(2,1,17000);
INSERT INTO encheredone(idproduit,idclient,montantenchere) VALUES(4,2,15500);
----------------------------------------------
drop view venchere;
CREATE OR REPLACE VIEW venchere AS
SELECT
enchere.id AS id,
enchere.idproduit AS idproduit,
enchere.idclient AS idclientnado,
enchere.montantenchere AS montantenchere,
produit.nomproduit AS produit,
produit.dureeenchereminute AS duree,
produit.dateenchere AS dateenchere,
produit.prixmin AS prixmin,
client.username AS client,
client.email AS email
FROM produit
JOIN enchere ON produit.id = enchere.idproduit
JOIN client ON client.id = enchere.idclient;





CREATE OR REPLACE VIEW produitclient AS
SELECT
    po.id,
    po.idclient,
    po.nomproduit,
    ca.id  as idcategori,
    ca.nomcategorie,
    po.dureeenchereminute,
CASE WHEN(dateenchere + dureeenchereminute < now()   ) THEN 0
         ELSE  1
        END as statu,
    po.dateenchere ,
    po.prixmin,
       cl.email,
       cl.username
FROM produit as po
         JOIN categorie as ca ON po.idcategorie = ca.id
         JOIN client as cl ON po.idclient = cl.id;


