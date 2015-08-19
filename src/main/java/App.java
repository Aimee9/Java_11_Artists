import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/home.vtl");
      model.put("playlist", Artist.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/music", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Artist newArtist = new Artist(name);

      model.put("playlist", Artist.all());
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/:id", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();

    Artist name = Artist.find(Integer.parseInt(request.params(":id")));
    model.put("name", name);
    model.put("template", "templates/name.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());
   }


}
