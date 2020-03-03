package com.raj.company.api;

import com.raj.company.domain.Department;
import com.raj.company.domain.DepartmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentRepository departmentRepository;
    public DepartmentController(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("")
    public Iterable<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
