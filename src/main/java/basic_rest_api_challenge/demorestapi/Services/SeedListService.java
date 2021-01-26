package basic_rest_api_challenge.demorestapi.Services;

import basic_rest_api_challenge.demorestapi.Models.Job;
import basic_rest_api_challenge.demorestapi.Models.Person;
import basic_rest_api_challenge.demorestapi.Repos.JobRepository;
import basic_rest_api_challenge.demorestapi.Repos.PersonRepository;
//import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeedListService {
    @Autowired
    private PersonRepository personDao;

    @Autowired
    private JobRepository jobDao;

    public List<Job> jobSeedList(){
        if (jobDao.findAll().size() == 0) {
            Job firstJob = new Job("CEO", 100000);
            Job secondJob = new Job("Salesperson", 25000);
            jobDao.save(firstJob);
            jobDao.save(secondJob);
        }
        return jobDao.findAll();
    }

    public List<Person> personSeedList(){
        if (personDao.findAll().size() == 0){
            Person firstPerson = new Person("Phil", (short) 65, LocalDate.parse("2011-01-01"),LocalDate.now(), jobDao.findByJobTitleEquals("CEO"));
            Person secondPerson = new Person("Bob", (short) 35, LocalDate.parse("2020-01-01"),LocalDate.now() , jobDao.findByJobTitleEquals("Salesperson"));
            Person thirdPerson = new Person("Jack", (short) 25, LocalDate.parse("2021-01-01"),LocalDate.now() , jobDao.findByJobTitleEquals("Salesperson"));
            personDao.save(firstPerson);
            personDao.save(secondPerson);
            personDao.save(thirdPerson);
        }
        return personDao.findAll();
    }
}
