import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DTQuest {
	public static void main(String args[]) {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");

		df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		String IST = df.format(d);
		System.out.println("Indian Timezone : "+IST);
		
		df.setTimeZone(TimeZone.getTimeZone("Canada/Saskatchewan"));
		String CST = df.format(d);
		System.out.println("Saskatchewan Timezone : "+CST);

		df.setTimeZone(TimeZone.getTimeZone("Europe/Copenhagen"));
		String EST = df.format(d);
		System.out.println("Copenhagen Timezone : "+EST);

		df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		String LST = df.format(d);
		System.out.println("Los Angeles Timezone : "+LST);
	}
}
