package basic_rest_api_challenge.demorestapi.Repos;

import basic_rest_api_challenge.demorestapi.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findById(long id);
    List<Person> findAllByName(String personName);
}
