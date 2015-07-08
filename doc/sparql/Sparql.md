# SPARQL

------------

Wir benutzen SPARQL, um zusätzliche Infos zu den Künstlern der Bilder abzurufen. Diese Daten werden von http://de.dbpedia.org/sparql abgefragt. Wir nutzen dazu die Bibliotheken von Apache Jena für Java.
Die Künstlernamen wurden zuvor mittels XPath aus den XML-Dateien von OpenData herausgesucht.


Zuerst wurde eine Liste mit den Namen angelegt.

```java
    List<String> strList= new ArrayList<String>();
    /* names */

    strList.add("Walter Leistikow");
    strList.add("Hermann Eschke");
    strList.add("Carl Saltzmann");
    strList.add("Max Liebermann");
    strList.add("Franz Skarbina");
    strList.add("Lesser Ury");
    strList.add("Konrad Alexander Müller-Kurzwelly");
    strList.add("Karl Hagemeister");
    strList.add("Julie Wolfthorn");
    strList.add("August Gaul");
    strList.add("Anton von Werner");
    strList.add("Adolph von Menzel");
    strList.add("Carl Kayser-Eichberg");
    strList.add("Gerhard Geidel");
    strList.add("Elisabeth von Eicken");

    /* ********* */
```
Für diese Namen wurden dann Abfragen nach dem Namen, zusätzlichen Infos, dem Geburtstag, dem Todestag und falls vorhanden dem Bildlink vom Künstler ausgeführt.
Diese Ergebnisse wurden dann für jeden Künstler in eine eigene XML gepackt.

```java
     for (int i = 0; i < strList.size(); i++) {

      str = strList.get(i);
      String queryString = "PREFIX foaf: <http://xmlns.com/foaf/0.1/> \n"+
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"+
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> \n"+
        "PREFIX dc:	<http://purl.org/dc/elements/1.1/> \n"+
        "SELECT DISTINCT ?artist ?info ?birth ?death ?piclink \n" +
        "WHERE { \n"+
        "?artist foaf:name \""+str+"\"@de . "+
        "?artist rdfs:comment ?info . "+
        "?artist dbpedia-owl:birthDate ?birth. "+
        "?artist dbpedia-owl:deathDate ?death. "+
        "OPTIONAL {?artist dbpedia-owl:thumbnail ?piclink} "+
        "}";

      Query query = QueryFactory.create(queryString);
      qe = QueryExecutionFactory.sparqlService(service, query);
      results = qe.execSelect();
      BufferedWriter out = new BufferedWriter(new FileWriter(str.toLowerCase().replaceAll(" ", "_") + ".xml"));
      try{
        resultString = ResultSetFormatter.asXMLString(results);
        System.out.println(resultString);
        out.write(resultString);
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        qe.close();
        out.close();
      }
    }
```

Nun musste für einen Namen eine neue Abfrage vorgenommen werden, da dieser keinen Eintrag für rdfs:comment hatte und deshalb dc:description benutzt werden musste.

```java
    strList.clear();
    strList.add("George Mosson");
    //names with dc:description instead of rdfs:comment

    for (int i = 0; i < strList.size(); i++) {
        str = strList.get(i);
        String queryString = "PREFIX foaf: <http://xmlns.com/foaf/0.1/> \n"+
          "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"+
          "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> \n"+
          "PREFIX dc:	<http://purl.org/dc/elements/1.1/> \n"+
          "SELECT DISTINCT ?artist ?info ?birth ?death ?piclink \n" +
          "WHERE { \n"+
          "?artist foaf:name \""+str+"\"@de . "+
          "?artist dc:description ?info . "+
          "?artist dbpedia-owl:birthDate ?birth. "+
          "?artist dbpedia-owl:deathDate ?death. "+
          "OPTIONAL {?artist dbpedia-owl:thumbnail ?piclink} "+
          "}";
```
 Es gab noch 2 weitere Künstler, deren Namen aber mehrfach in dbpedia vorhanden waren. Für diese wurde der Bildlink als Pflicht genommen, um hier andere Personen zu entfernen. Dabei hatte der Eintrag für den zweiten Künstler in dbpedia keine Informationen.

```java
    strList.clear();
    strList.add("Ulrich Hübner");
    strList.add("Hans Herrmann"); // no result
    //names with more entries in dbpedia

    for (int i = 0; i < strList.size(); i++) {
        str = strList.get(i);
        String queryString = "PREFIX foaf: <http://xmlns.com/foaf/0.1/> \n"+
          "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"+
          "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> \n"+
          "PREFIX dc:	<http://purl.org/dc/elements/1.1/> \n"+
          "SELECT DISTINCT ?artist ?info ?birth ?death ?piclink \n" +
          "WHERE { \n"+
          "?artist foaf:name \""+str+"\"@de . "+
          "?artist rdfs:comment ?info . "+
          "?artist dbpedia-owl:birthDate ?birth. "+
          "?artist dbpedia-owl:deathDate ?death. "+
          "?artist dbpedia-owl:thumbnail ?piclink "+
          "}";
```

Die so erhaltenen XML-Dateien sehen dann wie folgt aus:

```xml
    <?xml version="1.0"?>
	<sparql xmlns="http://www.w3.org/2005/sparql-results#">
 	<head>
    <variable name="artist"/>
    <variable name="info"/>
    <variable name="birth"/>
    <variable name="death"/>
    <variable name="piclink"/>
 	</head>
  	<results>
    <result>
      <binding name="artist">
        <uri>http://de.dbpedia.org/resource/Adolph_von_Menzel</uri>
      </binding>
      <binding name="info">
        <literal xml:lang="de">Adolph Friedrich Erdmann von Menzel (* 8. Dezember 1815 in Breslau; † 9. Februar 1905 in Berlin), geadelt 1898, war Maler, Zeichner und Illustrator. Er gilt als der bedeutendste deutsche Realist des 19. Jahrhunderts. Sein Werk ist außerordentlich vielfältig; bekannt und zu Lebzeiten hoch geehrt wurde er vor allem durch seine historisierenden Darstellungen aus dem Leben Friedrichs des Großen.</literal>
      </binding>
      <binding name="birth">
        <literal datatype="http://www.w3.org/2001/XMLSchema#date">1815-12-08Z</literal>
      </binding>
      <binding name="death">
        <literal datatype="http://www.w3.org/2001/XMLSchema#date">1905-02-09Z</literal>
      </binding>
      <binding name="piclink">
        <uri>http://commons.wikimedia.org/wiki/Special:FilePath/Bundesarchiv_Bild_183-R30367,_Adolph_von_Menzel.jpg?width=300</uri>
      </binding>
    </result>
  </results>
</sparql>
```

Die ausführbare `Jar` Datei liegt im java-Ordner.
```sh
cd java/
```
```sh
java -jar sparql.jar
```
