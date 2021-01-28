package basic_rest_api_challenge.demorestapi.Controllers;

import basic_rest_api_challenge.demorestapi.Repos.JobRepository;
import basic_rest_api_challenge.demorestapi.Services.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/a1")
public class JobController {

    @Autowired
    private JobRepository jobDao;

    @Autowired
    private ExceptionService exceptionService;


}
