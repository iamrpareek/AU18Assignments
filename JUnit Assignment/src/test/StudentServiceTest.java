import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;
import dao.StudentDAO;
import model.Student;
import service.StudentService;

public class StudentServiceTest {
	@Mock
	StudentDAO mockedStudentDAO;
	@BeforeEach
	void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void isAddStudentWorking() {
	
	
	@SuppressWarnings("deprecation")
	Student student=new Student(1, "Rahul", "Pareek", "MIT", new Date(1994, 03, 12), 12345, 3, "CSE");
	Student student1=new Student(0, "Anshul", "Shukla", "IITD", new Date(1994, 03, 12), 12345, 3, "ECE");
	Student student2=new Student(7, "Rohit", "Jain", "MIT", new Date(1994, 9, 12), 67890, 8, "CSE");
	
	Mockito.when(mockedStudentDAO.addStudent(student)).thenReturn(null);
	Mockito.when(mockedStudentDAO.addStudent(student1)).thenReturn(null);
	Mockito.when(mockedStudentDAO.addStudent(student2)).thenReturn(student2);
	StudentService sService=new StudentService();
	
	Student stud=sService.addStudent(student);
	Student stud1=sService.addStudent(student1);
	Student stud2=sService.addStudent(student2);
	assertNull(stud);
	assertNull(stud1);
	assertNotNull(stud2);
	assertEquals(student2, stud2);
}
	
	@Test
	public void isUpdateWorking()
	{
		@SuppressWarnings("deprecation")
		Student student=new Student(1, "Rahul", "Pareek", "Jaipur", new Date(1994, 03, 12), 12345, 3, "CSE");		
		Mockito.when(mockedStudentDAO.updateStudent(student)).thenReturn(null);
		StudentService sService=new StudentService();
		Student stud=sService.updateStudent(student);
		assertNotNull(stud);
	}

	@Test
	public void isDeleteWorking()
	{
		@SuppressWarnings("deprecation")
		Student student=new Student(1, "Rahul", "Pareek", "Jaipur", new Date(1994, 03, 12), 12345, 3, "CSE");
		Mockito.when(mockedStudentDAO.deleteStudent(1)).thenReturn(student);
		StudentService sService=new StudentService();
		Student stud=sService.deleteStudent(1);
		assertNotNull(stud);
	}

	@Test
	public void isGetStudentWorking()
	{
		@SuppressWarnings("deprecation")
		Student student=new Student(1, "Rahul", "Pareek", "Jaipur", new Date(1994, 03, 12), 12345, 3, "CSE");
		Mockito.when(mockedStudentDAO.getStudent(Matchers.anyInt())).thenReturn(student);
		StudentService sService=new StudentService();
		Student stud=sService.deleteStudent(1);
		assertNotNull(stud);
	}
}