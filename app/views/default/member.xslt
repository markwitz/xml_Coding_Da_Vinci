<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" indent="yes"/>

  <xsl:template match="project">
    <h2 class='headline'>
      <xsl:value-of select="name" />
    </h2>
    <xsl:apply-templates select="members"/>
  </xsl:template>

  <xsl:template match="members">
    <table class='members table table-bordered'>
      <tr>
        <th>Name</th>
        <th>Degree</th>
        <th>University</th>
      </tr>
      <xsl:apply-templates select="member"/>
    </table>
  </xsl:template>

  <xsl:template match="member">
    <tr class='member'>
      <td class='name'>
        <xsl:value-of select="name" />
      </td>
      <td class='degree'>
        <xsl:value-of select="degree" />
      </td>
      <td class='university'>
        <xsl:value-of select="university" />
      </td>
    </tr>
  </xsl:template>
</xsl:stylesheet>
