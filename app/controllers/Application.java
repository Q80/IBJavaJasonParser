package controllers;

import models.Person;
import play.mvc.*;
import views.html.*;


public class Application extends Controller {

    public Result index() {
        return ok(index.render("Starting Demo of JSON Parser"));
    }

    public Result listPersons() {
        return ok(listAll.render(Person.find.all()));
    }
}
