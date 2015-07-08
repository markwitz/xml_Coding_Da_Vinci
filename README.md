# xml_Coding_Da_Vinci
Repository zum studentischen XML-Projekt im Rahmen des Wettbewerbs "Coding Da Vinci".

##Project Idea
Unsere Projektidee ist ein interaktives Bilderquiz, bei dem ein Gemälde und eine Frage sowie vier Antworten dazu angezeigt werden. Die Frage bezieht sich zum Beispiel auf den Künstler, die Epoche, die eingesetzte Technik oder ein ähnliches Thema, das zu dem jeweiligen Gemälde gestellt werden kann. Bei der Auswahl einer Antwort werden anschließend alle falschen Antwortmöglichkeiten rot und die richtige grün eingefärbt. Außerdem werden weitere Zusatzinformationen über das Werk und den Künstler angezeigt. Die nächste Frage kann beantwortet werden, wenn man auf den entsprechenden Button klickt.

##How run the quiz locally
###Install Requirements
Damit das Projekt Lokal auf dem Rechner ausgeführt werden kann, benötigt das
System eine installierte Ruby-Version. Mit jeder installierten Ruby-Version
wird Rubygems mit installiert, welches das Installieren von externen
Bibliotheken ermöglicht, wie z.B. das Rails Framework, welches für dieses
Projekt verwendet wurde.
Das Projekt wurde mit der Ruby-Version 2.2.2 entwickelt.

####Install Ruby
Auf einigen Systemem, wie z.B. OSX, ist Ruby standardmäßig installiert.
Um Ruby zu installieren, benötigen wir den Ruby Versions Manager (RVM). Dieser
lässt sich mit dem folgendem Befehl installieren:

```ruby
gpg --keyserver hkp://keys.gnupg.net --recv-keys 409B6B1796C275462A1703113804BB82D39DC0E3
```

```ruby
\curl -sSL https://get.rvm.io | bash -s stable
```

Damit RVM problemlos funktioniert, benötigt es die shell als Login-Shell.
Mit dieser Einstellung kann mit folgendem Befehl Ruby mit der Version 2.2.2
installiert werden.
```ruby
rvm install 2.2.2
```
####Install Rails (via RubyGems)
Nach der Installation von Ruby kann mit folgendem Befehl das Rails Framework
installiert werden:
```ruby
gem install rails
```

####Install Dependencies
Damit das Projekt ausführbar ist, benötigt es alle Abhängigkeiten, die im
Gemfile definiert sind. Diese können manuell oder automatisch geladen werden.
Um die Abhängigkeiten automatisch zu laden, benutzen wir Bundler, was das
Maven (Java) für Ruby ist.

Rails ist ebenfalls eine externe Abhängigkeit und kann auf dem selben Weg
installiert werden.

Um die Abhängigkeiten zu installieren, muss einfach in das Projekt navigiert werden
und folgender Befehl ausgeführt werden.
```
cd <projekt-ordner>
```
```ruby
bundle install
```

####Run Project
Nachdem Ruby mit allen Abhängigkeiten installiert worden ist, kann mit dem
integrierten Webserver von Rails das Projekt gestartet werden.
```ruby
bundle exec rails server
```
Standardmäßig startet der Server auf Localhost mit dem Port 3000. Sollte dieser
Port schon vergeben sein, kann ein beliebiger Port mit dem `-p` Parameter
gesetzt werden:
```ruby
bundle exec rails server -p <port>
```

###Rest Api
Die Rest Api des Projektes hört auf folgende Schnittstellen:
`/member`, `member.xml` und `/quiz`.
Die URL auf localhost mit dem port 3000 sieht wie folgt aus:
```
localhost:3000/quiz
```

####Member
`/member` zeigt eine Tabelle der Teilnehmer an diesem Projekt an. Diese Tabelle
wurde mit `XSLT` generiert. Eine
[XML-Datei](https://github.com/markwitz/xml_Coding_Da_Vinci/blob/master/xml_member.xml)
aus allen Teilnehmner dient als Quelle. Diese Information können mit
`/member.xml` im Browser angezeigt werden.

####Quiz
`/quiz` zeigt ein simples Quiz an, welches aus
[XMl-Dateien](https://github.com/markwitz/xml_Coding_Da_Vinci/tree/master/config/open_data_xml)
aus OpenData stammen. Diese XML-Dateien wurden als zip heruntergeladen und in
dem Projekt als Datenquelle abgelegt.
Aus den XMLs werden folgenden Information mit Xpath rausextrahiert:
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

Ein Objekt mit herausgefilterten Information sieht wie folgt aus:
```ruby
{
  :flickr_link=>"https://flic.kr/p/rMBqoF",
  :fotograph=>"Berlinische Galerie - Landesmuseum für Moderne Kunst, Fotografie und Architektur (Berlin)",
  :actor_name=>"Walter Leistikow",
  :actor_role=>"Maler",
  :nationality=>"Deutschland",
  :material=>"Öl auf Holz",
  :title=>"Warnemünde", :date=>"1886"
}
```

#####QuizBuilder
Mit diesen Objekten wurde mit dem
[QuizBuilder](https://github.com/markwitz/xml_Coding_Da_Vinci/blob/master/lib/open_data/quiz_builder.rb)
ein Fragebogen zusammengestellt, der im Rahmen der Veranstaltung nach dem
Namen des Autors fragt.
Der Fragebogen bietet 4 Antwortmöglichkeiten. Der Nutzer kann eine Antwort
auswählen und anklicken. Nach dem Klicken färben sich die falschen Antworten rot
und die richtige Antwort grün.

###Verwendete Technologien
* REST API (RAILS)
* XSLT
* XPATH
* [SPARQL](https://github.com/markwitz/xml_Coding_Da_Vinci/blob/master/doc/sparql/Sparql.md)
* [BASEX](https://github.com/markwitz/xml_Coding_Da_Vinci/blob/master/doc/basex/ermittlung_der_kuenstlernamen.md)
