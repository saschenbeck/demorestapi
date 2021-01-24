package basic_rest_api_challenge.demorestapi.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private double salary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
    private List<Person> jobHolderList;

    public Job(){

    }

    public Job(long id, String jobTitle, double salary) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.jobHolderList = new ArrayList<>();
    }

    public Job(String jobTitle, double salary) {
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.jobHolderList = new ArrayList<>();
    }

    public Job(long id, String jobTitle, double salary, List<Person> jobHolders){
        this.id = id;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.jobHolderList = jobHolders;
    }

    public Job(String jobTitle, double salary, List<Person> jobHolders){
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.jobHolderList = jobHolders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @JsonBackReference
    public List<Person> getJobHolderList() {
        return jobHolderList;
    }

    public void setJobHolder(Person jobHolder) {
        this.jobHolderList.add(jobHolder);
    }
}
