import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.query.DatasetFactory;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.sparql.engine.http.QueryExceptionHTTP;

public class Sparql {

  public static void main(String[] args) throws IOException {
    ResultSet results = null;
    QueryExecution qe = null;
    List<String> strList= new ArrayList<String>();
    strList.add("Karl Hagemeister");
    strList.add("Carl Saltzmann");
    String str;
    String resultString = "hmm";
    String service = "http://de.dbpedia.org/sparql";

    for (int i = 0; i < strList.size(); i++) {
      str = strList.get(i);
      String queryString = "PREFIX foaf: <http://xmlns.com/foaf/0.1/> \n"+
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"+
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> \n"+
        "SELECT ?artist ?info ?birth ?death ?piclink \n" +
        "WHERE { \n"+
        "?artist foaf:name \""+str+"\"@de . "+
        "?artist rdfs:comment ?info. "+
        "?artist dbpedia-owl:birthDate ?birth. "+
        "?artist dbpedia-owl:deathDate ?death. "+
        "?artist dbpedia-owl:thumbnail ?piclink. "+
        "}";


      Query query = QueryFactory.create(queryString);
      qe = QueryExecutionFactory.sparqlService(service, query);
      results = qe.execSelect();
      BufferedWriter out = new BufferedWriter(new FileWriter(str+".xml"));
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
    };
  }
}
