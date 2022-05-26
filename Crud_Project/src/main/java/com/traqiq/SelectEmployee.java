package com.traqiq;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class SelectEmployee {
    public static void main(String [] args){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Employee Number:");
        Employee employee =(Employee) session.load(Employee.class,scan.nextInt());

        System.out.println("Employee Number is:" + employee.getEmpno());
        System.out.println("Employee Name is:" + employee.getEname());
        System.out.println("Employee Salary is:" + employee.getSalary());
    }
}
