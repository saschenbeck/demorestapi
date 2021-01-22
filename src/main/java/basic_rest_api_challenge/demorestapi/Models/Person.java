package basic_rest_api_challenge.demorestapi.Models;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private byte age;

    @Column
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateJoined;

    @Column
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateUpdated;

    public Person (){

    }

    public Person(long id, String name, byte age, LocalDate dateJoined, LocalDate dateUpdated) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
    }

    public Person(String name, byte age, LocalDate dateJoined, LocalDate dateUpdated) {
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
        this.dateUpdated = dateUpdated;
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
}
