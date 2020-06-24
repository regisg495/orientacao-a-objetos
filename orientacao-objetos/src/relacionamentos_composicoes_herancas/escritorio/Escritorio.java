package relacionamentos_composicoes_herancas.escritorio;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Escritorio {
	private String nome;
	private final String cnpj;
	private String bairro;
	private String telefoneresidencial;
	private String cidade;
	private String cep;
	private final String razaosocial;
	private ArrayList<Advogado> advogado = new ArrayList<>();
	private ArrayList<Cliente> cliente = new ArrayList<>();
	private ArrayList<Processo> proc = new ArrayList<>();
	private ArrayList<Consulta> consulta = new ArrayList<>();
	private String Endereco;
	private int numero;

	public Escritorio(String nome, String CNPJ, String razaosocial) {
		super();
		this.nome = nome;
		this.cnpj = CNPJ;
		this.razaosocial = razaosocial;
	}

	public String getNome() {
		return nome;
	}

	public String getcnpj() {
		return cnpj;
	}

	public void cadastrarCliente(Cliente c) {
		for (Cliente f : cliente) {
			if (f == c) {
				throw new ClientejaCadastradoException();
			}
		}
		cliente.add(c);
	}

	public void cadastrarAdvogado(Advogado a) {
		for (Advogado advogado2 : advogado) {
			if (advogado2 == a) {
				throw new AdvogadojaCadastradoException();
			}
		}
		advogado.add(a);
	}

	public void DeletarAdvogado(Advogado a) {
		advogado.remove(a);
	}

	public Advogado BuscarAdvogado(Advogado a) {
		Integer i = advogado.indexOf(a);
		return advogado.get(i);
	}

	public void DeletarCliente(Cliente c) {
		cliente.remove(c);
	}

	public Cliente BuscarCliente(Cliente c) {
		Integer i = cliente.indexOf(c);
		return cliente.get(i);
	}

	public Advogado Buscaradv(String num) {
		for (Advogado advogado2 : advogado) {
			if (advogado2.OAB.equals(num))
				return advogado2;
		}
		return null;
	}

	public Cliente BuscarCliente(String cp) {
		for (Cliente cli2 : cliente) {
			if (cli2.getCpf().equals(cp))
				return cli2;
		}
		return null;
	}

	public void CadastrarProcesso(Processo p) {
		for (Processo pp : proc) {
			if (pp.getNumproc().toString().equalsIgnoreCase(p.getNumproc())) {
				throw new ProcessojaCadastradoException();
			}
		}
		proc.add(p);
	}

	public void DeletarProcesso(Processo p) {
		proc.remove(p);
	}

	public String getBairro() {
		return bairro;
	}

	public String getTelefoneresidencial() {
		return telefoneresidencial;
	}

	public String getCidade() {
		return cidade;
	}

	public String getCep() {
		return cep;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public String getEndereco() {
		return Endereco;
	}

	public int getNumero() {
		return numero;
	}

	public String getCnpj() {
		return cnpj;
	}

	public ArrayList<Cliente> getCliente() {
		return cliente;
	}

	public String Processos() {
		for (Processo i : proc) {
			return this.getProc() + "";
		}
		return "";
	}

	public ArrayList<Processo> getProc() {
		return proc;
	}

	public String Clientes() {
		for (Cliente i : cliente) {
			return this.getCliente() + "";
		}
		return "";
	}

	public String Advogado() {
		for (Advogado i : advogado) {
			return this.getAdvogado() + "";
		}
		return "";
	}

	public ArrayList<Advogado> getAdvogado() {
		return advogado;
	}

	public String toString() {
		return " Nome: " + this.getNome() + ", Bairro: " + this.getBairro() + ", Endere�o: " + this.getEndereco()
				+ ", Numero: " + this.getNumero() + ", CEP: " + this.getCep() + " , Cidade: " + this.getCidade()
				+ " , TelefoneResidencial: " + this.getTelefoneresidencial();

	}

}
