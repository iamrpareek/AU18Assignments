package dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.Student;

public class StudentDAO {

	private  Map<Integer,Student> sList;
	static {
	}
	@SuppressWarnings("deprecation")
	public StudentDAO() {
		sList=new HashMap<Integer,Student>();
		sList.put(1,new Student(1, "Rahul", "Pareek", "Jaipur", new Date(1994, 03, 12), 12345, 3, "CSE"));
		sList.put(2,new Student(2, "Aditi", "Giri", "Gangtok", new Date(1993, 12, 14), 12876, 4, "EEE"));
		sList.put(3,new Student(3, "Shrey", "Pasari", "Delhi", new Date(1992, 9, 2), 12509, 5, "ECE"));
		sList.put(4,new Student(4, "Anushree", "Rai", "Kanpur", new Date(1994, 4, 11), 12325, 7, "Mech"));
		sList.put(5,new Student(5, "Chitrarth", "Tomar", "Kota", new Date(1994, 3, 26), 45321, 8, "CSE"));
	}

	public Student addStudent(Student student) {
		if(sList.get(student.getregNo())!=null)
		return null;
		sList.put(student.getregNo(), student);
		return sList.get(student.getregNo());
	}

	public Student updateStudent(Student student) {
		if(sList.get(student.getregNo())==null)
			return null;
		sList.put(student.getregNo(), student);	
		
		return sList.get(student.getregNo());

	}

	public Student getStudent(int regNo) {
		if(sList.get(regNo)==null)
			return null;
		return sList.get(regNo);
	}

	public Student deleteStudent(int regNo) {
		if(sList.get(regNo)==null)
			return null;
		Student stud=sList.remove(regNo);
		return stud;
	}
}
