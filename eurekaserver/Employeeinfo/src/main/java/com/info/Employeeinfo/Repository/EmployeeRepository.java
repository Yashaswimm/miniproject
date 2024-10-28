package com.info.Employeeinfo.Repository;

import com.info.Employeeinfo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByCcode(Long ccode)
    {

    }
}
