xquery version "1.0";

declare function local:ejecutar-consultas() {
    let $doc := doc("peliculas.xml")
    
    (: 1. Títulos de películas dirigidas después del año 2019 :)
    let $consulta1 :=
        for $p in $doc/peliculas/pelicula
        where $p/año > 2019
        return $p/titulo,

    (: 2. Listar los actores principales de cada película :)
    let $consulta2 :=
        for $p in $doc/peliculas/pelicula
        return
            <pelicula>
                <titulo>{ $p/titulo/text() }</titulo>
                <actoresPrincipales>{
                    for $a in $p/reparto/actor
                    where $a/@principal = 'S'
                    return <actor>{ $a/text() }</actor>
                }</actoresPrincipales>
            </pelicula>,

    (: 3. Contar cuántas películas tienen premios :)
    let $consulta3 :=
        count(
            for $p in $doc/peliculas/pelicula
            where exists($p/premios)
            return $p
        ),

    (: 4. Mostrar títulos y nombres de premios de películas de "Ciencia Ficción" :)
    let $consulta4 :=
        for $p in $doc/peliculas/pelicula
        where $p/@genero = 'Ciencia Ficción'
        return
            <pelicula>
                <titulo>{ $p/titulo/text() }</titulo>
                <premios>{
                    for $pr in $p/premios/premio
                    return <premio>{ $pr/nombre/text() }</premio>
                }</premios>
            </pelicula>,

    (: 5. Películas que tienen más de un actor en el reparto :)
    let $consulta5 :=
        for $p in $doc/peliculas/pelicula
        where count($p/reparto/actor) > 1
        return $p/titulo

    return <resultados>
        <consulta numero="1">
            <titulo>1. Títulos de películas dirigidas después del año 2019</titulo>
            <resultado>{ $consulta1 }</resultado>
        </consulta>
        <consulta numero="2">
            <titulo>2. Actores principales de cada película</titulo>
            <resultado>{ $consulta2 }</resultado>
        </consulta>
        <consulta numero="3">
            <titulo>3. Número de películas con premios</titulo>
            <resultado>{ $consulta3 }</resultado>
        </consulta>
        <consulta numero="4">
            <titulo>4. Títulos y premios de películas de "Ciencia Ficción"</titulo>
            <resultado>{ $consulta4 }</resultado>
        </consulta>
        <consulta numero="5">
            <titulo>5. Películas con más de un actor en el reparto</titulo>
            <resultado>{ $consulta5 }</resultado>
        </consulta>
    </resultados>
};

local:ejecutar-consultas()
