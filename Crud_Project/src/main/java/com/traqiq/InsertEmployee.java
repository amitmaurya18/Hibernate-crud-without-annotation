package com.traqiq;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertEmployee {
    public static void main(String[] args){
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx;
        String choice ="no";
        Scanner scan= new Scanner((System.in));
        
        do{
            tx=session.beginTransaction();
            Employee employee=new Employee();
            System.out.println("Enter Employee Number:");
            employee.setEmpno(scan.nextInt());
            System.out.println("Enter Employee Name:");
            employee.setEname(scan.next());
            System.out.println("Enter Employee Salary:");
            employee.setSalary(scan.nextInt());
            session.save(employee);
            session.flush();
            tx.commit();
            System.out.println("One record inserted successfully");
            System.out.println("Do you want insert new employee record y/n");
            choice=scan.next();
        }
        while(choice.equalsIgnoreCase("y") | choice.equalsIgnoreCase("yes"));
        session.close();
        sessionFactory.close();
    }
}
