package com.avinandan.ganguly.example_database.controller;

import com.avinandan.ganguly.example_database.bean.entity.Employee;
import com.avinandan.ganguly.example_database.bean.request.EmployeeRequest;
import com.avinandan.ganguly.example_database.bean.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.avinandan.ganguly.example_database.services.IEmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1")
public class EmployeeController {

    @Autowired
    IEmployeeService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable Long id) throws Exception {
        return service.getEmployee(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("employees")
    public Employee createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        return service.createEmployee(employeeRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "employees/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeRequest employeeRequest) throws Exception {
        return service.updateEmployee(id, employeeRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("employees/{id}")
    public Response deleteUpdate(@PathVariable Long id) throws Exception {
        return service.deleteEmployee(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "employees", params = {"name"})
    public List<Employee> getEmployeeByName(@RequestParam("name") String name) throws Exception {
        return service.getEmployeeByName(name);
    }
}
