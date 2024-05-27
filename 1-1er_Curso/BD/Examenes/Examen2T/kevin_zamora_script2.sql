SELECT cod_pedido, fecha, servido,
    CASE
        WHEN fecha = SYSDATE AND servido = 1 THEN 'La fecha introducida no es correcta'
    ELSE 'La fecha introducida es correcta y anterior a la actual'
    END AS InfoFecha
FROM pedidos;

    