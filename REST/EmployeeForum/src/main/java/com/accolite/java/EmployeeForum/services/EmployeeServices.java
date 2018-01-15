package com.accolite.java.EmployeeForum.services;
import java.util.*;
import com.accolite.EmployeeForum.model.*;

public class EmployeeServices
{	
	static List<Employee> eList = new ArrayList<Employee>();	
	public EmployeeServices()
	{
		Employee n = new Employee();
		n.setId(1);
		n.setName("Rahul");		
		eList.add(n);
	}

	//add one or more entries
	// url- http://localhost:8080/EmployeeForum/webapi/employees
	public List<Employee> getAllEmployees()
	{
		return eList;
	}
	
	// http://localhost:8080/EmployeeForum/webapi/employees/1
	public Employee getEmployee(int id){
		//get the employee and return
		//Optional<Employee> matchingObject = eList.stream().filter(p->p.getId() == id).findFirst();
		for(Employee e: eList ) 
		{
			if(e.getId() == id) 
			{
				return e;
			}
		}
		return null;
	}

	public String insert(Employee employee)
	{
		int id = employee.getId();
		for(Employee e: eList) 
			if(e.getId() == id)
				return "id:" + id + " already exists";
		eList.add(employee);
		return "Inserted";	
	}

	public String update(int id, String name) 
	{
		for(Employee e: eList)
		{
			if(e.getId() == id)
			{
				e.setName(name);
				return "Updated";
			}
		}
		return "Update Unsuccessfull";
	}

	public String delete(int id)
	{
		Iterator<Employee> iterator = eList.iterator();
		while(iterator.hasNext())
		{
		    Employee e = iterator.next();
		    if (e.getId() == id)
		    {
		        iterator.remove();
		        return "Deleted";
		    }
		}
		return "No record found with ID: " + id;
	}
}