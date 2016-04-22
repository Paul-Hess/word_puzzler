import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/puzzle", (request, response) -> {
    	Map<String, Object> model = new HashMap<String, Object>();

    	WordPuzzle newWordPuzzle = new WordPuzzle();
    	String phrase = request.queryParams("phrase");
    	String newPuzzle = newWordPuzzle.generatePuzzle(phrase);
			request.session().attribute("phrase", phrase);

    	model.put("newPuzzle", newPuzzle);
			model.put("template", "templates/puzzle.vtl");
    	return new ModelAndView(model, layout); 
    }, new VelocityTemplateEngine());


    get("/solve", (request, response) -> { 
    	Map<String, Object> model = new HashMap<String, Object>();
    	WordPuzzle newWordPuzzle = new WordPuzzle();
    	String solving = request.queryParams("solving");
    	String phrase = request.session().attribute("phrase");

    	boolean isSolved = newWordPuzzle.parseWin(phrase, solving);

    
    	System.out.println(phrase);
    	model.put("solved", solving);
    	model.put("isSolved", isSolved);

    	model.put("template", "templates/solve.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}