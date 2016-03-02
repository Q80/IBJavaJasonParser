package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Person;
import play.libs.Json;
import play.mvc.*;


public class Parser extends Controller {

    @BodyParser.Of(BodyParser.Json.class)
    public Result parse() {

        JsonNode body = request().body().asJson();

        Person person = Json.fromJson(body, Person.class);

//        response().setContentType("application/json");

        return ok("Last name " + person.lastName + ", First name " + person.firstName);
    }
}