package relacionamentos_composicoes_herancas.escritorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public final class Advogado extends Pessoa {
	final String OAB;
	private HashSet<Especialidade> especialidades = new HashSet<>();

	public Advogado(String nome, String cpf, Genero genero, LocalDate datanascimento, String oAB) {
		super(nome, cpf, genero, datanascimento);
		if(!IsOAB(oAB)) throw new OABInexistenteException(); 
		this.OAB = oAB;
		
	}

	public boolean IsOAB(String oab) {
		for (int x = 0; x < oab.length(); x++) {
			if ((oab.charAt(x) < 48) || (oab.charAt(x) > 57)) {
				return false;
			}
		}
		return true;
	}

	public String getOAB() {
		return OAB;
	}

	@Override
	public String toString() {
		return "Nome: " + validate(this.getNome()) + ", CPF: " + validate(this.getCpf()) + " Genero: "
				+ this.getGenero() + ", Data de Nascimento: " + this.getDatanascimento() + ", OAB: "
				+ validate(this.OAB) + ", Especialidades: " + this.especialidades;

	}

	public HashSet<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void addEspecialidade(Especialidade a) {
		this.especialidades.add(a);
	}

}
