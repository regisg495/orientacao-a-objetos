package validate_sobrecarga.time;

public class Time {

	private int segundos;

	public Time(int horas, int minutos, int segundos) {
		this.segundos = validaHoras(horas) + (minutos * 60) + segundos;
	}

	public int validaHoras(int horas) {
		if(horas < 0) {
			return 86400 - (horas * 3600 * -1);
		} else {
			return horas * 3600;
		}

	}

	public Time() {
		this.segundos = 0;
	}

	public Time(int hours, int minutes) {
		this.segundos = (hours * 3600) + (minutes * 60);
	}

	public int getSegundos() {
		return segundos;
	}

	public int getHours() {
		return this.segundos / 3600;
	}
	public int getMinutes() {
		return this.segundos % 3600 / 60;
	}
	public int getSeconds() {
		return this.segundos % 3600 % 60;
	}


	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}


	public Time plus(Time t) {
		return new Time(t.getHours() + this.getHours(), t.getMinutes() + this.getMinutes(), t.getSeconds() + this.getSeconds());
	}
	public String toString() {
		return ((this.getHours() < 10) ? "0" + this.getHours() : this.getHours()) +
				":" + ((this.getMinutes() < 10) ? "0" + this.getMinutes() : this.getMinutes()) +
						":" + ((this.getSeconds() < 10) ? "0" + this.getSeconds() : this.getSeconds());
	}

	public Time plusHours(int hours) {
		if(hours * 3600 + this.segundos > 86400) {
			this.segundos = this.segundos + (hours * 3600) - 86400;
			return new Time(this.getHours(), this.getMinutes(), this.getSeconds());
		} else {
			return new Time(this.getHours() + hours, this.getMinutes(), this.getSeconds());
		}

	}
	public Time plusMinutes(int minutes) {
		if(minutes * 60 + this.segundos > 86400) {
			this.segundos = this.segundos + (minutes * 60) - 86400;
			return new Time(this.getHours(), this.getMinutes(), this.getSeconds());
		}
		return new Time(this.getHours(), this.getMinutes() + minutes, this.getSeconds());
	}

	public Time plusSeconds(int segundos) {
		if(segundos + this.segundos > 86400) {
			this.segundos = this.segundos + segundos - 86400;
			return new Time(this.getHours(), this.getMinutes(), this.getSeconds());
		}
		return new Time(this.getHours(), this.getMinutes(), this.getSeconds() + segundos);
	}
	public boolean equals(Time t) {
		return this.segundos == t.segundos;
	}

	public Time minusHours(int hours) {
		if(((hours * 3600) * - 1) + this.segundos < 0) {
			this.segundos = this.segundos - (hours * 3600) + 86400;
			return new Time(this.getHours(), this.getMinutes(), this.getSeconds());
		} else {
			return new Time(this.getHours() - hours, this.getMinutes(), this.getSeconds());
		}
	}

	public Time minusMinutes(int minutes) {
		if(((minutes * 60) * - 1) + this.segundos < 0) {
			this.segundos = this.segundos - (minutes * 60) + 86400;
			return new Time(this.getHours(), this.getMinutes(), this.getSeconds());
		} else {
			return new Time(this.getHours(), this.getMinutes() - minutes, this.getSeconds());
		}
	}

	public Time minusSeconds(int seconds) {
		if((seconds  * - 1) + this.segundos < 0) {
			this.segundos = this.segundos - seconds + 86400;
			return new Time(this.getHours(), this.getMinutes(), this.getSeconds());
		} else {
			return new Time(this.getHours(), this.getMinutes(), this.getSeconds() - seconds);
		}
	}

	public Time minus(Time t) {

		Time t2 = minusHours(t.getHours()).minusMinutes(t.getMinutes()).minusSeconds(t.getSeconds());
		return t2;

	}

	public boolean isMidDay() {
		return this.segundos == 43200;
	}

	public boolean isMidNight() {
		return this.segundos == 0;
	}

	public Time shift() {
		if(this.segundos >= 43200) {
			this.segundos -= 43200;
			return new Time(this.getHours(), this.getMinutes(), this.getSeconds());
		} else {
			this.segundos += 43200;
			return new Time(this.getHours(), this.getMinutes(), this.getSeconds());
		}

	}

	public Time tick() {
		Time t = this.plusSeconds(1);
		return t;
	}



}
