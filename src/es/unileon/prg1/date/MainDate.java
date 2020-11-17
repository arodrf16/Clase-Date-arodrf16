package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		Date today;
		Date otherDate;
		
		try {
			today = new Date(25,10,2020);
			otherDate = new Date(10,3,2020);
			System.out.println(today);
			System.out.println("El mes que has introducido es: " + today.nameOfMonth(today.getMonth()));
			System.out.println("La estacion de la fecha seleccionada es: " + today.seasonOfMonth(today.getMonth()));
			today.isSameYear(otherDate);
			today.isSameMonth(otherDate);
			today.isSameDay(otherDate);
			today.isSame(otherDate);
			today.monthsTillEndOfYear();
			today.dateInString();
			today.daysTillEndOfMonth();
			today.monthWithSameDays();
			System.out.println("El numero de dias desde que empezo el año es: " + today.numberOfDays());
			today.randomDate();
			today.dayOfTheWeek("Miercoles");
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
	}

}
