package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import date.Date;
import time.Time;

public class Loop implements Actions {

	static STATE current_state = STATE.TIME;
	LocalTime chooseTime;
	LocalDate chooseDate;
	static Time time = new Time();
	Date date = new Date();

	public void mainLoop() {
		String input = "";
		Scanner s = new Scanner(System.in);

		while (input != "quit") {
		    showTime();
		    System.out.println("Vad önskar du att göra?\n" + "1. Sätta en tid?\n" + "2. Kolla datum?");
		    input = s.nextLine().trim();
		    switch (input) {
		        case "1":
		            chooseTime();
		            int inputHour = Integer.parseInt(s.nextLine());
		            System.out.println("Skriv in minut");
		            int inputMinut = Integer.parseInt(s.nextLine());
		            chooseTime = LocalTime.of(inputHour, inputMinut);
		            System.out.println("Vald tid: " + chooseTime);
		            break;
		        case "2":
		            while (true) { 
		                showDate();
		                System.out.println("Vad önskar du att göra?\n" + "1. Sätta ett datum?\n" + "2. Kolla tiden?\n");
		                String chooseAtDate = s.nextLine();
		                if (chooseAtDate.equals("1")) {
		                    chooseDate();
		                    System.out.println("Skriv in år");
		                    int chooseYear = Integer.parseInt(s.nextLine());
		                    System.out.println("Skriv in månad");
		                    int chooseMonth = Integer.parseInt(s.nextLine());
		                    System.out.println("Skriv in dag");
		                    int chooseday = Integer.parseInt(s.nextLine());
		                    chooseDate = LocalDate.of(chooseYear, chooseMonth, chooseday);
		                } else if (chooseAtDate.equals("2")) {
		                    break; 
		                }
		            }
		            break;
		    }
		}

	}

	enum STATE {
		TIME, CHANGETIME, DATE, CHANGEDATE
	}

	@Override
	public void chooseTime() {
		current_state = STATE.CHANGETIME;
		System.out.println("current state " + current_state);
		System.out.println("Skriv in timme");
	}

	@Override
	public void chooseDate() {
		current_state = STATE.CHANGEDATE;
		System.out.println("current state " + current_state);
	}

	@Override
	public void showTime() {
		current_state = STATE.TIME;
		System.out.println("current state " + current_state);
		if (chooseTime == null) {
			System.out.println("Valt klockslag: " + time.getTime());
		} else {
			System.out.println("Valt klockslag: " + chooseTime);
		}
	}

	@Override
	public void showDate() {
		current_state = STATE.DATE;
		System.out.println("current state " + current_state);
		if (chooseDate == null) {
			System.out.println("Valt datum: " + date.getDate());
		} else {
			System.out.println("Valt datum:" + chooseDate);
		}
	}

}
