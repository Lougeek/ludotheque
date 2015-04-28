-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           5.0.67-community-nt - MySQL Community Edition (GPL)
-- Serveur OS:                   Win32
-- HeidiSQL Version:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Export de la structure de la base pour ludo
CREATE DATABASE IF NOT EXISTS `ludo` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `ludo`;


-- Export de la structure de procedure ludo. getJeu
DELIMITER //
CREATE DEFINER=`dba`@`localhost` PROCEDURE `getJeu`(IN `reference` VARCHAR(50))
BEGIN
select jeu.*,age_min.nb as min_nb,age_min.nom as min_nom,
age_max.nb as max_nb,age_max.nom as max_nom, CONCAT_WS(' ',age_min.nb,age_min.nom) as `age min`,if(age_max.nb,CONCAT_WS(' ',age_max.nb,age_max.nom),'et +') as `age max`, piles.nom as `pile`,
if(emprunt.date_sortie is not null and emprunt.date_retour is null,'','emprunté') as etat
from nu_jeu jeu
left join nu_age as age_min on jeu.id_age_min=age_min.id_age
left join nu_age as age_max on jeu.id_age_max=age_max.id_age
left join nu_pile as piles on jeu.id_pile
left join nu_emprunt emprunt on jeu.ref_jeu=emprunt.ref_jeu and emprunt.date_retour is null
and emprunt.date_sortie is not null
where  jeu.ref_jeu=reference;
END//
DELIMITER ;


-- Export de la structure de procedure ludo. listeJeu
DELIMITER //
CREATE DEFINER=`dba`@`localhost` PROCEDURE `listeJeu`()
BEGIN
select jeu.*,age_min.nb as min_nb,age_min.nom as min_nom,
age_max.nb as max_nb,age_max.nom as max_nom, CONCAT_WS(' ',age_min.nb,age_min.nom) as `age min`,if(age_max.nb,CONCAT_WS(' ',age_max.nb,age_max.nom),'et +') as `age max`, piles.nom as `pile`,
if(emprunt.date_sortie is not null and emprunt.date_retour is null,'','emprunté') as etat
from nu_jeu jeu
left join nu_age as age_min on jeu.id_age_min=age_min.id_age
left join nu_age as age_max on jeu.id_age_max=age_max.id_age
left join nu_pile as piles on jeu.id_pile
left join nu_emprunt emprunt on jeu.ref_jeu=emprunt.ref_jeu and emprunt.date_retour is null
and emprunt.date_sortie is not null
group by jeu.ref_jeu;
END//
DELIMITER ;


-- Export de la structure de procedure ludo. listeJeuReserve
DELIMITER //
CREATE DEFINER=`dba`@`localhost` PROCEDURE `listeJeuReserve`(IN `id_resa` INT)
BEGIN
select jeu.*,adh.ref_adhérent, CONCAT_WS(' ',pers.nom,pers.prénom),
if(emprunt.date_sortie is not null and emprunt.date_retour is null,'','emprunté') as etat
from nu_jeu jeu

left join nu_emprunt emprunt on jeu.ref_jeu=emprunt.ref_jeu and emprunt.date_retour is null
join nu_resa_jeu as resa on resa.ref_jeu=jeu.ref_jeu
join nu_réservation reserve on reserve.id_réservation=resa.id_réservation
join nu_adhérent as adh on adh.ref_adhérent=reserve.ref_adhérent
join nu_personne as pers on pers.id_personne=adh.id_référent
and resa.id_réservation=id_resa
group by jeu.ref_jeu;

END//
DELIMITER ;


-- Export de la structure de procedure ludo. listeJeuxEmprunte
DELIMITER //
CREATE DEFINER=`dba`@`localhost` PROCEDURE `listeJeuxEmprunte`(IN `ref_adh` VARCHAR(50))
BEGIN
select emp.*, jeu.*
from nu_emprunt emp
join nu_jeu as jeu on jeu.ref_jeu=emp.ref_jeu
where emp.ref_adhérent=ref_adh
and emp.date_retour is null;
END//
DELIMITER ;


-- Export de la structure de procedure ludo. listeReservation
DELIMITER //
CREATE DEFINER=`dba`@`localhost` PROCEDURE `listeReservation`()
BEGIN
select r.id_réservation, a.ref_adhérent,p.nom,p.prénom, r.date_début, r.date_fin, rj.ref_jeu, j.nom, e.date_sortie, e.date_retour
from nu_réservation r 
join nu_resa_jeu as rj on r.id_réservation=rj.id_réservation 
join nu_adhérent a on a.ref_adhérent=r.ref_adhérent
join nu_personne p on p.id_personne=a.id_référent
join nu_jeu j on j.ref_jeu = rj.ref_jeu
left join nu_emprunt e on e.id_emprunt = rj.id_emprunt;
END//
DELIMITER ;


-- Export de la structure de procedure ludo. listeReservationAdherent
DELIMITER //
CREATE DEFINER=`dba`@`localhost` PROCEDURE `listeReservationAdherent`(IN `ref_adh` VARCHAR(50))
BEGIN
select r.id_réservation, a.ref_adhérent,p.nom,p.prénom, r.date_début, r.date_fin, rj.ref_jeu, j.nom, e.date_sortie, e.date_retour
from nu_réservation r 
join nu_resa_jeu as rj on r.id_réservation=rj.id_réservation 
join nu_adhérent a on a.ref_adhérent=r.ref_adhérent
join nu_personne p on p.id_personne=a.id_référent
join nu_jeu j on j.ref_jeu = rj.ref_jeu
left join nu_emprunt e on e.id_emprunt = rj.id_emprunt
where r.ref_adhérent=ref_adh;
END//
DELIMITER ;


-- Export de la structure de procedure ludo. listeReservationJeu
DELIMITER //
CREATE DEFINER=`dba`@`localhost` PROCEDURE `listeReservationJeu`(IN `ref_jeu` VARCHAR(50))
BEGIN
select r.id_réservation, a.ref_adhérent,p.nom,p.prénom, r.date_début, r.date_fin, rj.ref_jeu, j.nom, e.date_sortie, e.date_retour
from nu_réservation r 
join nu_resa_jeu as rj on r.id_réservation=rj.id_réservation 
join nu_adhérent a on a.ref_adhérent=r.ref_adhérent
join nu_personne p on p.id_personne=a.id_référent
join nu_jeu j on j.ref_jeu = rj.ref_jeu
left join nu_emprunt e on e.id_emprunt = rj.id_emprunt
where rj.ref_jeu=ref_jeu;
END//
DELIMITER ;


-- Export de la structure de fonction ludo. resaEstRentré
DELIMITER //
CREATE DEFINER=`dba`@`localhost` FUNCTION `resaEstRentré`(`id_reservation` INT) RETURNS tinyint(4)
BEGIN
DECLARE nbresa tinyint;
DECLARE nbretour tinyint;

select count(*) into nbresa
from nu_resa_jeu r
where r.id_réservation=id_reservation;

select count(*) into nbretour
from nu_resa_jeu r , nu_emprunt e
where r.id_emprunt = e.id_emprunt 
and e.date_retour is not null
and r.id_réservation=id_reservation;
RETURN nbresa= nbretour;
END//
DELIMITER ;


-- Export de la structure de fonction ludo. resaEstSortie
DELIMITER //
CREATE DEFINER=`dba`@`localhost` FUNCTION `resaEstSortie`(`id_reservation` INT) RETURNS tinyint(4)
BEGIN

DECLARE nbsortie tinyint;


select count(*) into nbsortie
from nu_resa_jeu r , nu_emprunt e
where r.id_emprunt = e.id_emprunt 
and e.date_retour is not null
and r.id_réservation=id_reservation;

RETURN nbsortie>0;

END//
DELIMITER ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
