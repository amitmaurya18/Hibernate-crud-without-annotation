package com.traqiq;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class UpdateEmployee {
    public static void main(String[] args){
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Scanner scan =new Scanner(System.in);

        System.out.println("Enter empno to update:");
        Employee employee =(Employee) session.get(Employee.class,scan.nextInt());
        if(employee != null){
            System.out.println("Enter new Salary to update:");
            employee.setSalary(scan.nextInt());
            session.update(employee);
            session.flush();
            tx.commit();
            System.out.println("One record updated successfully");
        }
        else{
            System.out.println("Record not found please enter correct employee number");
        }
        session.close();
        sessionFactory.close();
    }
}
