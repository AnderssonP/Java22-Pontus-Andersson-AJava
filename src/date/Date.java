package date;

import java.time.LocalDate;

import main.Main;

public class Date extends Main{
	
	private LocalDate date = LocalDate.now();
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


}
