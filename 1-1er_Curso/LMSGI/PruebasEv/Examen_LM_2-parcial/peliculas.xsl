<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" />
<xsl:template match="/">
    <html>
        <head>
            <title>Ejercicio 3</title>
        </head>
        <body>
            <div class="container">
                <h2>Listado de artistas:</h2>
                <xsl:template match="pelicula">
                    <section>
                        <h2>
                            <xsl:value-of select="titulo">
                        </h2>
                        <p>
                            <xsl:value-of select="sinopsis">
                        </p>
                    </section>
                </xsl:template>
            </div>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>