package com.saitej.springbootjdbc.runner;

import com.saitej.springbootjdbc.dao.EmployeeDao;
import com.saitej.springbootjdbc.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class EmployeeRunner implements CommandLineRunner {
    @Autowired
    EmployeeDao dao;

    @Override
    public void run(String... args) throws Exception {
      /*  int count=0;
        dao.saveEmployee(new Employee(1, "Virat", "Kohili", "virat@gmail.com"));
        count++;
        dao.saveEmployee(new Employee(2, "Sachin", "Tendulkar", "tendulkar@gmail.com"));
        count++;
        dao.saveEmployee(new Employee(3, "Rohit", "Sharma", "Rohit@gmail.com"));
        count++;
        dao.saveEmployee(new Employee(4, "KL", "Rahul", "rahul@gmail.com"));
        count++;
        dao.saveEmployee(new Employee(5, "ABD", "Devilers", "abd@gmail.com"));
        count++;
        dao.saveEmployee(new Employee(6, "Eon", "Morgon", "eon@gmail.com"));
        log.info("Employees saved : " + count);
*/

       /* int hit = dao.updateEmployee(Employee.builder().first_name("Hit").id(3).build());
        log.info(String.valueOf(hit));
*/
       /* int i = dao.deleteEmployee(6);
        log.info(String.valueOf(i));*/

        List<Employee> employees = dao.getEmployees();
        employees.forEach(System.out::println);
    }
}
