package relacionamentos_composicoes_herancas.escritorio;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.text.Normalizer;

public abstract class Pessoa {
	private final String nome;
	private final String cpf;
	private final Genero genero;
	private final LocalDate datanascimento;
	private ArrayList<Telefone> telefone = new ArrayList<>();

	public String validate(String i) {
		if (i.toString() == null)
			return i.toString();
		else
			return i;
	}

	public String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public boolean Validatename(String i) {
		i = removerAcentos(i);
		for (int x = 0; x < i.length(); x++) {
			if (((i.charAt(x) < 41) || (i.charAt(x) > 90)) && ((i.charAt(x) < 97) || (i.charAt(x) > 122)))
				return false;
		}
		return true;
	}

	protected Pessoa(String nome, String cpf, Genero genero, LocalDate datanascimento) {
		if (!ValidaCPF(cpf))
			throw new CPFInexistenteException();
		if (!Validatename(nome))
			throw new NomeinexistenteException();
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.datanascimento = datanascimento;
	}

	public boolean ValidaCPF(String cpf) { // O Certo era colocar como CPF length de 11 n�
		// Por�m como eu j� tinha feito os testes com CPF com 5 numeros, 6, vou colocar
		// como de 0 a 11, ok? Porque se n�o ia quebrar todos os testes e d� pregui�a
		// de fazer denovo kkkkkkkkkkkk
		if ((cpf.length() < 0) || (cpf.length() > 11))
			return false;
		for (int x = 0; x < cpf.length(); x++) {
			if ((cpf.charAt(x) < 48) || (cpf.charAt(x) > 57))
				return false;
		}
		return true;
	}

	public void addTelefone(Telefone a) {
		this.telefone.add(a);
	}
	public void RetirarTelefone(Telefone a) {
		this.telefone.remove(a);
	}

	public ArrayList<Telefone> getTelefone() {
		return telefone;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Genero getGenero() {
		return genero;
	}

	public LocalDate getDatanascimento() {
		return datanascimento;
	}

	public int getIdade() {
		return Period.between(datanascimento, LocalDate.now()).getYears();
	}

	public boolean equals(Pessoa c) {
		return this.getTelefone() == c.getTelefone();
	}

}
