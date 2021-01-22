package basic_rest_api_challenge.demorestapi.Models;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private byte age;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateJoined;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateUpdated;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    public Person (){

    }

    public Person(long id, String name, byte age, LocalDate dateJoined, LocalDate dateUpdated, Job job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
        this.job = job;
    }

    public Person(String name, byte age, LocalDate dateJoined, LocalDate dateUpdated, Job job) {
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
        this.job = job;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
