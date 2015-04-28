select a.REF, count(*), STR_TO_DATE(max(h.date),'%Y/%m/%d/%k/%i/%s') as dernieremprunt
from ex_adherents a, ex_historique h
where a.REF=h.ref_adh
and h.`type` like '%out%'
group by a.ref