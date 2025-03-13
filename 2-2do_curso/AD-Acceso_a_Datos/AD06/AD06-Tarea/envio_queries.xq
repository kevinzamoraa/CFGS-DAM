(: Configuración básica para consultas XPath en envio.xml :)

(: Declaración de namespace para eXist-db :)
declare namespace exist = "http://exist.sourceforge.net/NS/exist";

(: Importación del módulo de eXist para consultas XPath :)
import module namespace xpath = "http://exist.sourceforge.net/NS/exist";

(: Función principal para ejecutar las consultas :)
declare function local:ejecutar-consultas() {
    (: Obtener el documento XML :)
    let $doc := doc("xml/envio.xml")
    
    (: Ejecutar las consultas XPath del ejercicio 1 :)
    let $consulta1 := $doc/envio/poliza/asegurado[1],
        $consulta2 := $doc/envio/poliza/asegurado[1][count(garantia) > 2],
        $consulta3 := $doc/envio/poliza/asegurado[garantia/tipo = 'Dental'],
        $consulta4 := $doc/envio/poliza[@externa = 'S'],
        $consulta5 := $doc/envio/poliza/asegurado/garantia[@vigor = 'N'],
        $consulta6 := $doc/envio/poliza/asegurado/garantia[@vigor = 'S']/capital,
        $consulta7 := $doc/envio/poliza[count(asegurado) >= 2]/tomador,
        $consulta8 := $doc/envio/poliza/asegurado[starts-with(@nombre, 'J')],
        $consulta9 := sum($doc/envio/poliza/asegurado/garantia[@vigor = 'S']/capital),
        $consulta10 := $doc/envio/poliza[asegurado/garantia/capital = '80000']
    
    (: Retornar los resultados en un formato estructurado :)
    return <resultados>
        <consulta numero="1">
            <titulo>Primer asegurado de cada póliza</titulo>
            <resultado>{ $consulta1 }</resultado>
        </consulta>
        <consulta numero="2">
            <titulo>Primeros asegurados con más de dos garantías</titulo>
            <resultado>{ $consulta2 }</resultado>
        </consulta>
        <consulta numero="3">
            <titulo>Asegurados con garantía dental</titulo>
            <resultado>{ $consulta3 }</resultado>
        </consulta>
        <consulta numero="4">
            <titulo>Pólizas con indicador externa</titulo>
            <resultado>{ $consulta4 }</resultado>
        </consulta>
        <consulta numero="5">
            <titulo>Garantías con vigor=N</titulo>
            <resultado>{ $consulta5 }</resultado>
        </consulta>
        <consulta numero="6">
            <titulo>Capitales de garantías con vigor=S</titulo>
            <resultado>{ $consulta6 }</resultado>
        </consulta>
        <consulta numero="7">
            <titulo>Tomadores de pólizas con dos o más asegurados</titulo>
            <resultado>{ $consulta7 }</resultado>
        </consulta>
        <consulta numero="8">
            <titulo>Asegurados cuyo nombre empieza por J</titulo>
            <resultado>{ $consulta8 }</resultado>
        </consulta>
        <consulta numero="9">
            <titulo>Suma de capitales de garantías en vigor</titulo>
            <resultado>{ $consulta9 }</resultado>
        </consulta>
        <consulta numero="10">
            <titulo>Pólizas con garantía de 80000 euros</titulo>
            <resultado>{ $consulta10 }</resultado>
        </consulta>
    </resultados>
};

(: Ejecutar la función principal :)
local:ejecutar-consultas()