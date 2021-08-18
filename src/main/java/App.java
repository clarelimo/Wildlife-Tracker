import module.*;
import spark.ModelAndView;
import spark.QueryParamsMap;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animals-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animal");
            String rangerName = request.queryParams("ranger");
            String location = request.queryParams("location");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String type = request.queryParams("type");

            if(type.equals("animal")){
                Animal animal = new Animal(animalName);
                animal.save();
                Sighting newSighting = new Sighting(animal.getId(),location,rangerName);
                newSighting.save();
            } else if(type.equals("endangered")){
                EndangeredAnimal endangeredAnimal = new EndangeredAnimal(animalName,health,age);
                endangeredAnimal.save();
                Sighting anotherSighting = new Sighting(endangeredAnimal.getId(), location, rangerName);
                anotherSighting.save();
            }

            List<AllSightings> allSightings = AllSightings.getAll();
            List<EndangeredAnimal> animals= EndangeredAnimal.all();
            model.put("sightings", allSightings);
            model.put("animals", animals);

            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("sightings", AllSightings.getAll());
            model.put("animal", EndangeredAnimal.all());
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
