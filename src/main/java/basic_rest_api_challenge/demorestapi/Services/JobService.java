package basic_rest_api_challenge.demorestapi.Services;

import basic_rest_api_challenge.demorestapi.Models.Job;
import basic_rest_api_challenge.demorestapi.Repos.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobDao;

    public Job addJob(Job jobToAdd){
        System.out.println("Saving Job Object: " + jobToAdd);
        return jobDao.save(jobToAdd);
    }

    public Job getJobByID(long jobID){
        System.out.println("Finding job with ID: " + jobID);
        return jobDao.findById(jobID);
    }

    public List<Job> getAllJobs(){
        System.out.println("Retrieving all job objects");
        return jobDao.findAll();
    }

    public Job updateJob(long jobID, String newJobName){
        Job jobToUpdate = getJobByID(jobID);
        jobToUpdate.setJobTitle(newJobName);
        return jobDao.save(jobToUpdate);
    }

    public Job updateJob(Job jobToUpdate, String newJobName){
        jobToUpdate.setJobTitle(newJobName);
        return jobDao.save(jobToUpdate);
    }

    public Job updateJob(long jobID, double newSalary){
        Job jobToUpdate = getJobByID(jobID);
        jobToUpdate.setSalary(newSalary);
        return jobDao.save(jobToUpdate);
    }

    public Job updateJob(Job jobToUpdate, double newSalary){
        jobToUpdate.setSalary(newSalary);
        return jobDao.save(jobToUpdate);
    }

    public void deleteJob(Job jobToDelete){
        System.out.println("Removing Job Object: " + jobToDelete);
        jobDao.delete(jobToDelete);
    }

    public void deleteJob(long jobID){
        Job jobToDelete = getJobByID(jobID);
        System.out.println("Removing Job Object: " + jobToDelete);
        jobDao.delete(jobToDelete);
    }

}
