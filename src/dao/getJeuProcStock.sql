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
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
