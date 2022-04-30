package com.saitej.springbootjdbc.dao;

import com.saitej.springbootjdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    JdbcTemplate jt;

    @Override
    public int saveEmployee(Employee employee) {
        String INSERT_EMPLOYEE = "INSERT INTO TBL_EMPLOYEES (ID,FIRST_NAME,LAST_NAME,EMAIL)VALUES(?,?,?,?)";
        return jt.update(INSERT_EMPLOYEE, employee.getId(), employee.getFirst_name(), employee.getLast_name(), employee.getEmail());
    }

    @Override
    public List<Employee> getEmployees() {
        String SELECT_QUERY = "SELECT * FROM TBL_EMPLOYEES";
        // return jt.query(SELECT_QUERY ,new BeanPropertyRowMapper<Employee>(Employee.class)); // using BeanPropertyRowMapper

        return jt.query(SELECT_QUERY, (ResultSet rs, int rowNum) -> Employee
                .builder()
                .id(rs.getInt(1))
                .first_name(rs.getString(2))
                .last_name(rs.getString(3)).email(rs.getString(4)).build());//using RowMapper  cls



    }

    @Override
    public int updateEmployee(Employee employee) {
        String UPDATE_EMPLOYEE = "UPDATE TBL_EMPLOYEES SET FIRST_NAME=? WHERE ID=?";
        return jt.update(UPDATE_EMPLOYEE, employee.getFirst_name(), employee.getId());
    }


    public int deleteEmployee(int id) {
        String DELETE_EMPLOYEE = "DELETE FROM  TBL_EMPLOYEES WHERE ID=?";
        return jt.update(DELETE_EMPLOYEE, id);
    }
}
