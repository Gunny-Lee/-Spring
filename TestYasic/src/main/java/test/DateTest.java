package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		time.setHours(10);
		String timestring = format.format(time);
		System.out.println(timestring);
	}

}
