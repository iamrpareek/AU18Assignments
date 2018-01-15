@interface Student{
	int rollno();
	String name();
}



public class AnnotationQuest {
	public static void main(String args[]) {
		
	}
	@Student(rollno=7,name="Rahul")
	public String toString() {
		return "Overriden toString method";
	}

}

