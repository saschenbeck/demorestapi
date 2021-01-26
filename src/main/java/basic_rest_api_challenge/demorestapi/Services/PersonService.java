package basic_rest_api_challenge.demorestapi.Services;

import basic_rest_api_challenge.demorestapi.Models.Person;
import basic_rest_api_challenge.demorestapi.Repos.PersonRepository;
//import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personDao;

    public Person addPerson(Person personToAdd){
        System.out.println("Saving Person Object: " + personToAdd);
        return personDao.save(personToAdd);
    }

    public List<Person> getPersons(){
        System.out.println("Retrieving all person objects");
        return personDao.findAll();
    }

    public Person getPersonByID(long personID){
        System.out.println("Finding Person Object with ID: " + personID);
        return personDao.findById(personID);
    }

    public List<Person> getPersonsByName(String personName){
        System.out.println("Finding all Person Objects where name is like: " + personName);
        return personDao.findAllByNameIsLike(personName);
    }

    public void deletePerson(Person personToDelete){
        System.out.println("Removing Person Object: " + personToDelete);
        personDao.delete(personToDelete);
    }
}
