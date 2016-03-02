package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;

import views.html.*;
import views.html.index;

public class Application extends Controller {

    public Result index() {
        return ok("Starting content");
    }

    public Result example() {
        JsonNode json = request().body().asJson();
        return ok(json.toString());
    }
}
