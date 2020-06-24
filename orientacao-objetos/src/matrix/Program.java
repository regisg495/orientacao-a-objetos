package matrix;

public class Program extends Person {
	/*
	 * Construtores que extends Person Tive que refazer toda essa porcaria, tinha
	 * feito aqui Como newProgram, tu viu at� na foto kkkkkkkkkkk Mas depois que
	 * percebi que s� quando ele � instanciado na Matrix ele � um newProgram,
	 * newAgent, newHuman, � isso que d� ter feito direito e ter visto s� filmes
	 * jur�dicos, eu nunca tinha visto Matrix. Aqui tem o toString() tamb�m
	 */

	public Program(String alias) {
		super(alias);
	}

	public String toString() {
		return "The " + this.getApelido();
	}

}
