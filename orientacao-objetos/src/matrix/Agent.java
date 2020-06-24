package matrix;

public class Agent extends Person {
	// Construtor e toString()
	public Agent(String sobrenome) {
		super(sobrenome);
	}

	public String toString() {
		return "Agent " + this.getApelido();
	}

}
