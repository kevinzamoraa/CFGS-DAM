// Ej. 1
select nombre, salario from empleado where salario > 985 and comision > 5;
// Ej. 2
select codemple, coddpto, nombre, salario, comision from empleado
where (salario + comision) > 1350 group by coddpto order by asc;
//La dos la tienes mal porque te pide que la ordenes primero por codigo de departamento y despues por nombre, no que la agupes, quedar�a as�:
select codemple, coddpto, nombre, salario, comision from empleado
where (salario + comision) > 1350 order by coddpto, nombre asc;
//salario = salario * 165;

// Ej. 3
select nombre, ape1, ape2, fechaingreso order by asc;
//En esta tendr�as que calcular la fecha de nacimiento usando la fecha del ordenador - la fecha de ingreso y despu�s le pones un al�as al campo
SELECT nombre, ape1, ape2, FLOOR ((SYSDATE - fechaingreso)/365) AS A�osAntiguedad
FROM empleado
ORDER BY A�osAntiguedad DESC;

// Ej. 4
select nombre from empleado where coddpto in ( select denominacion from dpto
where presupuesto between 40000 and 60000 );
//Aqu� habr�a que hacer una subconsulta buscando el codigo departamento en la tabla dpto
SELECT nombre, ape1, ape2
FROM empleado
WHERE coddpto IN (SELECT coddpto
                FROM dpto
                WHERE presupuesto > 50000 AND presupuesto < 60000);

// Ej. 5
select nombre from empleado where salario < ( select salario from empleado
where (coddpto = 01 and salario < (select salario from empleado
where coddpto = 01)));
//En esta te has l�ado un poco pero ibas bien encaminado
SELECT nombre, ape1, ape2
FROM empleado
WHERE salario < (SELECT MIN (salario)
                FROM empleado
                WHERE coddpto IN 01)
ORDER BY nombre;


// Ej. 6
select nombre from empleado where coddpto = ( select coddpto from dpto
where codemplejefe = 1 );

// Ej. 7
select nombre from empleado where ape1 like 'P%' or ape1 like 'Q%' or ape1 like 'R%' or ape1 like 'S%';
//Te ha faltado a�adir el ape1 en todas las comparaciones

// PD: No s� si me dar� tiempo a mirarlo y estudiarlo con detalle,
// para as� descubrir cu�l resulta la funci�n y el procedimiento en sql,
// para poder extraer y comparar s�lo la primera letra de cada 'primer apellido'
// PD2: Tampoco s� si la soluci�n dada dar� buen resultado al ejercicio,
// debido a que no me resulta posible probar las presentes consultas;
// Me marca error en el primer operador 'or'
// Ej. 8
select nombre from empleado where UPPER (localidad) in ( select upper (localidad) from centro );
//Aqu� cambiando el igual por el in ya lo tendr�as, el igual es cuando la subconsulta te devuelve una fila y el in cuando te devuelve m�s de una
//Como en una tabla los datos est�n en may�sculas y en otra no habr�a que poner los resultados en may�sculas


// Ej. 9
select nombre, salario from empleado
where (salario ) > 0.60*( select max(salario) from empleado );
//Aqu� tienes que multiplicar el 0.60 por el salario max

// Ej. 10
select nombre, ape1, ape2 from empleado
where salario = ( select max(salario) from empleado );

// Ej. 11
select count(empleado), localidad where count(empleado) > 3;
//Aqu� tienes que hacer una agrupacion por localidad y coger los que son mas de 3
SELECT DISTINCT(localidad), COUNT(codemple)
FROM empleado
GROUP BY localidad
HAVING COUNT (*) > 3;

// Nota: Me marca error en el ";"

// Ej. 12
select coddpto, denominacion from dpto
where codcentro = (select codcentro, direccion, localidad from centro);
//Aqu� habr�a que hacer un join que cogiera los centros que tienen departamento y los que no
//Aqu� se ve muy visual https://learnsql.es/blog/explicacion-de-los-tipos-de-join-en-sql/
SELECT centro.*, dpto.denominacion
FROM centro
LEFT JOIN dpto ON centro.codcentro = dpto.codcentro;

// No acabo de ver c�mo extraer la informaci�n del segundo objeto del interior
// de la tabla centro y seguramente, de la forma en la que lo he desarrollado
// nos dar�a conflicto al comparar dos valores que son dispares e incompatibles
// en cuanto a tipos

// Ej. 13
select coddpto, denominacion from dpto where coddptodepende = null;
//No tienes que utilizar el igual ya que no comparas tienes que poner el "is"

// Ej. 14
select coddpto, denominacion from dpto
where ((select count(empleado) from empleado) =
(select max(empleado) from empleado));


// Ej. 15
select nombre, ape1 from empleado
where coddpto = ( select coddpto, denominacion from dpto );
// Idea usando la funci�n 'join' -> marca error en el operador de la funci�n:
// select nombre, ape1, coddpto, denominacion from empleado where coddpto =
// ( select coddpto from dpto ) join dpto using(denominacion) ;
// Agradecer�a que pudieras explicarme c�mo realizarlo aunque fuera brevemente
// Idea que marca error al final de la linea:
// select nombre, ape1 from empleado where coddpto = (select coddpto from dpto)
// and (select coddpto, denominacion from dpto) ;
// Tampoco s� ni creo que pueda funcionar la comparaci�n de los dos coddpto sin
// borrar la variable denominacion, aunque sin poder probarlo y sin demasiado
// tiempo restante para investigarlo, esta resulta la opci�n que se me ha
// ocurrido de primeras. Agradecer�a que pudieras explicarme mejor la forma
// 'correcta' y m�s adecuada de concatenar varias b�squedas con par�metros
// a mostrar
//M�s arriba te he dejado una p�gina donde explica el JOIN, tienes que buscar los que coincidan
SELECT dpto.denominacion, empleado.nombre
FROM dpto
LEFT JOIN empleado ON empleado.coddpto = dpto.coddpto;

// Ej. 16
select nombre from empleado order by asc;
//Habr�a que utilizar el case 
SELECT nombre,
    CASE
      WHEN comision IS NOT NULL THEN 'Tiene comisi�n'
      ELSE 'No tiene comisi�n'
      END AS InfoComision
FROM empleado
ORDER BY nombre;

// Idea: select nombre, if(comision!=null) as mensaje = "tiene comisi�n" else
// mensaje = "no tiene comisi�n" from empleado order by asc;
// PD: Me da error en el igual, aunque desconozco c�mo solucionarlo.
// Y respecto a c�mo a�adir los respectivos 'string's, tambi�n desconozco
// si ser�a de esa forma y/o con las presentes comillas dobles
// No me acabo de aclarar para concatenar el 'if' y poder a�adir la condici�n
// con el correspondiente mensaje, seg�n tenga o no tenga comisi�n el empleado
// en cuesti�n



// Ej. 17
select localidad from centro
where localidad != (select localidad from empleado) order by asc;
//Aqu� tambien tienes que hacer una subconsulta ya que tienes que buscar las localidades que no tienen empleados
SELECT DISTINCT (centro.localidad)
FROM centro
WHERE centro.localidad IN (SELECT localidad
                            FROM empleado)
ORDER BY centro.localidad;


// Ej. 18
select nombre, ape1, ape2 from empleado
where codemple not in (select codemplejefe from dpto);
//!= no valdr�a porque tienes m�s de un resultado, habr�a que poner not in

// Ej. 19
select nombre, fechaingreso, current_date if((current_date-fechaingreso) < 6)
as gratificacion = 100
else if((current_date-fechaingreso) between 6 and 10)
as gratificacion = 50*(current_date-fechaingreso))
else if((current_date-fechaingreso) between 11 and 20)
as gratificacion = 70*(current_date-fechaingreso))
else if((current_date-fechaingreso) > 21)
as gratificacion = 100*(current_date-fechaingreso))from empleado;

//En SQL, se utiliza la estructura CASE WHEN para realizar operaciones condicionales en lugar del condicional IF