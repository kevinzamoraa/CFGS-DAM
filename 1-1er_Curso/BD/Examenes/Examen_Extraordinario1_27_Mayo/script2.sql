CREATE TABLE coordinadores OF coordinador;
SELECT nivel_academico,
CASE 
    WHEN nivel_academico = 'Doctorado' OR nivel_academico = 'Ingeniero Superior'
    THEN
        INSERT INTO coordinadores VALUES (1, '1234', 'Nombre', 'Apellidos', '', '', '', 12345, '', 'Doctorado');
        'Usuario introducido con éxito'
    ELSE
        'El usuario introducido no puede convertirse en coordinador';
END AS estadoCoordinador
FROM coordinador;
