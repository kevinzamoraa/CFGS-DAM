(: Título y autor :)
for $x in doc("obras.xml")/obras/obra
where $x[@pais="Francia"]
return <li>{data($x/museo)}</li>