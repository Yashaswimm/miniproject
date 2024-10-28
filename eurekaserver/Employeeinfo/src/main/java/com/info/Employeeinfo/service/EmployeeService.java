package com.info.Employeeinfo.service;

import com.info.Employeeinfo.Model.Employee;
import com.info.Employeeinfo.Repository.EmployeeRepository;
import com.info.Employeeinfo.client.FullResponse;
import com.info.Employeeinfo.client.Projectinfo;
import com.info.Employeeinfo.feign.ProjectClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Autowired
    private ProjectClient client;


    public Employee saveEmployee(Employee employee)
    {
        return repo.save(employee);
    }

    public FullResponse getEmployeeByProjectCcode(Long ccode)
    {
        Employee employee=repo.findByCcode(ccode).orElse(null);
        List<Projectinfo> list=client.findProjectByCcode(ccode);
        FullResponse response=new FullResponse();
        response.setName(employee.getName());
        response.setDepartment(employee.getDepartment);
    }
}
