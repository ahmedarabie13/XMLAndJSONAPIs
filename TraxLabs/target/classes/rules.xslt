<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Person</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Number</th>
                        <th>Street</th>
                    </tr>
                    <xsl:for-each select="persons/person">
                        <tr>
                            <td>
                                <xsl:value-of select="name/firstname" />
                            </td>
                            <td>
                                <xsl:value-of select="name/lastname" />
                            </td>
                            <td>
                                <xsl:value-of select="address/number" />
                            </td>
                            <td>
                                <xsl:value-of select="address/street" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>