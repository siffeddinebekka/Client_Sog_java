drop database if exists orange;
create database orange; 
    use orange;

    CREATE TABLE `admin` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL
);

--
-- Contenu de la table `admin`
--(1, 'admin', 'admin'),

INSERT INTO `admin` (`ID`, `USERNAME`, `PASSWORD`) VALUES

(1,'s@gmail.com' , '123');

CREATE TABLE `options` (
  `IDOPTION` char(32) NOT NULL,
  `LIBELLE` char(32) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



    create table client (
    codec int(4) auto_increment not null,
    nomc char(30) not null,
    prenomc char(30) not null,
    adressec varchar(30) not null,
    cpc int(5) not null,
    mailc varchar(30) not null,
    telc varchar(30) not null,
    primary key (codec, nomc)
)engine=innodb;


create table technicien (
    codet int(4) auto_increment not null,
    nomt char(30) not null,
    prenomt char(30) not null,
    dateemb date not null, 
    mailt varchar(30) not null,
    telt varchar(30) not null,
    primary key (codet, nomt)
)engine=innodb;

create table intervention (
    codei int(4) auto_increment not null,
    adressei varchar(30) not null,
    datetimei datetime not null,
    objet varchar(150) not null,
    codec int(4) not null,
    nomc char(30) not null,
    codet int(4) not null,
    nomt char(30) not null,
    primary key (codei),
    foreign key (codec, nomc) references client(codec, nomc),
    foreign key (codet, nomt) references technicien(codet, nomt)
)engine=innodb;




insert into `client` values 
    (null, 'GILLES', 'Aurelien', '1 rue des fleurs', 75001, 'poncefleur@gmail.com', '0600000001'), 
    (null, 'ETOILES', 'Rayenne', '1 rue des etoiles', 75002, 'etoiles@gmail.com', '0600000201'), 
    (null, 'REUNBOT', 'Theo Riv', '1 rue des cerveaux', 75003, 'cerveau@gmail.com', '0619991758'), 
    (null, 'ONUTREM', 'Dorian', '1 rue de la peche', 75101, 'peach@gmail.com', '0601010101');

insert into `technicien` values 
    (null, 'YTB', 'Guillaume', '2015-01-12', 'guillaumepro@gmail.com', '0601000000'), 
    (null, 'INTEL', 'Jigfio', '2021-01-06', 'jigfiopro@gmail.com', '0604581236');

insert into `intervention` values 
    (null, '1 rue des fleurs, 75001', '2021-10-05-18:33:02', 'Installer la nouvelle RTX 3090 dans le pc du client.', 1, 'GILLES', 1, 'YTB');






ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID`);