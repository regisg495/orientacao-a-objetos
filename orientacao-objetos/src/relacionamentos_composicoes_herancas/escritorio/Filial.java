package relacionamentos_composicoes_herancas.escritorio;

public class Filial extends Escritorio {
	private String CEP;
	private String nomefilial;
	private String bairro;
	private String Endereco;
	private int numero;
	private String cidade;
	private String telefoneresidencial;
	private String razaosocial;

	public Filial(String nome, String cnpj, String nomefilial, String endereco, String bairro, int numero, String cEP,
			String cidade, String telefoneresidencial, String razaosocial) {
		super(nome, cnpj, razaosocial);
		this.nomefilial = nomefilial;
		this.Endereco = endereco;
		this.bairro = bairro;
		this.numero = numero;
		this.CEP = cEP;
		this.cidade = cidade;
		this.telefoneresidencial = telefoneresidencial;
	}

	public String getCEP() {
		return CEP;
	}

	public String getNomefilial() {
		return nomefilial;
	}

	public String getBairro() {
		return bairro;
	}

	public String getEndereco() {
		return Endereco;
	}

	public int getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}


	public String getTelefoneresidencial() {
		return telefoneresidencial;
	}

	public String getRazaosocial() {
		return razaosocial;
	}


	public String toString() {
		return "Escrit�rio: " + this.getNome() + ", Filial: " + this.getNomefilial() + ", Endere�o: "
				+ this.getEndereco() + ", Cidade: " + this.getCidade() + ", Bairro: " + this.getBairro() + ", Numero: "
				+ this.getNumero() + ", CEP: " + this.getCEP() + ", Cidade: " + this.getCidade()
				+ ", Telefone Residencial " + this.getTelefoneresidencial();
	}

}
