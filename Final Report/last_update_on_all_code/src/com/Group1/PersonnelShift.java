package com.Group1;

import java.util.ArrayList;

enum Days {
	Monday,
	Tuesday,
	Wednesday,
	Thursday,
	Friday,
	Saturday,
	Sunday
}

enum Shifts {
	daytime, // 08.00 - 16.00
	evening, // 16.00 - 00.00
	night // 00.00 - 08.00
}

public class PersonnelShift {

	private ArrayList<Days> workdays;
	private Shifts shift;

	public PersonnelShift() {
		workdays = new ArrayList<>();
		workdays.add(Days.Monday);
		workdays.add(Days.Tuesday);
		workdays.add(Days.Wednesday);
		workdays.add(Days.Thursday);
		workdays.add(Days.Friday);

		shift = Shifts.daytime;
	}

	public PersonnelShift (ArrayList<Days> days) {
		workdays = new ArrayList<>(days);
		shift = Shifts.daytime;
	}

	public PersonnelShift (ArrayList<Days> days, Shifts s) {
		workdays = new ArrayList<>(days);
		shift = s;
	}
}
