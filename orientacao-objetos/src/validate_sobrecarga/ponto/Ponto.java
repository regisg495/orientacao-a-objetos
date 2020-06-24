package validate_sobrecarga.ponto;

import validate_sobrecarga.tempodecorrido.TimeSpan;
import validate_sobrecarga.time.Time;

public class Ponto {

	private String nome;
	private boolean bateuPonto[] = new boolean[2];
	private TimeSpan entrada = null;
	private TimeSpan saida = null;

	public Ponto(String nome) {
		this.nome = nome;
		this.bateuPonto[0] = false;
		this.bateuPonto[1] = false;

	}

	public void bater(int hours, int minutes, int seconds) {
		if(this.bateuPonto[1]) {
			throw new IllegalStateException("Entrada e saída já foram batidas e o ponto está fechado");
		}
		if(!this.bateuPonto[0]) {
			this.entrada = new TimeSpan(hours, minutes, seconds);
			this.bateuPonto[0] = true;
		} else {
			this.saida = new TimeSpan(hours, minutes, seconds);
			this.bateuPonto[1] = true;
		}



	}

	public String toString() {
		if(this.entrada == null || this.saida == null) return "";

		Time t = new Time(this.entrada.getHours(), this.entrada.getMinutes(), this.entrada.getSeconds());
		Time t2 = new Time(this.saida.getHours(), this.saida.getMinutes(), this.saida.getSeconds());
		Time t3 = t2.minus(t);
		TimeSpan ts = new TimeSpan(t3.getHours(), t3.getMinutes(), t3.getSeconds());
		return this.nome + " entrou às " + t.toString() + " e saiu às " + t2.toString() + " e permaneceu " + ts.toString("pt");
	}


}
