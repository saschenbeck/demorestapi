package basic_rest_api_challenge.demorestapi.Services;

import basic_rest_api_challenge.demorestapi.Exceptions.ResourceNotFoundException;
import basic_rest_api_challenge.demorestapi.Models.Person;
import basic_rest_api_challenge.demorestapi.Repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {
    @Autowired
    public PersonRepository personDao;

    //Check if Person Object is null
    public boolean isPersonNotNull(Person person) throws ResourceNotFoundException{
        if (person == null){
            throw new ResourceNotFoundException("Could not find a Person Object");
        } else {
            return true;
        }
    }

    public boolean isPersonNotNull(long personID) throws ResourceNotFoundException{
        Person person = personDao.findById(personID);
        if (person == null){
            throw new ResourceNotFoundException("Could not find a Person Object");
        } else {
            return true;
        }
    }
}
