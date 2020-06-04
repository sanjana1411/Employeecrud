package com.EmployeeManagement.Employee.Controller;

import com.EmployeeManagement.Employee.EmployeeNotFoundException;
import com.EmployeeManagement.Employee.EmployeeService;
import com.EmployeeManagement.Employee.Entity.Employee;
import com.EmployeeManagement.Employee.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //Create a new employee
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok().body(employeeService.createEmployee(employee));
    }

    //Read all the existing employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    //Read employee by ID
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws EmployeeNotFoundException {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(employeeId));
    }
    //Read employee by attribute
    /*
    @GetMapping(path = "/employees/{department}")
    public List<Employee> getEmployeeByDepartment(@RequestParam String department){
        return employeeRepository.findByDepartment(department);
    }
    */

    //Update employee without overwriting(if exists)
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId, @RequestBody Employee employeeInfo) throws EmployeeNotFoundException{
        employeeInfo.setId(employeeId);
        return ResponseEntity.ok().body(employeeService.updateEmployee(employeeId, employeeInfo));
    }
    //Delete employee(if exits)
    @DeleteMapping("/employees/{id}")
    public HttpStatus deleteEmployee(@PathVariable(value = "id") Long employeeId) throws EmployeeNotFoundException{
        employeeService.deleteEmployee(employeeId);
        return HttpStatus.OK;
    }
}
