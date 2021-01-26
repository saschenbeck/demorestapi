package basic_rest_api_challenge.demorestapi.ModelsTest;
import basic_rest_api_challenge.demorestapi.Models.Job;
import basic_rest_api_challenge.demorestapi.Models.Person;
//import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class testJob {
    private Job job1 = new Job("Salesperson", 25000);
    private Job job2 = new Job("CEO", 1000000);
    private final Person person1 = new Person("Bob", (byte) 35, LocalDate.parse("2011-01-01"), LocalDate.now(), job1);
    private final Person person2 = new Person("Paul", (byte) 25, LocalDate.parse("2016-01-01"), LocalDate.now(), job1);

    @Test
    public void testIfJobIsNotNull(){
        assertNotNull(this.job1);
        assertNotNull(this.job2);
    }

    @Test
    public void testIfJobNameEquals(){
        String actual = this.job1.getJobTitle();
        String expected = "Salesperson";

        assertEquals(expected, actual);
    }

    @Test
    public void testIfJobNameNotEquals(){
        String actual = this.job1.getJobTitle();
        List<String> jobTitles = new ArrayList<>();
        jobTitles.add("Manager");
        jobTitles.add("Custodian");
        jobTitles.add("Clerk");
        for (String expected : jobTitles){
            assertNotEquals(expected, actual);
        }
    }

    @Test
    public void testIfJobSalaryEqual(){
        double actual = this.job1.getSalary();
        double expected = 25000;

        assertEquals(expected, actual, 0);
        System.out.println("Success with no decimals in expected or actual!");

        expected = 25000.00;

        assertEquals(expected, actual, 0);
        System.out.println("Success with decimals in only expected!");
    }

    @Test
    public void testIfJobSalaryNotEqual(){
        double actual = this.job1.getSalary();
        List<Double> salaries = new ArrayList<>();
        salaries.add((double) 25001);
        salaries.add(25000.1);
        salaries.add(25000.01);
        salaries.add((double) -25000);
        for (double expected : salaries){
            assertNotEquals(expected, actual, 0);
        }
    }

    @Before
    public void setUp(){
        this.job1.setJobHolder(person1);
        this.job1.setJobHolder(person2);
        this.job2.setJobHolder(person1);
        this.job2.setJobHolder(person2);
    }

    @Test
    public void testIfJobHoldersEquals(){
        List<Person> actual = this.job1.getJobHolderList();

        List<Person> expected = new ArrayList<>();
        expected.add(person1);
        expected.add(person2);

        assertEquals(expected, actual);
    }

    @Test
    public void testIfJobHoldersNotEquals(){
        List<Person> actual = this.job1.getJobHolderList();

        List<Person> expected = new ArrayList<>();

        assertNotEquals(expected, actual);
        System.out.println("It does not equal to an empty list!");

        expected.add(new Person());
        assertNotEquals(expected, actual);
        System.out.println("It does not equal a list with a blank person!");

        expected.clear();

        expected.add(person2);
        expected.add(person1);

        System.out.println("Actual: " + actual);
        System.out.println("Expected: " + expected);

        assertNotEquals(expected, actual);

        System.out.println("It does not equal if same objects are at different index!");
    }

    @Test
    public void testIfJobHolderListsWithSameObjectsEqual(){
        List<Person> actual = this.job1.getJobHolderList();
        List<Person> expected = this.job2.getJobHolderList();
        assertEquals(expected, actual);
    }
}
