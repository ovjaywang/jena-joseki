<?xml version="1.0" encoding="iso8859-1"?>

<!--

  XSLT script to format SPARQL Query Results XML Format as xhtml

  Copyright � 2004 World Wide Web Consortium, (Massachusetts
  Institute of Technology, European Research Consortium for
  Informatics and Mathematics, Keio University). All Rights
  Reserved. This work is distributed under the W3C� Software
  License [1] in the hope that it will be useful, but WITHOUT ANY
  WARRANTY; without even the implied warranty of MERCHANTABILITY or
  FITNESS FOR A PARTICULAR PURPOSE.

  [1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231

-->

<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns="http://www.w3.org/1999/xhtml"
  xmlns:res="http://www.w3.org/2005/06/sparqlResults"
  exclude-result-prefixes="res xsl">

  <!--
  <xsl:output
    method="html"
    media-type="text/html"
    doctype-public="-//W3C//DTD HTML 4.01 Transitional//EN"
    indent="yes"
    encoding="UTF-8"/>
  -->

  <!-- or this? -->

  <xsl:output
    method="xml" 
    indent="yes"
    encoding="UTF-8" 
    doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"
    doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
    omit-xml-declaration="no" />


  <xsl:template match="res:sparql">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <title>SPARQL Query Results to XHTML table (XSLT)</title>
  </head>
  <body>

    <h1>SPARQL Query Results to XHTML table (XSLT)</h1>

    <p>Ordered: <xsl:value-of select="res:results/@ordered"/></p>
    <p>Distinct: <xsl:value-of select="res:results/@distinct"/></p>

    <table border="1">
<xsl:text>
    </xsl:text>
<tr>
  <xsl:for-each select="res:head/res:variable">
    <th><xsl:value-of select="@name"/></th>
  </xsl:for-each>
</tr>
<xsl:text>
</xsl:text>

  <xsl:for-each select="res:results/res:result"> 
<xsl:text>
    </xsl:text>
<tr>
<xsl:text>
    </xsl:text>
    <xsl:call-template name="result" />
</tr>
<xsl:text>
    </xsl:text>
  </xsl:for-each>

    </table>


  </body>
</html>

  </xsl:template>


  <xsl:template name="result">
    <xsl:for-each select="res:binding"> 
     <xsl:variable name="name" select="@name" />
     <xsl:text>
      </xsl:text>
     <td>
        <xsl:comment>
          <xsl:text> </xsl:text>
          <xsl:value-of select="$name" />
          <xsl:text> </xsl:text>
	</xsl:comment>
          <xsl:text> </xsl:text>

	<xsl:choose>
	  <xsl:when test="res:bnode/text()">
	    <!-- blank node value -->
	    <xsl:text>nodeID </xsl:text>
	    <xsl:value-of select="res:bnode/text()"/>
	  </xsl:when>
	  <xsl:when test="res:uri">
	    <!-- URI value -->
	    <xsl:variable name="uri" select="res:uri/text()"/>
	    <xsl:text>URI </xsl:text>
	    <xsl:value-of select="$uri"/>
	  </xsl:when>
	  <xsl:when test="res:literal/@datatype">
	    <!-- datatyped literal value -->
	    <xsl:value-of select="res:literal/text()"/> (datatype <xsl:value-of select="res:literal/@datatype"/> )
	  </xsl:when>
	  <xsl:when test="res:literal/@xml:lang">
	    <!-- lang-string -->
	    <xsl:value-of select="res:literal/text()"/> @ <xsl:value-of select="res:literal/@xml:lang"/>
	  </xsl:when>
	  <xsl:when test="res:unbound">
	    <!-- unbound -->
	    [unbound]
	  </xsl:when>
	  <xsl:when test="string-length(res:literal/text()) != 0">
	    <!-- present and not empty -->
	    <xsl:value-of select="res:literal/text()"/>
	  </xsl:when>
	  <xsl:when test="string-length(res:literal/text()) = 0">
	    <!-- present and empty -->
            [empty literal]
	  </xsl:when>
	  <xsl:otherwise>
	    [unbound]
	  </xsl:otherwise>
	</xsl:choose>
     </td>
    <xsl:text>
</xsl:text>
    </xsl:for-each>
  </xsl:template>

</xsl:stylesheet>
