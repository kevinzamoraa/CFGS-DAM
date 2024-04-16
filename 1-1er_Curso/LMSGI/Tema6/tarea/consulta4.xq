(:Una lista HTML con el nombre de los artistas nacidos en España. :)
<ul>
{
for $x in doc("artistas.xml")/artistas/artista
where $x/pais = "España"
order by $x/nombreCompleto
return <li>{data($x/nombreCompleto)}</li>
}
</ul>