## Ermittlung der Künstlernamen (mit BaseX / XQuery)


Es folgen nun die vereinfachten Schritte, die zur Ermittlung der einzlenen Künstlernamen mit den BaseX und XQuery Technologien notwendig gewesen sind.

---

1. Man lädt auf der [BaseX-Webseite] das .Jar-File herunter.
2. Das heruntergeladene .Jar-File starten. Es sollte sich dann eine GUI-Applikation starten.
3. Die Sammlung der XML-Dateien in einen Ordner ablegen.
4. In der gesterteten BaseX Applikation den im **Schritt 3** genannten Ordner als Datenbank öffnen. Alle darin enthaltenen XML-Dateien werden durch die Applikation in eine zur Laufzeit generierten Datenbank hinzugefügt.
5. Links von dem oberen Eingabefeld stellt man im Dropdown-Menü auf "XQuery" um.
6. Man gibt nun in das rechts von dem Dropdown-Menü liegende Feld den folgeden Code ein, welcher vollständig in eine Zeile geschrieben werden sollte:

		1| declare namespace lido="http://www.lido-schema.org"; 
		2|
		3| for $actor in distinct-values(//lido:actor/lido:nameActorSet/lido:appellationValue/text())
		4| return $actor
	In Zeile 1 wird der Namespace der BaseX Applikation mitgeteilt. Dies ist notwending damit die Applikation XQuery sowie XPath auf der Datenbank ausführen kann.
	
	Der Vorteil an BaseX ist, dass die erstellte Datenbank in mehrere einzelene Blöcke geteilt ist. Damit kann man wie in Zeile 3 gleich beim **actor** Block beginnen.
	
	Man erhält also durch die nachfolgende Baumstruktur die Namen der Künstler und die **distinct-values()** Funktion sorgt dafür, dass keine Duplikate ausgegeben werden.
	
		actor
		  |--- nameActorSet
		            |--- appellationValue // text() Funktion wird an diesem Knoten ausgeführt, damit man dessen Wert zurückbekommt.
		            
	Durch die Zeile 4 werden schließlich die disjunkten Ergebnisse für den Benutzer ausgegeben.
	
7. Das Ergeniss schaut wie folgt aus (ohne der Kopfzeile): 

	Künstler (1 - 9 / 18)  | Künstler (9 - 18 / 18)
	------------- | --------------
	Walter Leistikow | Konrad Alexander Müller-Kurzwelly |
	Hermann Eschke | Karl Hagemeister |
	Carl Saltzmann | Gerhard Geidel |
	Max Liebermann | Julie Wolfthorn |
	George Mosson | August Gaul |
	Ulrich Hübner | Anton von Werner |
	Hans Herrmann | Adolph von Menzel |
	Franz Skarbina | Carl Kayser-Eichberg |
	Lesser Ury | Elisabeth von Eicken |
	
	Damit wurden 71 Ergebnisse auf 18 reduziert.
	
--

##### Fazit nach der Bearbeitung dieser Aufgabenstellung

Die größte Schwierigkeit bestand darin, zu verstehen wie man richtig mit dem *Namespace* umgeht und die korrekte URL für das 'lido' Namespace findet. 

--
	 
[BaseX-Webseite]:http://basex.org/products/download/all-downloads/


