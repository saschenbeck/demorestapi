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
    public void getJobByIDEquals(){

    }



}
