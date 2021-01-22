package basic_rest_api_challenge.demorestapi.ModelsTest;
import basic_rest_api_challenge.demorestapi.Models.Person;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
public class testPerson {
    private final Person person = new Person();

    @Before
    public void setUp(){
        this.person.setName("Bob");
        this.person.setAge((byte) 35);
        this.person.setDateJoined(LocalDate.parse("2011-02-01"));
        this.person.setDateUpdated(LocalDate.now());
    }

    @Test
    public void testIfPersonIsNotNull(){
        assertNotNull(person);
    }

    @Test
    public void testIfPersonNameEquals(){
        String actual = person.getName();
        String expected = "Bob";

        assertEquals(expected, actual);
    }

    @Test
    public void testIfNameNotEquals(){
        String actual = person.getName();
        List<String> names = new ArrayList<>();
        names.add("Paul");
        names.add("Joe");
        names.add("bob");
        names.add("boB");
        for (String expected : names){
            assertNotEquals(expected, actual);
        }
    }

    @Test
    public void testPersonAgeEquals(){
        byte actual = person.getAge();
        byte expected = 35;

        assertEquals(expected, actual);
    }

    @Test
    public void testPersonAgeNotEquals(){
        byte actual = person.getAge();
        List<Byte> ages = new ArrayList<>();
        ages.add((byte) 34);
        ages.add((byte) 36);
        ages.add((byte) 37);
        ages.add((byte) 53);
        for (byte expected: ages){
            assertNotEquals(expected, actual);
        }
    }

    @Test
    public void testPersonDateJoinedEquals(){
        LocalDate actual = person.getDateJoined();
        LocalDate expected = LocalDate.parse("2011-01-01");

        assertEquals(expected, actual);
    }

    @Test
    public void testPersonDateJoinedNotEquals(){
        LocalDate actual = person.getDateJoined();
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.parse("2011-01-02"));
        dates.add(LocalDate.parse("2012-01-01"));
        dates.add(LocalDate.parse("2011-02-02"));
        dates.add(LocalDate.parse("2011-12-01"));
        for (LocalDate expected : dates){
            assertNotEquals(expected, actual);
        }
    }

    @Test
    public void testPersonDateUpdatedEquals(){
        LocalDate actual = person.getDateUpdated();
        LocalDate expected = LocalDate.now();

        assertEquals(expected, actual);
    }

    @Test
    public void testPersonDateUpdatedNotEquals(){
        LocalDate actual = person.getDateUpdated();
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.parse("2011-12-01"));
        dates.add(LocalDate.now().plusDays(1));
        dates.add(LocalDate.now().plusWeeks(1));
        dates.add(LocalDate.now().plusMonths(1));
        dates.add(LocalDate.now().plusYears(1));
        for (LocalDate expected : dates){
            assertNotEquals(expected, actual);
        }
    }
}
