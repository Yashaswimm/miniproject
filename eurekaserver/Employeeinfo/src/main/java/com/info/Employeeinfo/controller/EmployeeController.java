package com.info.Employeeinfo.controller;


import com.info.Employeeinfo.client.FullResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ustemps")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }

    @GetMapping("withprojects/{code}")
    public ResponseEntity<FullResponse> getEmployeeByCcode(@PathVariable("ccode") Long ccode)
    {
        return ResponseEntity.ok(employeeService.getEmployeeByProjectCcode(ccode));
    }
}
