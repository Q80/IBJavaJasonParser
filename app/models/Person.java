package models;


import com.avaje.ebean.Model;

import javax.persistence.*;

@Entity
public class Person extends Model {
    @Id
    public Long id;
    public String firstName;
    public String lastName;
    public int age;
}