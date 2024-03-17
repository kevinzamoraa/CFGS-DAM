<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        
        <html>
            <head>
                <title>Lista de artistas por Kevin Zamora</title>  
                <style type="text/css">
                    .verde1{background-color:#82E0AA;}
                    .verde2{background-color:#D5F5E3;}                   
                    td{text-align: center;}
                    h2{color:#28B463; font-weight:bold; text-align:center;}
                    .averde1{color:#28B463;}
                </style>           
            </head>
            <body>
                <div style="float:left; position:absolute; width:100%;">
                    <h2>Lista de artistas por Kevin Zamora</h2>
                    <table border="1" align="center">                        
                
                        <tr class="verde1">
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>Año de nacimiento</th>
                            <th>Año de fallecimiento</th>
                            <th>Pais</th>
                            <th>Página web</th>                                             
                        </tr>    
                        <xsl:apply-templates select="./artistas/artista">
                            <xsl:sort select="nacimiento"> 
                            </xsl:sort>
                        </xsl:apply-templates>    
                                   
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="artista">
           
        <xsl:if test="./nacimiento>'1500'">           
            <tr class="verde2">
                <td>
                    <xsl:value-of select="@cod"/>
                </td>                
                <td>
                    <xsl:value-of select="nombreCompleto"/>
                </td>                
                <td>
                    <xsl:value-of select="nacimiento"/>
                </td>
                <td>
                    <xsl:value-of select="fallecimiento"/>
                </td>
                 <td>
                    <xsl:value-of select="pais"/>
                </td>
                <td>
                    <a class="averde1" target="blank">
                        <xsl:attribute name="href">
                            <xsl:value-of select="fichaCompleta"/>
                        </xsl:attribute>
                        Saber más                        
                    </a>
                </td> 
            </tr>      
        </xsl:if>    
    </xsl:template>
</xsl:stylesheet>