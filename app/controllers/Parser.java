package controllers;

import com.avaje.ebean.annotation.Transactional;
import com.fasterxml.jackson.databind.JsonNode;
import models.Person;
import play.data.Form;
import play.data.validation.Validation;
import play.libs.Json;
import play.mvc.*;


public class Parser extends Controller {

    private Validation validation;

    @BodyParser.Of(BodyParser.Json.class)
    public Result parse() {

        JsonNode body = request().body().asJson();


//        response().setContentType("application/json");

//        Form<Person> personForm = Form.form(Person.class);
//        Form<Person> persForm = personForm.bind(body);
//
//        if(persForm.hasErrors()) {
//            return ok("bad JSON");
//        }
//

        // bidings validation
        Person person = Json.fromJson(body, Person.class);

        // 1. Validate data
        person.save();

        // 1.1. If not valid pass error as JSON back
        // 1.2. if Valid process through to AKKA actors(?)

        return ok(person.toString());
    }

    @Transactional
    private boolean savePerson (Person p) {
        // more logic?
        p.save();
        return true;
    }


}