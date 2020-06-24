package identidade_estados;

public class Forno {
	
	final String marca;
	final String modelo;
	final String cor;
	final int voltagem;
	final int alimentação;
	final double largura;
	final double altura;
	final double capacidade;
	private int temperatura; 
	final boolean inox;
	boolean ligar;
	boolean dourar;
	boolean assar;
	boolean luz;
	
	Forno(String marca, String modelo, String cor, int voltagem, int alimentação, double largura, double altura, double capacidade, boolean inox){
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.voltagem = voltagem;
		this.alimentação = alimentação;
		this.largura = largura;
		this.altura = altura;
		this.capacidade = capacidade;
		this.inox = inox;
		this.ligar = false;
		this.dourar = false;
		this.assar = false;
		this.luz = false;
	}
	void ligar() {
		this.ligar = true;
		temperatura = 150;
	}
	void desligar() {
		this.ligar = false;
		temperatura = 0;
	}
	void aumentartemperatura() {
		if((this.ligar) & (temperatura<300))   {
			this.temperatura += 1;
		}
	}
	void diminuirtemperatura() {
	if((this.ligar) & (temperatura>100)) {
			this.temperatura -= 1;
		}
	}
	void dourar() {
		if(this.ligar) {
		this.dourar = true;
		this.assar = false;
		temperatura = 100;
		}
	}
	void assar() {
		if(this.ligar) {
			temperatura = 300;
			this.assar = true;
			this.dourar = false;
		}
	}
	void ligarluz() {
		if(this.ligar) {
			this.luz = true;
		}
	}
	public int temperatura() {
		return this.temperatura;
	}
	public boolean ligadadesligada() {
		return this.ligar;
	}
	public boolean dourarligado() {
		return this.dourar;
	}
	public boolean luz() {
		return this.luz;
	}

}
