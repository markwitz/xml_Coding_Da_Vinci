#XSLT
Mit Hilfe von XSLT werden Informationen aus einer XML-Datei in HTML
konvertiert und präsentiert.

##Transformation
Informationen zu den Teammitgliedern befinden sich in folgendem XML-Format:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:noNamespaceSchemaLocation="xml_member.xsd">
  <name>XML Coding Da Vinci</name>
  <description>Ein Bilder-Quiz als Projekt an der FU Berlin</description>
  <members>
    <member>
      <name>Paul Kunze</name>
      <degree>Master Student</degree>
      <university>Freie Universitaet Berlin</university>
    </member>

    <member>
      <name>Dennis Haegler</name>
      <degree>Master Student</degree>
      <university>Freie Universitaet Berlin</university>
    </member>

    <member>
      <name>Lucas Herich</name>
      <degree>Master Student</degree>
      <university>Freie Universitaet Berlin</university>
    </member>

    <member>
      <name>Adrian Zubarev</name>
      <degree>Bachelor Student</degree>
      <university>Freie Universitaet Berlin</university>
    </member>

    <member>
      <name>Christian Biermann</name>
      <degree>Bachelor Student</degree>
      <university>Freie Universitaet Berlin</university>
    </member>

    <member>
      <name>Jan Malte Markwitz</name>
      <degree>Bachelor Student</degree>
      <university>Freie Universitaet Berlin</university>
    </member>
  </members>
</project>
```

Damit HTML aus dem gegebenen XML Daten ausgeben kann, benötigen wir ein
XSLT-Template, welches wie folgt aussieht:

```xml
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
```

Wie in dem Template zu erkennen ist, werden Name, Abschluss und die Universität
des Studenten aus der XML ausgelesen und in HTML Tags verpackt. Diese HTML-Elemente besitzen neben den HTML-Tags auch CSS-Klassen.

##Verwendete Bibliothek
Um die Transformation von XML zu HTML zu gewährleisten, wurde auf die Ruby
Bibliothek [Nokogiri](http://www.nokogiri.org/) zugegriffen.
Installieren lässt sich Nokogiri mit folgendem Befehl:
```ruby
gem install nokogiri
```

Folgende Zeilen dienen der Transformation von XML zu HTML:
```ruby
@document = Nokogiri::XML(File.read('xml_member.xml'))
template = Nokogiri::XSLT(File.read('app/views/default/member.xslt'))
@member = template.transform(@document)
```
