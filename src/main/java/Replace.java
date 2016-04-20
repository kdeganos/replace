import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.io.Console;
import java.util.regex.Pattern;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class Replace {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/input.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/output", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/output.vtl");

      Replace myReplace = new Replace();

      String inputtedPhrase = request.queryParams("phrase");
      String inputtedFind = request.queryParams("find");
      String inputtedReplaceWith = request.queryParams("replaceWith");

      String replacementResult = myReplace.findAndReplace(inputtedPhrase, inputtedFind, inputtedReplaceWith);
      model.put("result", replacementResult);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String findAndReplace(String phrase, String find, String replace){
    // return phrase.replace(find, replace);
    return phrase.replaceAll("(?i)"+Pattern.quote(find), replace);
  }
}
