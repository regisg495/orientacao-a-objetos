package validate_sobrecarga.tempodecorrido;

public class TimeSpan {

	private int days;
	private int hours;
	private int minutes;
	private int seconds;

	public TimeSpan(int day, int hours, int minutes, int seconds) {
		if(day == 0 && hours == 0 && minutes == 0 && seconds == 0) {
			throw new IllegalArgumentException("Can't be zero");
		}
		if(day < 0 || hours < 0 || minutes < 0 || seconds < 0) {
			throw new IllegalArgumentException("Can't be negative");
		}

		int segundo = (day * 86400) + (hours * 3600) + (minutes * 60) + seconds;
		this.days = segundo / 86400;
		this.hours = segundo % 86400 / 3600;
		this.minutes = segundo % 86400 % 3600 / 60;
		this.seconds = segundo % 86400 % 3600 % 60;
	}

	public TimeSpan(int hours, int minutes, int seconds) {
		if(hours == 0 && minutes == 0 && seconds == 0) {
			throw new IllegalArgumentException("Can't be zero");
		}
		if(hours < 0 || minutes < 0 || seconds < 0) {
			throw new IllegalArgumentException("Can't be negative");
		}
		int segundo = (hours * 3600) + (minutes * 60) + seconds;
		this.hours = segundo / 3600;
		this.minutes = segundo % 3600 / 60;
		this.seconds = segundo % 3600 % 60;
	}
	public TimeSpan() {

	}


	public int getDays() {
		return days;
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}
	public String format(TimeSpan ts) {
		String s = "";
		if(ts.days == 1) {
			s = ts.days + " day";
		} else if(ts.days > 1) {
			s = ts.days + " days";
		}
		if (ts.hours == 1 && ts.days > 0) {
			s += ", " + ts.hours + " hour";
		} else if(ts.hours > 1 && ts.days > 0) {
			s += ", " + ts.hours + " hours";
		} else if(ts.hours == 1 && ts.days <= 0) {
			s += ts.hours + " hour";
		} else if(ts.hours > 1 && ts.days <= 0) {
			s+= ts.hours + " hours";
		}

		if(ts.minutes == 1 && ts.days <= 0 && ts.hours <= 0) {
			s += ts.minutes + " minute";
		} else if(ts.minutes > 1 && ts.days <= 0 && ts.hours <= 0) {
			s += ts.minutes + " minutes";
		} else if(ts.minutes == 1 && (ts.days >= 1 || ts.hours >= 1)) {
			s += ", " + ts.minutes + " minute";
		} else if(ts.minutes > 1 && (ts.days >= 1 || ts.hours >= 1)) {
			s += ", " + ts.minutes + " minutes";
		}


		if(ts.seconds == 1 && ts.days <= 0 && ts.minutes <= 0 && ts.seconds <= 0) {
			s +=  ts.seconds + " second";
		} else if(ts.seconds > 1 && ts.days <= 0 && ts.hours <= 0 && ts.minutes <= 0) {
			s += ts.seconds + " seconds";
		} else if(ts.seconds == 1 && (ts.days >= 1 || ts.hours >= 1 || ts.minutes >= 1)) {
			s += " e " + ts.seconds + " second";
		} else if(ts.seconds > 1 && (ts.days >= 1 || ts.hours >= 1 || ts.minutes >= 1)) {
			s += " e " + ts.seconds + " seconds";
		}

		return s;
	}
		public String formatPt(TimeSpan ts) {
			String s = "";
			if(ts.days == 1) {
				s = ts.days + " dia";
			} else if(ts.days > 1) {
				s = ts.days + " dias";
			}
			if (ts.hours == 1 && ts.days > 0) {
				s += ", " + ts.hours + " hora";
			} else if(ts.hours > 1 && ts.days > 0) {
				s += ", " + ts.hours + " horas";
			} else if(ts.hours == 1 && ts.days <= 0) {
				s += ts.hours + " hora";
			} else if(ts.hours > 1 && ts.days <= 0) {
				s+= ts.hours + " horas";
			}

			if(ts.minutes == 1 && ts.days <= 0 && ts.hours <= 0) {
				s += ts.minutes + " minuto";
			} else if(ts.minutes > 1 && ts.days <= 0 && ts.hours <= 0) {
				s += ts.minutes + " minutos";
			} else if(ts.minutes == 1 && (ts.days >= 1 || ts.hours >= 1)) {
				s += ", " + ts.minutes + " minuto";
			} else if(ts.minutes > 1 && (ts.days >= 1 || ts.hours >= 1)) {
				s += ", " + ts.minutes + " minutos";
			}


			if(ts.seconds == 1 && ts.days <= 0 && ts.minutes <= 0 && ts.seconds <= 0) {
				s +=  ts.seconds + " segundo";
			} else if(ts.seconds > 1 && ts.days <= 0 && ts.hours <= 0 && ts.minutes <= 0) {
				s += ts.seconds + " segundos";
			} else if(ts.seconds == 1 && (ts.days >= 1 || ts.hours >= 1 || ts.minutes >= 1)) {
				s += " e " + ts.seconds + " segundo";
			} else if(ts.seconds > 1 && (ts.days >= 1 || ts.hours >= 1 || ts.minutes >= 1)) {
				s += " e " + ts.seconds + " segundos";
			}

			return s;
		}


	public String toString() {
		return format(this);
	}

	public String toString(String param) {
		if(param.equals("pt")) {
			return formatPt(this);
		} else {
			throw new UnsupportedOperationException("Não temos essa opção");
		}
	}

	public boolean greaterThan(TimeSpan ts) {
		int s1 = (this.days * 86400) + (this.hours * 3600) + (this.minutes * 60) + this.seconds;
		int s2 = (ts.days * 86400) + (ts.hours * 3600) + (ts.minutes * 60) + ts.seconds;
		return s1 > s2;
	}

	public boolean lessThan(TimeSpan ts) {
		int s1 = (this.days * 86400) + (this.hours * 3600) + (this.minutes * 60) + this.seconds;
		int s2 = (ts.days * 86400) + (ts.hours * 3600) + (ts.minutes * 60) + ts.seconds;
		return s1 < s2;
	}
	public boolean equals(TimeSpan ts) {
		int s1 = (this.days * 86400) + (this.hours * 3600) + (this.minutes * 60) + this.seconds;
		int s2 = (ts.days * 86400) + (ts.hours * 3600) + (ts.minutes * 60) + ts.seconds;
		return s1 == s2;
	}
}
