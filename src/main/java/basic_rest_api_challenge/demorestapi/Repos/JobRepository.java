package basic_rest_api_challenge.demorestapi.Repos;

import basic_rest_api_challenge.demorestapi.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    Job findByJobTitleEquals(String jobTitle);
}
