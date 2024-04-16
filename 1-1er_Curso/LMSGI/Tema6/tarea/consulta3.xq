(: Título de los libros que no tienen versión electrónica. :)
for $x in doc("artistas.xml")/artistas/artista
where not($x/fallecimiento)
return$x/nombreCompleto