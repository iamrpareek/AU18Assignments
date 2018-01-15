package com.au.jdbc.jdbc.assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Rahul Pareek");
        emp.setSalary(310000);
        
        Laptop l = new Laptop();
        l.setLid(10);
        l.setBrand("Asus");
        l.setPrice("89999");
        
        emp.setLaptop(l);
        
        Expenses e = new Expenses();
        e.setEid(1);
        e.setAmt(1800);;

        Expenses e1 = new Expenses();
        e1.setEid(23);
        e1.setAmt(2100);;

        emp.getExpenses().add(e);
        emp.getExpenses().add(e1);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Expenses.class);
        SessionFactory sf = con.buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        s.save(e);
        s.save(e1);
        s.save(l);
        s.save(emp);
        t.commit();
        s.close();

    }
}