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
    //Adding Job Object
    public Job addJob(Job jobToAdd){
        System.out.println("Saving Job Object: " + jobToAdd);
        return jobDao.save(jobToAdd);
    }

    //Finding Job Object by jobID
    public Job getJobByID(long jobID){
        System.out.println("Finding job with ID: " + jobID);
        return jobDao.findById(jobID);
    }

    //Finding All Jobs
    public List<Job> getAllJobs(){
        System.out.println("Retrieving all job objects");
        return jobDao.findAll();
    }

    //Update Job Name and Salary
    public Job updateJob(Job jobToUpdate, String newJobName, double newSalary){
        jobToUpdate.setJobTitle(newJobName);
        jobToUpdate.setSalary(newSalary);
        return jobDao.save(jobToUpdate);
    }

    //Update Job Name and Salary, Find Job by jobID
    public Job updateJob(long jobID, String newJobName, double newSalary){
        Job jobToUpdate = getJobByID(jobID);
        return updateJob(jobToUpdate, newJobName, newSalary);
    }

    //Update Job Name
    public Job updateJob(Job jobToUpdate, String newJobName){
        jobToUpdate.setJobTitle(newJobName);
        return jobDao.save(jobToUpdate);
    }

    //Update Job Name, Find Job by jobID
    public Job updateJob(long jobID, String newJobName){
        Job jobToUpdate = getJobByID(jobID);
        return updateJob(jobToUpdate, newJobName);
    }


    //Update Job Salary
    public Job updateJob(Job jobToUpdate, double newSalary){
        jobToUpdate.setSalary(newSalary);
        return jobDao.save(jobToUpdate);
    }

    //Update Job Salary, Find Job by jobID
    public Job updateJob(long jobID, double newSalary){
        Job jobToUpdate = getJobByID(jobID);
        return updateJob(jobToUpdate, newSalary);
    }

    //Delete Job Object
    public void deleteJob(Job jobToDelete){
        System.out.println("Removing Job Object: " + jobToDelete);
        jobDao.delete(jobToDelete);
    }

    //Delete Job Object, Find Job by jobID
    public void deleteJob(long jobID){
        Job jobToDelete = getJobByID(jobID);
        deleteJob(jobToDelete);
    }

}
