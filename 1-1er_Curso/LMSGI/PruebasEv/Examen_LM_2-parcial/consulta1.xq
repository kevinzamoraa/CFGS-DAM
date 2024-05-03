(: Título y autor :)
for $x in doc("obras.xml")/obras/obra
return <obra>{($x/titulo, $x/autor)}</obra>