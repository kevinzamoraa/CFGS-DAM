(: Declaración de namespace para eXist-db :)
declare namespace exist = "http://exist.sourceforge.net/NS/exist";

(: Importación del módulo de eXist para consultas XPath :)
import module namespace xpath = "http://exist.sourceforge.net/NS/exist";

(: Función principal para ejecutar las consultas :)
declare function local:ejecutar-consultas() {
    (: Obtener el documento XML :)
    let $doc := doc("xml/peliculas.xml")
    
    (: Ejecutar las consultas XPath del ejercicio 2 :)
    let $consulta1 := $doc/peliculas/pelicula[año > 2019]/titulo,
        $consulta2 := $doc/peliculas/pelicula/reparto/actor[@principal = 'S'],
        $consulta3 := count($doc/peliculas/pelicula[premios]),
        $consulta4 := for $p in $doc/peliculas/pelicula[@genero = 'Ciencia Ficción']
        return <pelicula>
            <titulo>{ $p/titulo }</titulo>
            <premios>{ $p/premios/premio/nombre }</premios>
        </pelicula>,
        $consulta5 := $doc/peliculas/pelicula[count(reparto/actor) > 1]/titulo,
        
    
    (: Retornar los resultados en un formato estructurado :)
    return <resultados>
        <consulta numero="1">
            <titulo>Títulos de películas dirigidas después del año 2019</titulo>
            <resultado>{ $consulta1 }</resultado>
        </consulta>
        <consulta numero="2">
            <titulo>Listar los actores principales de cada película</titulo>
            <resultado>{ $consulta2 }</resultado>
        </consulta>
        <consulta numero="3">
            <titulo>Contar cuántas películas tienen premios.</titulo>
            <resultado>{ $consulta3 }</resultado>
        </consulta>
        <consulta numero="4">
            <titulo>Mostrar los títulos y los nombres de los premios de las películas cuyo género sea
            "Ciencia Ficción".</titulo>
            <resultado>{ $consulta4 }</resultado>
        </consulta>
        <consulta numero="5">
            <titulo>Listar las películas que tienen más de un actor en el reparto.</titulo>
            <resultado>{ $consulta5 }</resultado>
        </consulta>
    </resultados>
};

(: Ejecutar la función principal :)
local:ejecutar-consultas()