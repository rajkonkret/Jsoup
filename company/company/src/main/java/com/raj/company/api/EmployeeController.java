package com.raj.company.api;

import com.raj.company.domain.Employee;
import com.raj.company.domain.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EmployeeController {


    private EmployeeRepository employeeRepository;

    // to konstruktor który zastępuje @Autowired - nowszy sposób
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("employees")
    public Iterable<Employee> index() {
        return employeeRepository.findAll();
        //return employeeRepository.findEmployeesByJob("MANAGER");
    }

    @GetMapping("job")
    public Iterable<Employee> findByJob(@RequestParam(required = false) String job) {
        if (job != null) {
            //return employeeRepository.findEmployeesByJob(job.toUpperCase());
           // return employeeRepository.findEmployeesByJob(job);
            return employeeRepository.findEMP(job);
        } else {
           return employeeRepository.findAll();
        }
    }
}



