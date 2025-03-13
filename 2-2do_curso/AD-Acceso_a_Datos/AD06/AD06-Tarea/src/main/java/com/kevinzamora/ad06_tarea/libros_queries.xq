(: Ejercicio 2: Consultas XQuery en libros.xml :)
(:    1. Listar el título de todos los libros: :)
       
       for $libro in doc("libros.xml")/bib/libro
       return $libro/titulo
(:    2. Listar año y título de todos los libros, ordenados por el año: :)
       
       for $libro in doc("libros.xml")/bib/libro
       order by $libro/@año
       return concat($libro/@año, ": ", $libro/titulo)
(:    3. Listar los libros cuyo precio sea 65.95: :)
       
       for $libro in doc("libros.xml")/bib/libro
       where $libro/precio = "65.95"
       return $libro/titulo
(:    4. Listar los libros publicados antes del año 2000: :)
       
       for $libro in doc("libros.xml")/bib/libro
       where $libro/@año < "2000"
       return $libro/titulo
(:    5. Listar año y título de los libros publicados por Addison-Wesley después del año 1992: :)
       
       for $libro in doc("libros.xml")/bib/libro
       where $libro/editorial = "Addison-Wesley" and $libro/@año > "1992"
       return concat($libro/@año, ": ", $libro/titulo)
(:    6. Listar año y título de los libros que tienen más de un autor: :)
       
       for $libro in doc("libros.xml")/bib/libro
       where count($libro/autor) > 1
       return concat($libro/@año, ": ", $libro/titulo)
(:    7. Listar año y título de los libros que no tienen autor: :)
       
       for $libro in doc("libros.xml")/bib/libro
       where empty($libro/autor)
       return concat($libro/@año, ": ", $libro/titulo)
(:    8. Mostrar los apellidos de los autores que aparecen en el documento, sin repeticiones, ordenados alfabéticamente: :)
       
       for $apellido in distinct-values(doc("libros.xml")/bib/libro/autor/apellido)
       order by $apellido
       return $apellido
(:    9. Por cada libro, listar agrupado en un elemento <result> su título y autores: :)
       
       for $libro in doc("libros.xml")/bib/libro
       return
       <result>
           <titulo>{ $libro/titulo }</titulo>
           <autores>
               { for $autor in $libro/autor
                 return <autor>{ concat($autor/apellido, ", ", $autor/nombre) }</autor>
               }
           </autores>
       </result>
(:    10. Por cada libro, obtener su título y el número de autores, agrupados en un elemento <libro>: :)
       
       for $libro in doc("libros.xml")/bib/libro
       return
       <libro>
           <titulo>{ $libro/titulo }</titulo>
           <numero-autores>{ count($libro/autor) }</numero-autores>
       </libro>

