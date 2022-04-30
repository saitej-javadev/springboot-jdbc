package com.saitej.springbootjdbc.dao;

import com.saitej.springbootjdbc.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public int  saveEmployee(Employee employee);
    List<Employee> getEmployees();
    public int updateEmployee(Employee employee);
    public int deleteEmployee(int id);

}
