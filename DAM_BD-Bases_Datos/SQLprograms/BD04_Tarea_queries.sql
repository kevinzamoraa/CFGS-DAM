-- Conectamos como administradores con conn sys as sysdba
conn sys as sysdba

// Ej. 1
select nombre, salario from empleado where salario > 985 and comision > 5;

// Ej. 2
select codemple, coddpto, nombre, salario, comision from empleado 
where (salario + comision) > 1350 group by coddpto order by asc;
    //salario = salario * 165;
    
// Ej. 3
select nombre, ape1, ape2, fechaingreso order by asc;

// Ej. 4
select nombre from empleado where coddpto in ( select denominacion from dpto 
where presupuesto between 40000 and 60000 );

// Ej. 5
select nombre from empleado where salario < ( select salario from empleado 
where (coddpto = 01 and salario < (select salario from empleado 
where coddpto = 01)));

// Ej. 6
select nombre from empleado where coddpto = ( select coddpto from dpto 
where codemplejefe = 1 );

// Ej. 7
// select nombre from empleado where ape1 like ('P%' or 'Q%' or 'R%' or 'S%)';
// PD: No sé si me dará tiempo a mirarlo y estudiarlo con detalle, 
// para así descubrir cuál resulta la función y el procedimiento en sql, 
// para poder extraer y comparar sólo la primera letra de cada 'primer apellido'
// PD2: Tampoco sé si la solución dada dará buen resultado al ejercicio, 
// debido a que no me resulta posible probar las presentes consultas;
// Me marca error en el primer operador 'or'

// Ej. 8
select nombre from empleado where localidad = ( select localidad from centro );

// Ej. 9
select nombre, salario from empleado 
where (salario * 0.60) > ( select max(salario) from empleado );

// Ej. 10
select nombre, ape1, ape2 from empleado 
where salario = ( select max(salario) from empleado );

// Ej. 11
select count(empleado), localidad where count(empleado) > 3;
// Nota: Me marca error en el ";"

// Ej. 12
select coddpto, denominacion from dpto 
where codcentro = (select codcentro, direccion, localidad from centro);
// No acabo de ver cómo extraer la información del segundo objeto del interior 
// de la tabla centro y seguramente, de la forma en la que lo he desarrollado 
// nos daría conflicto al comparar dos valores que son dispares e incompatibles 
// en cuanto a tipos

// Ej. 13
select coddpto, denominacion from dpto where coddptodepende = null;

// Ej. 14
select coddpto, denominacion from dpto 
where ((select count(empleado) from empleado) = 
(select max(empleado) from empleado));

// Ej. 15
select nombre, ape1 from empleado 
where coddpto = ( select coddpto, denominacion from dpto );
// Idea usando la función 'join' -> marca error en el operador de la función:
// select nombre, ape1, coddpto, denominacion from empleado where coddpto = 
// ( select coddpto from dpto ) join dpto using(denominacion) ;
// Agradecería que pudieras explicarme cómo realizarlo aunque fuera brevemente
// Idea que marca error al final de la linea: 
// select nombre, ape1 from empleado where coddpto = (select coddpto from dpto) 
// and (select coddpto, denominacion from dpto) ;
// Tampoco sé ni creo que pueda funcionar la comparación de los dos coddpto sin 
// borrar la variable denominacion, aunque sin poder probarlo y sin demasiado 
// tiempo restante para investigarlo, esta resulta la opción que se me ha 
// ocurrido de primeras. Agradecería que pudieras explicarme mejor la forma 
// 'correcta' y más adecuada de concatenar varias búsquedas con parámetros 
// a mostrar

// Ej. 16
select nombre from empleado order by asc;
// Idea: select nombre, if(comision!=null) as mensaje = "tiene comisión" else 
// mensaje = "no tiene comisión" from empleado order by asc;
// PD: Me da error en el igual, aunque desconozco cómo solucionarlo. 
// Y respecto a cómo añadir los respectivos 'string's, también desconozco 
// si sería de esa forma y/o con las presentes comillas dobles
// No me acabo de aclarar para concatenar el 'if' y poder añadir la condición 
// con el correspondiente mensaje, según tenga o no tenga comisión el empleado 
// en cuestión

// Ej. 17
select localidad from centro 
where localidad != (select localidad from empleado) order by asc;

// Ej. 18
select nombre, ape1, ape2 from empleado 
where codemple != (select codemplejefe from dpto);

// Ej. 19
select nombre, fechaingreso, current_date if((current_date-fechaingreso) < 6) 
as gratificacion = 100 
else if((current_date-fechaingreso) between 6 and 10) 
as gratificacion = 50*(current_date-fechaingreso)) 
else if((current_date-fechaingreso) between 11 and 20) 
as gratificacion = 70*(current_date-fechaingreso)) 
else if((current_date-fechaingreso) > 21) 
as gratificacion = 100*(current_date-fechaingreso))from empleado;
// PD: No sé si funcionará debido a que me muestra un error entre el primer 
// 'if' y su primer parentesi consiguiente. 
// Te agradecería enormemente si pudieras mandarme un 'feedback' acerca de 
// cómo entender y mejorar los errores y difucultades 
// comentadas/encontradas
