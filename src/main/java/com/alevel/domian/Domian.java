package com.alevel.domian;

import com.alevel.entities.Address;
import com.alevel.entities.Employee;
import com.alevel.entities.Project;
import com.alevel.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Domian {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Address address = new Address();
        address.setCountry("Ukraine");
        address.setCity("Kharkiv");
        address.setStreet("Nauki");
        address.setPostCode("123456");

        Project project = new Project();
        project.setTitle("Java is very hard language");

        Employee employee = new Employee();
        employee.setFirstName("Alex");
        employee.setLastName("Nestertsov");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1988, Calendar.JANUARY, 12);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        session.save(address);
        session.save(project);
        session.save(employee);

        session.getTransaction().commit();
        HibernateUtil.shutdown();

    }
}
