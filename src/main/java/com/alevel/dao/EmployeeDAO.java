package com.alevel.dao;

import com.alevel.entities.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    //create
    void add(Employee employee) throws SQLException;

    //read
    List<Employee> getAll() throws SQLException;

    Employee getById(Long id) throws SQLException;

    //update
    void update(Employee employee) throws SQLException;

    //remove
    void remove(Employee employee) throws SQLException;
}