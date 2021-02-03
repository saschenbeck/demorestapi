package basic_rest_api_challenge.demorestapi.ControllersTest;

import basic_rest_api_challenge.demorestapi.Models.Job;
import basic_rest_api_challenge.demorestapi.Models.Person;
import basic_rest_api_challenge.demorestapi.Repos.JobRepository;
import basic_rest_api_challenge.demorestapi.Repos.PersonRepository;
//import org.joda.time.LocalDate;
import basic_rest_api_challenge.demorestapi.Controllers.PersonController;
import basic_rest_api_challenge.demorestapi.Controllers.JobController;
import basic_rest_api_challenge.demorestapi.Services.JobService;
import basic_rest_api_challenge.demorestapi.Services.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobControllerTest {
    @MockBean
    private JobRepository jobDao;

    @Autowired
    private JobService jobService;

    @Test
    public void getAllJobsEqual(){
        when(jobDao.findAll()).thenReturn(Stream.of(
                new Job("CEO", 100000),
                new Job("Salesperson", 25000)
        ).collect(Collectors.toList()));

        assertEquals(2, jobService.getAllJobs().size());
        assertEquals("CEO", jobService.getAllJobs().get(0).getJobTitle());
        assertEquals("Salesperson", jobService.getAllJobs().get(1).getJobTitle());
        assertEquals(100000, jobService.getAllJobs().get(0).getSalary(), 0);
        assertEquals(25000, jobService.getAllJobs().get(1).getSalary(), 0);
    }

    @Test
    public void getAllJobsNotEqual(){
        when(jobDao.findAll()).thenReturn(Stream.of(
                new Job("CEO", 100000),
                new Job("Salesperson", 25000)
        ).collect(Collectors.toList()));

        assertNotEquals(3, jobService.getAllJobs().size());
        assertNotEquals(1, jobService.getAllJobs().size());
        assertNotEquals(2.1, jobService.getAllJobs().size());
        assertNotEquals(1.9, jobService.getAllJobs().size());
    }

    @Test
    public void addJobEquals(){
        Job job = new Job("CEO", 100000);
        when(jobDao.save(job)).thenReturn(job);
        assertEquals(job, jobService.addJob(job));
        verify(jobDao, times(1)).save(job);
    }

    @Test
    public void deleteJobVerify(){
        Job job = new Job("CEO", 100000);
        jobService.deleteJob(job);
        verify(jobDao, times(1)).delete(job);
    }

    //WIP
    //Need to understand why ID has to be hardcoded instead of allowing auto increment
    //Currently unsure of how to properly test
    @Test
    public void getJobByIDEquals(){
        when(jobDao.findAll()).thenReturn(Stream.of(
                new Job(1,"CEO", 100000),
                new Job(2,"Salesperson", 25000)
        ).collect(Collectors.toList()));
        for (Job index: jobDao.findAll()){
            System.err.println(index.getId() + " " + index.getJobTitle());
        }
    }


    @Test
    public void jobHoldersListEquals(){
        List<Person> jobHolders = new ArrayList<>();
        Job job = new Job("CEO", 100000, jobHolders);
        Person person = new Person("Bob",(short) 35,LocalDate.parse("2011-01-01"),LocalDate.now(), job);
        jobHolders.add(person);

        assertEquals(person, job.getJobHolderList().get(0));
    }

    @Test
    public void jobHoldersListNotEquals(){
        List<Person> jobHolders = new ArrayList<>();
        Job job = new Job("CEO", 100000, jobHolders);
        Person person = new Person("Bob",(short) 35,LocalDate.parse("2011-01-01"),LocalDate.now(), job);
        Person person2 = new Person();
        jobHolders.add(person);
        jobHolders.add(person2);

        assertNotEquals(person2, job.getJobHolderList().get(0));
    }
}
