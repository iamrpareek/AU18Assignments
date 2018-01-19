package service;

import dao.StudentDAO;
import model.Student;

public class StudentService {
	
	private static StudentDAO dao;  
	public StudentService() {
		dao=new StudentDAO();
	}

	public Student addStudent(Student student) {
		Student addedStudent=null;
		boolean status=verifyStudentEntry(student);
		if(status==true)
		addedStudent=dao.addStudent(student);
		return addedStudent;
	}
	
	public Student updateStudent(Student student) 
	{
		if(student.getregNo()<=0)
			return null;
		Student updatedStudent=dao.updateStudent(student);
		if(verifyStudentEntry(updatedStudent))
		return updatedStudent;
		return null;
		
	}
	
	public Student getStudent(int regNo)
	{
		if(regNo<1)
			return null;
		Student student=dao.getStudent(regNo);
		
		return student;
	}
	
	public Student deleteStudent(int regNo)
	{	if(regNo<=0)
		return null;
		return dao.deleteStudent(regNo);
		
	}
	
	private boolean verifyStudentEntry(Student student)
	{
		if(student.getregNo()<=0)
			return false;
		else if(student.getFname()==null)
			return false;
		else if(student.getDob()==null)
			return false;
		else if(student.getsem()<=0 && student.getsem()>8)
			return false;
	switch(student.getBranch().toLowerCase())
	{
		case "cse" : return true;
		case "mech":return true;
		case "civil": return true;
		default : return true;
	}	
	}	
}