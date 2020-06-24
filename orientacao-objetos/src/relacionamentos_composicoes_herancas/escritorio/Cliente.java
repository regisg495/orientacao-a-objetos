package relacionamentos_composicoes_herancas.escritorio;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Pessoa {
	private Antecedentes antecedentes;
	private ArrayList<Processo> processo = new ArrayList<>();
	private Status status;

	public Cliente(String nome, String cpf, Genero genero, LocalDate datanascimento, Antecedentes antecedentes,
			Status status) {
		super(nome, cpf, genero, datanascimento);
		this.antecedentes = antecedentes;
		this.status = status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public Antecedentes getAntecedentes() {
		return antecedentes;
	}

	public Antecedentes ValidateAnt(Processo c) {
		if (c.getTipo().toString().equals("Criminal")) {
			return this.antecedentes = Antecedentes.Sim;
		}
		return this.antecedentes;
	}

	public String toString() {
		return "Nome: " + this.getNome() + ", CPF: " + this.getCpf() + " Genero: " + this.getGenero()
				+ ", Data de Nascimento: " + this.getDatanascimento() + ", Antecedentes: " + (this.antecedentes)
				+ ", Processo: " + (this.processo);
	}

	public ArrayList<Processo> getProcesso() {
		return processo;
	}

	public void addProcesso(Processo c) {
		this.processo.add(c);
		ValidateAnt(c);
	}

	public void deleteProcesso(Processo c) {
		this.processo.remove(c);
	}

	public String pesquisarSituacaoCliente() {
		return "" + this;
	}

}
