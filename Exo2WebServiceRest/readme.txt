///// install BDD /////

créer une nouvelle BDD
l'appeler : bibli

Lancer le code sql suivant pour créer les tables : 

create table customers 
(
numero INT PRIMARY KEY NOT NULL,
nom VARCHAR(100),
prenom VARCHAR(100),
adresse VARCHAR(255),
logged boolean default false
);

create table books
(
isbn INT PRIMARY KEY NOT NULL,
titre VARCHAR(255),
auteur VARCHAR(255),
categorie VARCHAR(255),
quantite INT DEFAULT 0
);

create table borrows
(
isbn INT NOT NULL,
idCustomer INT NOT NULL,
FOREIGN KEY (idcustomer) REFERENCES customers(numero),
FOREIGN KEY (isbn) REFERENCES books(isbn)
);

////// fin création tables /////

////// peuplement //////

INSERT INTO customers VALUES (4958,'MAG','STEVE','Adresse',false);
INSERT INTO customers VALUES (49,'LAL','FRANCOIS','Adresse2',false);
INSERT INTO customers VALUES (49234,'ROT','GUILLAUME','Adresse3',false);

INSERT INTO books VALUES (89355935,'titre1','ST','cat',12);
INSERT INTO books VALUES (89350484,'titre2','FR','cat1',8);
INSERT INTO books VALUES (89456544,'titre3','GU','cat2',1);

INSERT INTO borrows VALUES (89355935, 4958);

////// fin de la partie BDD ////////
