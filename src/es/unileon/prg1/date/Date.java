package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth(this.month) ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	public void setYear (int year) {
		this.year = year;
	}

	public int getYear(){
		return this.year;
	}

	public int getMonth(){
		return this.month;
	}

	public int getDay(){
		return this.day;
	}

	/*public void isSameYear(Date otherDate){
		if(this.year == otherDate.getYear()){
			System.out.println("Los años son iguales");
		}else{
			System.out.println("Los años no son iguales");
		}
	}*/

	public void isSameYear(Date otherDate){
		boolean isSame = false;
		isSame = this.year == otherDate.getYear();

		System.out.println("El resultado de si los años son iguales es: " + isSame);
	}

	/*public void isSameMonth(Date otherDate){
		if(this.month == otherDate.getMonth()){
			System.out.println("Los meses son iguales");
		}else{
			System.out.println("Los meses no son iguales");
		}
	}*/

	public void isSameMonth(Date otherDate){
		boolean isSame = false;
		isSame = this.month == otherDate.getMonth();

		System.out.println("El resultado de si los meses son iguales es: " + isSame);
	}

	/*public void isSameDay(Date otherDate){
		if(this.day == otherDate.getDay()){
			System.out.println("Los dias son iguales");
		}else{
			System.out.println("Los dias no son iguales");
		}
	}*/

	public void isSameDay(Date otherDate){
		boolean isSame = false;
		isSame = this.day == otherDate.getDay();

		System.out.println("El resultado de si los dias son iguales es: " + isSame);
	}

	/*public void isSame(Date otherDate){
		if((this.year == otherDate.getYear()) && (this.month == otherDate.getMonth()) && (this.day == otherDate.getDay())){
			System.out.println("Las fechas son iguales");
		}else{
			System.out.println("Las fechas no son iguales");
		}
	}*/

	public void isSame(Date otherDate){
		int contador = 0;
		boolean isSame = true;
		isSame = this.year == otherDate.getYear();

		while((isSame == true) && (contador < 1)){
			isSame = this.year == otherDate.getYear();
			isSame = this.month == otherDate.getMonth();
			isSame = this.day == otherDate.getDay();
			contador++;
		}

		System.out.println("El resultado de si las fechas son iguales es: " + isSame);
	}
	
	private int getDaysOfMonth(int mes) {
		int numDays;
		
		numDays = 0;
		switch (mes) {
			case 1: //next
			case 3: //next
			case 5: //next
			case 7: //next
			case 8: //next
			case 10: //next
			case 12:
				numDays = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				numDays = 30;
				break;
			case 2:
				numDays = 28;
				break;			
		}
		
		return numDays;
	}

	public StringBuffer nameOfMonth(int mes){
		StringBuffer cadena = new StringBuffer();

		switch(mes){
			case 1:
				cadena.append("Enero");
				break;
			case 2:
				cadena.append("Febrero");
				break;
			case 3:
				cadena.append("Marzo");
				break;
			case 4:
				cadena.append("Abril");
				break;
			case 5:
				cadena.append("Mayo");
				break;
			case 6:
				cadena.append("Junio");
				break;
			case 7:
				cadena.append("Julio");
				break;
			case 8:
				cadena.append("Agosto");
				break;
			case 9:
				cadena.append("Septiembre");
				break;
			case 10:
				cadena.append("Octubre");
				break;
			case 11:
				cadena.append("Noviembre");
				break;
			case 12:
				cadena.append("Diciembre");
		}

		return cadena;
	}

	public StringBuffer seasonOfMonth(int mes){
		StringBuffer cadena = new StringBuffer();

		switch(mes){
			case 3:
			case 4:
			case 5:
				cadena.append("Primavera");
				break;
			case 6:
			case 7:
			case 8:
				cadena.append("Verano");
				break;
			case 9:
			case 10:
			case 11:
				cadena.append("Otoño");
				break;
			case 12:
			case 1:
			case 2:
				cadena.append("Invierno");
				break;
		}

		return cadena;
	}

	public void monthsTillEndOfYear(){
		System.out.print("Los meses que quedan hasta final de año son: ");

		for(int i = this.month + 1; i <= 12; i++){
			System.out.print(nameOfMonth(i));
			System.out.print(" ");
		}

		System.out.println();
	}

	public void dateInString(){
		StringBuffer cadena = new StringBuffer();

		String cadenaAux1 = "";
		String cadenaAux2 = "";
		String cadenaAux3 = "";

		cadenaAux1 = String.valueOf(this.day);
		cadenaAux2 = String.valueOf(this.month);
		cadenaAux3 = String.valueOf(this.year);

		cadena.append(cadenaAux1);
		cadena.append('/');
		cadena.append(cadenaAux2);
		cadena.append('/');
		cadena.append(cadenaAux3);

		System.out.println("La fecha introducida pasada a String es: " + cadena.toString());
	}

	public void daysTillEndOfMonth(){
		StringBuffer cadena = new StringBuffer();

		cadena.append('/');
		cadena.append(this.month);
		cadena.append('/');
		cadena.append(this.year);

		System.out.println("Los fechas que quedan hasta final del mes son: ");

		for(int i = this.day + 1; i <= getDaysOfMonth(this.month); i++){
			cadena.insert(0, i);
			System.out.println(cadena);
			cadena.delete(0, 2);
		}
	}

	public void monthWithSameDays(){
		System.out.println("Los meses que tienen el mismo numero de dias que el mes introducido son:");
		for(int i = 1; i <= 12; i++){
			if(getDaysOfMonth(this.month) == getDaysOfMonth(i)){
				System.out.println(nameOfMonth(i));
			}
		}
	}

	public int numberOfDays(){
		int suma = 0;
		for(int i = 1; i <= this.month; i++){
			if(i == this.month){
				suma = suma + this.day;
			}else{
				suma = suma + getDaysOfMonth(i);
			}
		}
		return suma;
	}

	/*public void randomDate(){
		int diaAleatorio = 0, mesAleatorio = 0, contador = 0;
		boolean esIgualDia = false, esIgualMes = false;

		while((esIgualDia == false) || (esIgualMes == false)){
			if(diaAleatorio == this.day){
				esIgualDia = true;
			}else{
				diaAleatorio = (int) (Math.random() * 30 + 1);
				System.out.println("Dia: " + diaAleatorio);
			}

			if(mesAleatorio == this.month){
				esIgualMes = true;
			}else{
				mesAleatorio = (int) (Math.random() * 11 + 1);
				System.out.println("Mes: " + mesAleatorio);
			}
			contador++;
		}
		System.out.println("El numero de intentos que han sido necesarios para acertar la fecha es: " + contador);
	}*/

	public void randomDate(){
		int diaAleatorio = 0, mesAleatorio = 0, contador = 0;
		boolean esIgualDia = false, esIgualMes = false;

		do{
			if(diaAleatorio == this.day){
				esIgualDia = true;
			}else{
				diaAleatorio = (int) (Math.random() * getDaysOfMonth(this.month) + 1);
			}

			if(mesAleatorio == this.month){
				esIgualMes = true;
			}else{
				mesAleatorio = (int) (Math.random() * 12 + 1);
			}
			contador++;
		}while((esIgualDia == false) || (esIgualMes == false));

		System.out.println("El numero de intentos que han sido necesarios para acertar la fecha es: " + contador);
	}

	public void dayOfTheWeek(String dia1){
		int dias = 0, numSemanas = 0, diaDeLasemana = 0;

		dias = numberOfDays();
		numSemanas = dias % 7;
		diaDeLasemana = (numSemanas + positionOfTheWeek(dia1)) % 7;

		System.out.println("El dia de la semana que has introducido es: " + nameOfDay(diaDeLasemana - 1));
	}

	private int positionOfTheWeek(String dia1){
		switch(dia1){
			case "Lunes":
				return 1;
			case "Martes":
				return 2;
			case "Miercoles":
				return 3;
			case "Jueves":
				return 4;
			case "Viernes":
				return 5;
			case "Sabado":
				return 6;
			default:
				return 0;
		}
	}

	private String nameOfDay(int dia){
		StringBuffer cadena = new StringBuffer();

		switch(dia){				
			case 1:
				cadena.append("Lunes");
				break;
			case 2:
				cadena.append("Martes");
				break;
			case 3:
				cadena.append("Miercoles");
				break;
			case 4:
				cadena.append("Jueves");
				break;
			case 5:
				cadena.append("Viernes");
				break;
			case 6:
				cadena.append("Sabado");
				break;
			default:
				cadena.append("Domingo");
				break;
		}
		return cadena.toString();
	}
	
	public String toString(){

		return this.day + "/" + this.month + "/" + this.year;
	}

}
