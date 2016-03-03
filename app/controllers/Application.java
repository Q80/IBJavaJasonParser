package controllers;

import play.mvc.*;
import views.html.index;


public class Application extends Controller {

    public Result index() {
        return ok(index.render("Starting Demo of JSON Parser"));
    }
}
