package basic_rest_api_challenge.demorestapi.Controllers;

import basic_rest_api_challenge.demorestapi.Exceptions.ResourceNotFoundException;
import basic_rest_api_challenge.demorestapi.Models.Person;
import basic_rest_api_challenge.demorestapi.Repos.PersonRepository;
import basic_rest_api_challenge.demorestapi.Services.ExceptionService;
import basic_rest_api_challenge.demorestapi.Services.SeedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/a1")
public class PersonController {

    @Autowired
    private PersonRepository personDao;

    @Autowired
    private ExceptionService exceptionService;

    @Autowired
    private SeedListService seedList;

    @GetMapping("")
    public void start(){
        seedList.jobSeedList();
        seedList.personSeedList();
    }

    //Find All Person Objects
    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personDao.findAll();
    }

    //Creating a New Person Object
    @PostMapping("/newPerson")
    public Person createNewPerson(@RequestBody Person person){
        return personDao.save(person);
    }

    //Find Person Object by Id
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") long personID) throws ResourceNotFoundException {
      Person personResult = personDao.findById(personID);

      exceptionService.isPersonNotNull(personResult);

      return ResponseEntity.ok().body(personResult);
    }

    //Update a Person Object by ID
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") long personID, @RequestBody Person personDetails) throws ResourceNotFoundException {
        Person personToUpdate = personDao.findById(personID);

        exceptionService.isPersonNotNull(personToUpdate);

        personToUpdate.setName(personDetails.getName());
        personToUpdate.setAge(personDetails.getAge());
        personToUpdate.setJob(personDetails.getJob());
        personToUpdate.setDateJoined(personDetails.getDateJoined());
        personToUpdate.setDateUpdated(personDetails.getDateUpdated());

        personDao.save(personToUpdate);
        return ResponseEntity.ok().body(personToUpdate);
    }

    //Delete a Person Object by ID
    @DeleteMapping("/person/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable(value = "id") long personID) throws ResourceNotFoundException {
        Person personToDelete = personDao.findById(personID);

        exceptionService.isPersonNotNull(personToDelete);

        personDao.deleteById(personID);
        return ResponseEntity.ok().build();
    }
}
