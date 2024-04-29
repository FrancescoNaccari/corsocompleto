--estrai tutti i clienti con nome Mario
select * from public.clienti where nome='Mario';


--Estrarre il nome e il cognome dei clienti nati nel 1982
select nome, cognome from public.clienti where anno_nascita=1992;

--Estrarre il numero delle fatture con iva al 20%

select count (*) from public.fatture where iva=20; 

--Estrarre i prodotti avi del 2017 a che spmo in produzione oppure in commercio
select * from public.prodotti where extract(year from data_attivazione)=2017 and (in_produzione=true or in_commercio=true);

--Estrarre l'elenco delle fatture 
select * from public.fatture f inner join public.clienti c on f.id_cliente=c.numero_cliente where importo <1000;

--
select fa.numero_fatture, fa.importo, fa.iva,fa.data_fattura,fo.denominazione
from public.fatture fa inner join public.fornitori fo
on fa.numero_fornitore=fo.numero_fornitore;


--

select extract(year from data_fattura) anno,count(* ) numero_fatture
from public.fatture where iva=20 group by anno;

--

select extract(year from data_fattura) anno,count(* ) numero_fatture, sum(importo) importo_totale
from public.fatture group by anno;