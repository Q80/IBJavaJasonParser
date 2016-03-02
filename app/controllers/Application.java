package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Starting content"));
    }

    public Result example() {
        JsonNode json = request().body().asJson();
        return ok(index.render(json.toString()));

    }


}
