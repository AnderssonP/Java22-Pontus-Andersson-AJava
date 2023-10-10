package time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import main.Main;

public class Time extends Main{
	
	private static LocalTime time = LocalTime.now();

	public String getTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formateradTid = time.format(formatter);
		return formateradTid;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	
}
