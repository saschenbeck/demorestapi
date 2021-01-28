package basic_rest_api_challenge.demorestapi.Controllers;

import basic_rest_api_challenge.demorestapi.Exceptions.ResourceNotFoundException;
import basic_rest_api_challenge.demorestapi.Models.Job;
import basic_rest_api_challenge.demorestapi.Repos.JobRepository;
import basic_rest_api_challenge.demorestapi.Services.ExceptionService;
import basic_rest_api_challenge.demorestapi.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/a1")
public class JobController {

    @Autowired
    private JobRepository jobDao;

    @Autowired
    private ExceptionService exceptionService;

    @Autowired
    private JobService jobService;

    //Find All Job Objects
    @GetMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    //Find Job Object by ID
    @GetMapping("/job/{id}")
    public Job getJobByID(@PathVariable(value = "id") long jobID) throws ResourceNotFoundException {
        exceptionService.isJobNotNull(jobID);
        return jobService.getJobByID(jobID);
    }

    //Create a New Job Object
    @PostMapping("/newJob")
    public Job createNewJob(@RequestBody Job job){
        return jobService.addJob(job);
    }

    //Update a Job Object by ID
    @PutMapping("/job/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable(value = "id") long jobID, @RequestBody Job jobDetails) throws ResourceNotFoundException{
        Job jobToUpdate = jobService.getJobByID(jobID);
        exceptionService.isJobNotNull(jobToUpdate);
        jobService.updateJob(jobToUpdate, jobDetails.getJobTitle(), jobDetails.getSalary());
        return ResponseEntity.ok().body(jobToUpdate);
    }
}
