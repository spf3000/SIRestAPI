package hello;


import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;

public class SparqlQuery {

    private  String content;

    public SparqlQuery() {
        this.content = "no answer";
            }

    public String getContent() {
        return content;
    }
public void queryDBpedia(String queryText){
            Query query = QueryFactory.create(queryText);
            // initializing queryExecution factory with remote service.
            QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);

                ResultSet results = qexec.execSelect();

               if(results.hasNext()){
                  this.content = results.next().toString();
               }
           qexec.close();

}
}



