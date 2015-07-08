#XPath
Das Ziel des Projektes ist ein Bilderrätzel (Quiz) aus Informationen von
XML-Dateien zu generien. Dazu wurden XML-Dateien aus
[offendedaten.de](https://offenedaten.de/) heruntergeladen und programatisch
ausgelesen. Um Informationen aus den XML zu gewinnen wird XPath genutzt.

##Informationen in XML

Eine XML-Datei aus offenedaten.de sieht wie folgt aus:
```xml
...
<lido:descriptiveMetadata xml:lang="deu">
    <lido:objectClassificationWrap>
        <lido:objectWorkTypeWrap>
            <lido:objectWorkType lido:type="Sachbegriff">
                <lido:term>Gemälde</lido:term>
                <lido:term lido:addedSearchTerm="yes">Gemälde</lido:term>
            </lido:objectWorkType>
        </lido:objectWorkTypeWrap>
        <lido:classificationWrap>
            <lido:classification lido:type="Gattung">
                <lido:term>Gemälde</lido:term>
                <lido:term lido:addedSearchTerm="yes">Malerei</lido:term>
            </lido:classification>
        </lido:classificationWrap>
    </lido:objectClassificationWrap>
    <lido:objectIdentificationWrap>
        <lido:titleWrap>
            <lido:titleSet>
                <lido:appellationValue lido:label="TitelProjekt">S.M.S "Prinz Adalbert"</lido:appellationValue>
                <lido:appellationValue lido:label="Titel2Pr-Adr.">Weltreise Prinz Heinrich von Preußen</lido:appellationValue>
            </lido:titleSet>
        </lido:titleWrap>
        <lido:inscriptionsWrap>
            <lido:inscriptions>
                <lido:inscriptionDescription>
                    <lido:sourceDescriptiveNote lido:label="Sign/Stempel">signiert und datiert unten rechts: "C. Saltzmann Jokohama 79"</lido:sourceDescriptiveNote>
                </lido:inscriptionDescription>
            </lido:inscriptions>
        </lido:inscriptionsWrap>
        <lido:repositoryWrap>
            <lido:repositorySet lido:type="current">
                <lido:repositoryName>
                    <lido:legalBodyName>
                        <lido:appellationValue>Berlinische Galerie - Landesmuseum für Moderne Kunst, Fotografie und Architektur (Berlin)</lido:appellationValue>
                    </lido:legalBodyName>
...
```

###Einlesen mit XPath
Die XPath Pfade wurde manuell ermittelt. Jeder Pfad der relevant ist für das
Bilderrätzel wurde in einem Ruby Objekt als Key-Value-Pair gespeichert:

```ruby
INFORMATION = {
  flickr_link: '//lido:linkResource',
  fotograph: '//lido:legalBodyName//lido:appellationValue',
  actor_name: '//lido:nameActorSet//lido:appellationValue',
  actor_role: '//lido:roleActor//lido:term',
  nationality: '//lido:nationalityActor//lido:term',
  material: '//lido:termMaterialsTech//lido:term',
  title: '//lido:titleSet//lido:appellationValue',
  date: '//lido:eventDate//lido:displayDate'
}
```

Dieses Objekt dient als Template für das Ergebnis. Jede XML-Datei wird in Form
eines Objektes, wie oben abgebildet, dargestellt, nur mit den Informationen als
Value, anstelle der Path-Pfade. Der komplette Source code zu der
Informationsgewinnung mit XPath befindet sich im
[OpenData::Parser](https://github.com/markwitz/xml_Coding_Da_Vinci/blob/master/lib/open_data/parser.rb)
