CREATE PROCEDURE `getJeu`(IN `reference` VARCHAR(50))
	LANGUAGE SQL
	NOT DETERMINISTIC
	CONTAINS SQL
	SQL SECURITY DEFINER
	COMMENT ''
BEGIN
select jeu.*, CONCAT_WS(' ',age_min.nb,age_min.nom) as `age min`,if(age_max.nb,CONCAT_WS(' ',age_max.nb,age_max.nom),'et +') as `age max`, piles.nom as `pile`,
if(emprunt.date_sortie is not null and emprunt.date_retour is null,'','emprunté') as etat
from nu_jeu jeu
left join nu_age as age_min on jeu.id_age_min=age_min.id_age
left join nu_age as age_max on jeu.id_age_max=age_max.id_age
left join nu_pile as piles on jeu.id_pile
left join nu_emprunt emprunt on jeu.ref_jeu=emprunt.ref_jeu and emprunt.date_retour is null
and emprunt.date_sortie is not null
where  jeu.ref_jeu=reference;
END