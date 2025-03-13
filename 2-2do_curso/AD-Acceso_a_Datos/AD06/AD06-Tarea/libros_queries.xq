(: Configuración básica para consultas XQuery en libros.xml :)

(: Declaración de namespace para eXist-db *)
declare namespace exist = "http://exist.sourceforge.net/NS/exist";

(: Importación del módulo de eXist para consultas XQuery *)
import module namespace xpath = "http://exist.sourceforge.net/NS/exist";

(: Función principal para ejecutar las consultas *)
declare function local:ejecutar-consultas() {
    (: Obtener el documento XML *)
    let $doc := doc("xml/libros.xml")
    
    (: Ejecutar las consultas XQuery del ejercicio 2 *)
    let $consulta1 := for $libro in $doc/bib/libro
                      return $libro/titulo,
        
        $consulta2 := for $libro in $doc/bib/libro
                     order by $libro/@año
                     return concat($libro/@año, ": ", $libro/titulo),
        
        $consulta3 := for $libro in $doc/bib/libro
                     where $libro/precio = "65.95"
                     return $libro/titulo,
        
        $consulta4 := for $libro in $doc/bib/libro
                     where $libro/@año < "2000"
                     return $libro/titulo,
        
        $consulta5 := for $libro in $doc/bib/libro
                     where $libro/editorial = "Addison-Wesley" and $libro/@año > "1992"
                     return concat($libro/@año, ": ", $libro/titulo),
        
        $consulta6 := for $libro in $doc/bib/libro
                     where count($libro/autor) > 1
                     return concat($libro/@año, ": ", $libro/titulo),
        
        $consulta7 := for $libro in $doc/bib/libro
                     where empty($libro/autor)
                     return concat($libro/@año, ": ", $libro/titulo),
        
        $consulta8 := for $apellido in distinct-values($doc/bib/libro/autor/apellido)
                     order by $apellido
                     return $apellido,
        
        $consulta9 := for $libro in $doc/bib/libro
                     return
                     <result>
                         <titulo>{ $libro/titulo }</titulo>
                         <autores>
                             { for $autor in $libro/autor
                               return <autor>{ concat($autor/apellido, ", ", $autor/nombre) }</autor>
                             }
                         </autores>
                     </result>,
        
        $consulta10 := for $libro in $doc/bib/libro
                      return
                      <libro>
                          <titulo>{ $libro/titulo }</titulo>
                          <numero-autores>{ count($libro/autor) }</numero-autores>
                      </libro>
    
    (: Retornar los resultados en un formato estructurado *)
    return <resultados>
        <consulta numero="1">
            <titulo>Títulos de todos los libros</titulo>
            <resultado>{ $consulta1 }</resultado>
        </consulta>
        <consulta numero="2">
            <titulo>Año y título ordenados por año</titulo>
            <resultado>{ $consulta2 }</resultado>
        </consulta>
        <consulta numero="3">
            <titulo>Libros con precio 65.95</titulo>
            <resultado>{ $consulta3 }</resultado>
        </consulta>
        <consulta numero="4">
            <titulo>Libros antes del año 2000</titulo>
            <resultado>{ $consulta4 }</resultado>
        </consulta>
        <consulta numero="5">
            <titulo>Libros Addison-Wesley después de 1992</titulo>
            <resultado>{ $consulta5 }</resultado>
        </consulta>
        <consulta numero="6">
            <titulo>Libros con múltiples autores</titulo>
            <resultado>{ $consulta6 }</resultado>
        </consulta>
        <consulta numero="7">
            <titulo>Libros sin autor</titulo>
            <resultado>{ $consulta7 }</resultado>
        </consulta>
        <consulta numero="8">
            <titulo>Autores únicos ordenados</titulo>
            <resultado>{ $consulta8 }</resultado>
        </consulta>
        <consulta numero="9">
            <titulo>Títulos y autores agrupados</titulo>
            <resultado>{ $consulta9 }</resultado>
        </consulta>
        <consulta numero="10">
            <titulo>Títulos y número de autores</titulo>
            <resultado>{ $consulta10 }</resultado>
        </consulta>
    </resultados>
};

(: Ejecutar la función principal *)
local:ejecutar-consultas()