package identidade_estados;

public class Porta {
	
	final double largura;
	final double altura;
	final String material;
	boolean trancada;
	boolean fechada;
	boolean aberta;
	boolean destrancada;
	
	
	Porta(double largura, double altura, String material) {
		  this.largura = largura;
		  this.altura = altura;
		  this.material = material;
		  this.trancada = false;
		  this.fechada = true;
		  this.aberta = false;
		  this.destrancada = true;
		  }
	
	void abrir() {
		if(this.destrancada) {
			this.aberta = !this.aberta;
			this.fechada = !this.fechada;
		}
	}

	void fechar() {
		this.aberta = !this.aberta;
		this.fechada = !this.fechada;
		}
	
	void destrancar() {
		this.trancada = !this.trancada;
		this.destrancada = !this.destrancada;
	}
	void trancar() {
		if(this.fechada) {
		this.destrancada = !this.destrancada;
		this.trancada = !this.trancada;
		}
		
	}
	
	public boolean aberta() {
		return this.aberta;
	}
	public boolean fechada() {
		return this.fechada;
	}
	public boolean trancada() {
		return this.trancada;
	}
	public boolean destrancada() {
		return this.destrancada;
	}

}
