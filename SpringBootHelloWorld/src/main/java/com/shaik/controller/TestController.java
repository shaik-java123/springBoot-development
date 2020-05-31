package com.shaik.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.shaik.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Validated
@RequestMapping("/SpringBootHW")



public class TestController {
    private List<Employee> employees = createList();
    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public List<Employee> firstPage() {
        return employees;
    }
    private static List<Employee> createList() {
        List<Employee> tempEmployees = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setEmpId("1");
        emp1.setSalary(3000);
        Employee emp2 = new Employee();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setEmpId("2");
        emp2.setSalary(3000);
        tempEmployees.add(emp1);
        tempEmployees.add(emp2);
        return tempEmployees;
    }
    @PostMapping(value = "/addemployee",  consumes = "application/json")
    public List<Employee>  addEmployee(@RequestBody  Employee employee) {
 System.out.println("Inside add employee method "+ employee.getDesignation());
        employees.add(employee);
        return employees;
    }
    @DeleteMapping(path ={"/{id}"})
    public List<Employee>  delete(@PathVariable("id") int empId) {
        System.out.println("Inside delete employee method "+ empId);
        for (Employee emp : employees) {
            if (emp.getEmpId().equals(empId)) {
                employees.remove(emp);
            }
        }
        System.out.println(employees);
return employees;
    }
}