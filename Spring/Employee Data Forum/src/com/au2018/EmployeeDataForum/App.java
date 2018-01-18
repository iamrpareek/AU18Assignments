package com.au2018.EmployeeDataForum;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ){
        
    	ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao dao=(EmployeeDao)con.getBean("edao");
        List<Employee> elist=dao.getAllEmployeesRowMapper();  
        for(Employee e:elist)  
            System.out.println(e.getName()); 
        
        List<Employee> l = new ArrayList<Employee>();
        Employee e1= new Employee(1,"Rahul",53000);
        Employee e2= new Employee(2,"Cristiano",77000);
        Employee e3= new Employee(3,"David",41000);
        Employee e4= new Employee(4,"Aamir",39000);
        Employee e5= new Employee(5,"Sharman",22000);
        Employee e6= new Employee(6,"Madhav",17000);
        Employee e7= new Employee(7,"Annie",12000);
        Employee e8= new Employee(8,"Gerrard",27000);
        Employee e9= new Employee(9,"Blake",10000);
        Employee e10= new Employee(10,"Zinedin",54000);
        l.add(e1);
        l.add(e2);
        l.add(e3);
        l.add(e4);
        l.add(e5);
        l.add(e6);
        l.add(e7);
        l.add(e8);
        l.add(e3);
        l.add(e9);
        l.add(e10);
        dao.insertBatch(l);
    }
}