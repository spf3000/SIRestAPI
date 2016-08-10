package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final String tbQueryStr=
        "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>" +
						"SELECT  ?z  WHERE {"+
						"<http://dbpedia.org/resource/Tony_Blair> dbpedia-owl:birthDate ?z ."+
						"}"   ;
    private static final String dcQueryStr = 
      "PREFIX dbprop: <http://dbpedia.org/property/>"+
						"SELECT  ?z  WHERE { "+
						"<http://dbpedia.org/resource/David_Cameron> dbprop:birthPlace ?z ."+
				" }"  ;
    	public SparqlQuery blair = new SparqlQuery();
    	public SparqlQuery cameron = new SparqlQuery();




    @RequestMapping("/greeting")
    	public String displayString(){
    	SparqlQuery dcQuery = new SparqlQuery();
		SparqlQuery tbQuery = new SparqlQuery();
		dcQuery.queryDBpedia(dcQueryStr);
		tbQuery.queryDBpedia(tbQueryStr);
		String dcAnswer =  dcQuery.getContent();
		String tbAnswer =  tbQuery.getContent();
		

		Age tbAge = new Age();
		String tbAgeStr = tbAge.splitDate(tbAnswer);
		int tonyAge = tbAge.calculateAge(tbAgeStr);
		

		Age dcBirth = new Age();
		String dcBirthStr = tbAge.splitDate(dcAnswer);	
		
		
		System.out.println("----------");
		
		String display = "David Cameron was born in " + dcBirthStr +
		  "; Tony Blair is " + tonyAge + " years old" ;
	//	System.out.println("David Cameron was born in " + dcBirthStr);	
//		System.out.println("Tony Blair is " + tonyAge + " years old");


/////////////////////////////////////
    	//	blair.queryDBpedia(tbQuery);
    	//	cameron.queryDBpedia(dcQuery);
    	//	String display = "Tony Blair was born " + blair.getContent() + "David Cameron was born in " + cameron.getContent();

    		return display;

    	}

}
