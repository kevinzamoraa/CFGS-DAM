(: Ejercicio 1: Consultas XPath en envio.xml :)
    (: 1. Obtener el primer asegurado de cada póliza: :)
       /envio/poliza/asegurado[1]
    (: 2. Seleccionar los primeros asegurados de las pólizas solo si tienen más de dos garantías contratadas: :)
       /envio/poliza/asegurado[1][count(garantia) > 2]
    (: 3. Seleccionar los asegurados que tengan contratada la garantía dental: :)
       /envio/poliza/asegurado[garantia/tipo = 'Dental']
    (: 4. Seleccionar las pólizas con el indicador externa: :)
       /envio/poliza[@externa = 'S']
    (: 5. Seleccionar todas las garantías que tienen el indicador vigor con valor 'N': :)
       /envio/poliza/asegurado/garantia[@vigor = 'N']
    (: 6. Seleccionar todos los capitales de garantías que tienen el indicador vigor = 'S': :)
       /envio/poliza/asegurado/garantia[@vigor = 'S']/capital
    (: 7. Seleccionar los tomadores de las pólizas, solo si la póliza tiene dos o más asegurados: :)
       /envio/poliza[count(asegurado) >= 2]/tomador
    (: 8. Seleccionar todos los asegurados cuyo nombre empieza por la letra 'J': :)
       /envio/poliza/asegurado[starts-with(@nombre, 'J')]
    (: 9. Obtener la suma de capitales de las garantías en vigor: :)
       sum(/envio/poliza/asegurado/garantia[@vigor = 'S']/capital)
    (: 10. Seleccionar las pólizas con alguna garantía cuyo capital sea de 80000 euros: :)
       /envio/poliza[asegurado/garantia/capital = '80000']
