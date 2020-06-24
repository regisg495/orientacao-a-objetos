package restricoes_imutabilidade.Time;

class Time {
private int segundos;

	Time(){
	
	}
	
	Time(Time x){ 
	x.segundos = segundototal(x.hours(), x.minutes(), x.seconds());
	} 
	
	Time(int horas, int minutos, int segundos){
	segundototal(horas, minutos, segundos);

	}

	void plus(Time x){
	this.segundos += segundototal(x.hours(), x.minutes(), x.seconds());
	} 
	void plusHours(int x) {
	this.segundos  += (this.segundos+x*3600 > 86400) ?  -86400+x*3600 : x*3600;
	}
	
	void plusMinutes(int x) { 
		this.segundos += x * 60;
	}
	void plusSeconds(int x) {
		this.segundos += x % 60;
	}

	void shift() {
		this.segundos  += (this.segundos>43200) ? -43200:43200;	
	}

	
	void tick() {
		this.segundos += 1; //soma 1 segundo
	}
	
	public int segundototal(int hora, int minuto, int segundo) {
		return this.segundos = (hora * 3600) + (minuto * 60) + segundo;
	}
	
	public int hours(){;
		return this.segundos / 3600; 
	}
	public int minutes() {
		return this.segundos % 3600 / 60;
	}
	public int seconds() { 
		return this.segundos % 60;
	}

	
	public boolean equals(Time x) {
	    return this.segundos == x.segundos;
		}
	  

	@Override
	public String toString() {
		return
		((hours() < 10) ? "0" : "") + hours() + ":" +
		((minutes() < 10) ? "0" : "") + minutes() + ":" +
		((seconds() < 10) ? "0" : "") + seconds();
	}


	}

public class Main {
	public static void main(String[] args) {
		Time t1 = new Time();
		System.out.println(t1.toString().equals("00:00:00"));
		Time t2 = new Time(1, 40, 5);
		System.out.println(t2.toString().equals("01:40:05"));
		t1.plus(t2);
		System.out.println(t1.toString().equals("01:40:05"));
		System.out.println(t1.hours() == 1);
		System.out.println(t1.minutes() == 40);
		System.out.println(t1.seconds() == 05);
		t1.plus(t2);
		System.out.println(t1);
		System.out.println(t1.toString().equals("03:20:10"));
		System.out.println(t1.hours() == 3);
		System.out.println(t1.minutes() == 20);
		System.out.println(t1.seconds() == 10);
		System.out.println(t2.hours() == 1);
		System.out.println(t2.minutes() == 40);
		System.out.println(t2.seconds() == 05);
		t2.plusHours(1);
		System.out.println(t2);
		System.out.println(t2.toString().equals("02:40:05"));
		t2.plusMinutes(10);
		System.out.println(t2.toString().equals("02:50:05"));
		t2.plusSeconds(10);
		System.out.println(t2.toString().equals("02:50:15"));
		System.out.println(t2.hours() == 2);
		System.out.println(t2.minutes() == 50);
		System.out.println(t2.seconds() == 15);
		Time t3 = new Time(t2);
		System.out.println(t3);
		t3.plusHours(20);
		System.out.println(t3.hours() == 22);
		System.out.println(t3.minutes() == 50);
		System.out.println(t3.seconds() == 15);
		t3.plusHours(6);
		System.out.println(t3.toString().equals("04:50:15"));
		t3.plusMinutes(20);
		System.out.println(t3.toString().equals("05:10:15"));
		t3.plusSeconds(50);
		System.out.println(t3.toString().equals("05:11:05"));
		System.out.println(t3);
		Time t4 = new Time(t3);
		System.out.println(t4.hours() == 5);
		System.out.println(t4.minutes() == 11);
		System.out.println(t4.seconds() == 5);
		t4.shift(); // inverte o turno +12/-12h
		System.out.println(t4.hours() == 17);
		System.out.println(t4.minutes() == 11);
		System.out.println(t4.seconds() == 5);
		System.out.println(t4);
		t4.tick();
		System.out.println(t4.hours() == 17);
		System.out.println(t4.minutes() == 11);
		System.out.println(t4.seconds() == 6);
		t4.plusSeconds(53);
		System.out.println(t4.toString().equals("17:11:59"));
		t4.tick();
		System.out.println(t4.toString().equals("17:12:00"));
		// at� aqui 0.4
		Time t5 = new Time(17, 12, 0);
		System.out.println(t4.equals(t5) == true);
		t5.tick();
		System.out.println(t4.equals(t5) == false);
		System.out.println(new Time().equals(new Time()) == true);
		// at� aqui 0.6
	}

}

