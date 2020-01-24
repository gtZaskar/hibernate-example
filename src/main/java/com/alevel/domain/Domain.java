package com.alevel.domain;

import com.alevel.entities.Address;
import com.alevel.entities.Employee;
import com.alevel.entities.Project;
import com.alevel.service.AddressService;
import com.alevel.service.EmployeeService;
import com.alevel.service.ProjectService;
import com.alevel.utils.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Domain {
    public static void main(String[] args) throws SQLException {

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();


        Address address = new Address();
        address.setCountry("Ukraine");
        address.setCity("Kharkiv");
        address.setStreet("Nauki 9");
        address.setPostCode("123456");



//        Address address1 = new Address();
//        address1.setCountry("Ukraine");
//        address1.setCity("Kyiv");
//        address1.setStreet("khreshchatyk 27");
//        address1.setPostCode("654321");



        Project project = new Project();
        project.setTitle("Java is very hard language");



//        Project project1 = new Project();
//        project1.setTitle("Java is not bad language");


        Employee employee = new Employee();
        employee.setFirstName("Alex");
        employee.setLastName("Nestertsov");



//        Employee employee1 = new Employee();
//        employee1.setFirstName("Katerina");
//        employee1.setLastName("Antonova");



        Calendar calendar = Calendar.getInstance();
        calendar.set(1988, Calendar.JANUARY, 12);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);



//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.set(1988, Calendar.NOVEMBER, 17);
//
//        employee1.setBirthday(new Date(calendar1.getTime().getTime()));
//        employee1.setAddress(address1);



        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        project.setEmployees(employees);


//        employees.add(employee1);
//        project1.setEmployees(employees);



        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

//        projects.add(project1);
//        employee1.setProjects(projects);



//       addressService.add(address);
//       employeeService.add(employee);
//       projectService.add(project);

        Address a = addressService.getById(1L);
        System.out.println(a);
        HibernateUtil.shutdown();

    }
}
