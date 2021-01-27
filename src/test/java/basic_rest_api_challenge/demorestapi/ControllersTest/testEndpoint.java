package basic_rest_api_challenge.demorestapi.ControllersTest;


import basic_rest_api_challenge.demorestapi.Models.Job;
import basic_rest_api_challenge.demorestapi.Models.Person;
import basic_rest_api_challenge.demorestapi.Repos.PersonRepository;
//import org.joda.time.LocalDate;
import basic_rest_api_challenge.demorestapi.Controllers.PersonController;
import basic_rest_api_challenge.demorestapi.Services.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.Mockito.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testEndpoint {
    private final Job job1 = new Job("CEO", 1000000);
    private final Job job2 = new Job("Salesperson", 25000);

//    private final Person person1 = new Person("Bob", (short) 35, LocalDate.parse("2011-01-01"), LocalDate.now(), job2);
//    private final Person person2 = new Person("Paul", (short) 25, LocalDate.parse("2016-01-01"), LocalDate.now(), job2);
//    private final Person person3 = new Person("Philip", (short) 65, LocalDate.parse("2001-01-01"), LocalDate.now(), job1);

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personDao;

    @Before
    public void setUp(){

    }

    @Test
    public void getPersonsEqual(){
        when(personDao.findAll()).thenReturn(Stream.of(
            new Person("Bob", (short) 35, LocalDate.parse("2011-01-01"), LocalDate.now(), job2),
            new Person("Paul", (short) 25, LocalDate.parse("2016-01-01"), LocalDate.now(), job2),
            new Person("Philip", (short) 65, LocalDate.parse("2001-01-01"), LocalDate.now(), job1)
        ).collect(Collectors.toList()));

        assertEquals(3, personService.getPersons().size());
    }

    @Test
    public void getPersonsNotEquals(){
        when(personDao.findAll()).thenReturn(Stream.of(
                new Person("Bob", (short) 35, LocalDate.parse("2011-01-01"), LocalDate.now(), job2),
                new Person("Paul", (short) 25, LocalDate.parse("2016-01-01"), LocalDate.now(), job2),
                new Person("Philip", (short) 65, LocalDate.parse("2001-01-01"), LocalDate.now(), job1)
        ).collect(Collectors.toList()));

        assertNotEquals(4, personService.getPersons().size());
        assertNotEquals(2, personService.getPersons().size());
        assertNotEquals(3.1, personService.getPersons().size());
        assertNotEquals(2.9, personService.getPersons().size());
    }

    @Test
    public void getPersonsByNameEquals(){
        String name = "Bob";
        when(personDao.findAllByName(name)).thenReturn(Stream.of(
                new Person("Bob", (short) 35, LocalDate.parse("2011-01-01"), LocalDate.now(), job2)
        ).collect(Collectors.toList()));

        assertEquals(1, personService.getPersonsByName(name).size());
        assertEquals("Bob", personService.getPersonsByName(name).get(0).getName());
        assertEquals(35, personService.getPersonsByName(name).get(0).getAge());
        assertEquals(LocalDate.parse("2011-01-01"), personService.getPersonsByName(name).get(0).getDateJoined());
        assertEquals(LocalDate.now(), personService.getPersonsByName(name).get(0).getDateUpdated());
        assertEquals(job2, personService.getPersonsByName(name).get(0).getJob());
    }

    @Test
    public void getPersonsByNameNotEquals(){
        String name = "Bob";
        when(personDao.findAllByName(name)).thenReturn(Stream.of(
                new Person("Bob", (short) 35, LocalDate.parse("2011-01-01"), LocalDate.now(), job2)
        ).collect(Collectors.toList()));

        assertNotEquals(2, personService.getPersonsByName(name).size());
        assertNotEquals("bob", personService.getPersonsByName(name).get(0).getName());
        assertNotEquals("boB", personService.getPersonsByName(name).get(0).getName());
        assertNotEquals("BOB", personService.getPersonsByName(name).get(0).getName());
        assertNotEquals("BoB", personService.getPersonsByName(name).get(0).getName());
        assertNotEquals(36, personService.getPersonsByName(name).get(0).getAge());
        assertNotEquals(34, personService.getPersonsByName(name).get(0).getAge());
        assertNotEquals(LocalDate.parse("2012-01-01"), personService.getPersonsByName(name).get(0).getDateJoined());
        assertNotEquals(LocalDate.parse("2011-02-01"), personService.getPersonsByName(name).get(0).getDateJoined());
        assertNotEquals(LocalDate.parse("2011-01-02"), personService.getPersonsByName(name).get(0).getDateJoined());
        assertNotEquals(LocalDate.now().plusDays(1), personService.getPersonsByName(name).get(0).getDateUpdated());
        assertNotEquals(LocalDate.now().minusDays(1), personService.getPersonsByName(name).get(0).getDateUpdated());
        assertNotEquals(job1, personService.getPersonsByName(name).get(0).getJob());


    }
}
