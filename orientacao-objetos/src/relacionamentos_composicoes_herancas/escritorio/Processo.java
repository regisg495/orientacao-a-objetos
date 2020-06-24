package relacionamentos_composicoes_herancas.escritorio;

import java.util.ArrayList;

public class Processo {
	private String numproc;
	private final Especialidade tipo; // � reaproveitada, j� que os tipos
	// S�o iguais �s especializa��es

	public String getNumproc() {
		return numproc;
	}

	public Especialidade getTipo() {
		return tipo;
	}

	Processo(String numproc, Especialidade c) {
		this.numproc = numproc;
		this.tipo = c;
	}

	public String toString() {
		return this.getNumproc() + " : " + this.getTipo();
	}

}
