(: Modelo de las impresoras en red. :)
for $x in doc("impresoras.xml")/impresoras/impresora
where exists($x/enred)
return data($x/modelo)