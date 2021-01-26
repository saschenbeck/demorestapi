package basic_rest_api_challenge.demorestapi.ControllersTest;


import basic_rest_api_challenge.demorestapi.Models.Job;
import basic_rest_api_challenge.demorestapi.Models.Person;
import basic_rest_api_challenge.demorestapi.Repos.PersonRepository;
//import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;
public class testPersonController {
    private final Job job1 = new Job("CEO", 1000000);
    private final Job job2 = new Job("Salesperson", 25000);

    private final Person person1 = new Person("Bob", (short) 35, LocalDate.parse("2011-01-01"), LocalDate.now(), job2);
    private final Person person2 = new Person("Paul", (short) 25, LocalDate.parse("2016-01-01"), LocalDate.now(), job2);
    private final Person person3 = new Person("Philip", (short) 65, LocalDate.parse("2001-01-01"), LocalDate.now(), job1);

    @Before
    public void setUp(){

    }
}
