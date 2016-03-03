package models;


import com.avaje.ebean.Model;

import org.hibernate.validator.constraints.NotEmpty;
import play.data.validation.Constraints;

/* in case we want to validate using Spring
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
*/
import javax.persistence.*;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

@Entity
public class Person extends Model implements Validator {


    @Id
    public Long id;

    @Constraints.Required
    public String firstName;

    public String lastName;

    @Constraints.Min(10)
    public int age;

    /// Convenient constructor
    public Person(String fName, String lName, int a) {
        firstName = fName;
        lastName = lName;
        age = a;
    }

    /**
     *
     */
    public static Finder<Long, Person> find = new Finder<Long, Person>(Person.class);

    @Override
    public String toString() {
        return "Person id #" + id + ": " + lastName + ", " + firstName + " " + age + " yrs old.";
    }

    /**
     * Created by Vahid Moradi on 03/03/16.
     */
    /*
     Inner class in charge of validating Person using Spring Validation

    public static class PersonValidator implements Validator {

        public boolean supports(Class clazz) {
            return Person.class.equals(clazz);
        }

        public void validate(Object obj, Errors e) {
            ValidationUtils.rejectIfEmpty(e, "name", "name.empty");

            Person p = (Person) obj;

            if (p.getAge() < 0) {
                e.rejectValue("age", "negative age");
            }
            if (p.firstName.isEmpty() || p.firstName.contains("1234567890")) {
                e.rejectValue("firstName", "There is no first name");
            }
            if (p.lastName.isEmpty()) {
                e.rejectValue("lastName", "There is no last name");
            }
        }
    }
    */
}