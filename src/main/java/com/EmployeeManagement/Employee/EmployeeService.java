package com.EmployeeManagement.Employee;

import com.EmployeeManagement.Employee.Entity.Employee;
import com.EmployeeManagement.Employee.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(Long employeeId, @RequestBody Employee employeeInfo) throws EmployeeNotFoundException{
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :" + employeeId));
        if (employeeInfo.getAddress() != null)
            employee.setAddress(employeeInfo.getAddress());
        if (employeeInfo.getDepartment() != null)
            employee.setDepartment(employeeInfo.getDepartment());
        if (employeeInfo.getDob() != null)
            employee.setDob(employeeInfo.getDob());
        if (employeeInfo.getName() != null)
            employee.setName(employeeInfo.getName());
        employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long employeeId) throws EmployeeNotFoundException{
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :" + employeeId));
        return employee;
    }

    public void deleteEmployee(Long employeeId) throws EmployeeNotFoundException{
        employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :" + employeeId));
        employeeRepository.deleteById(employeeId);
    }

}
