package matrix;

public class Human extends Person {
	// Construtores, extends, e toString com valida��es
	public Human(String sobrenome, String nome) {
		super(sobrenome, nome);

	}

	public Human(String alias) {
		super(alias);
	}

	public Human(String sobrenome, String segundonome, String nome) {
		super(sobrenome, segundonome, nome);
	}

	public String toString() {
		return (this.getApelido() != null ? this.getApelido() : "Mr. " + this.getSobrenome());
	}

}
