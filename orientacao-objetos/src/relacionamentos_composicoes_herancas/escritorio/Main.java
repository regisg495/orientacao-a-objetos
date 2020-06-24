package relacionamentos_composicoes_herancas.escritorio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		Advogado regis = new Advogado("R�gis", "03322767086", Genero.Masculino, LocalDate.of(1992, 6, 23), "5425");
		regis.addEspecialidade(Especialidade.Civel);
		System.out.println(regis.toString());
		System.out.println(regis.toString().equals(
				"Nome: R�gis, CPF: 03322767086 Genero: Masculino, Data de Nascimento: 1992-06-23, OAB: 5425, Especialidades: [Civel]"));
		// Pessoa Marcio = new Pessoa() N�o pode Instanciar, Abstrata
		// Ou � Cliente ou Advogado
		Cliente Mariane = new Cliente("Mariane", "05425555", Genero.Feminino, LocalDate.of(1992, 6, 23),
				Antecedentes.Nao, Status.Livre);
		System.out.println(Mariane.toString());
		System.out.println(Mariane.getIdade() == 25);
		System.out.println(Mariane.toString().equals(
				"Nome: Mariane, CPF: 05425555 Genero: Feminino, Data de Nascimento: 1992-06-23, Antecedentes: Nao, Processo: []"));

		Filial doRegis = new Filial("RegisAdvogados", "524542", "Filial do Rio Grande", "Rua General Os�rio",
				"Centro", 150, "96225000", "Rio Grande", "3035-1825", "Escritorio de Advocacia");
		System.out.println(doRegis.toString()); // Escritorio com filial
		Telefone doRegiss = new Telefone("98515470");
		regis.addTelefone(doRegiss);// Telefone do Regis
		System.out.println(doRegiss.toString().equals("98515470"));
		Telefone doRegiss2 = new Telefone("99810574");
		regis.addTelefone(doRegiss2);
		System.out.println(regis.getTelefone());// [98515470, 99810574]
		Telefone doRegiss3 = new Telefone("90816546");
		Telefone doRegiss4 = new Telefone("99810540");
		Telefone doRegiss5 = new Telefone("81051052");
		regis.addTelefone(doRegiss3);
		regis.addTelefone(doRegiss4);
		regis.addTelefone(doRegiss5);
		for (Telefone i : regis.getTelefone()) {
			System.out.println(i.toString());
		}
		// 98515470, 99810574, 90816546, 99810540, 81051052
		Processo c = new Processo("52454", Especialidade.Criminal);
		Mariane.addProcesso(c);
		
		System.out.println(Mariane.toString().equals(
				"Nome: Mariane, CPF: 05425555 Genero: Feminino, Data de Nascimento: 1992-06-23, Antecedentes: Sim, Processo: [52454 : Criminal]"));
		System.out.println(Mariane.toString());
		Telefone daMariane = new Telefone("4545152");
		Mariane.addTelefone(daMariane);
		System.out.println(Mariane.getTelefone().toString().equals("[4545152]"));
		Consulta c1 = new Consulta(regis, Mariane, LocalDateTime.of(2018, 1, 1, 14, 0), doRegis, c);
		System.out.println(c1.toString().equals(
				"Advogado: Nome: R�gis, CPF: 03322767086 Genero: Masculino, Data de Nascimento: 1992-06-23, OAB: 5425, Especialidades: [Civel], Cliente: Nome: Mariane, CPF: 05425555 Genero: Feminino, Data de Nascimento: 1992-06-23, Antecedentes: Sim, Processo: [52454 : Criminal], Data: 2018-01-01T14:00"));
		System.out.println(c1.toString());
	
		regis.addEspecialidade(Especialidade.Criminal);
		System.out.println(regis.getEspecialidades().toString().equals("[Civel, Criminal]"));
		Processo d = new Processo("12052", Especialidade.Civel);
		Mariane.addProcesso(d);

		System.out.println(Mariane.getProcesso().toString().equals("[52454 : Criminal, 12052 : Civel]"));
		System.out.println(Mariane.pesquisarSituacaoCliente().toString().equals(
				"Nome: Mariane, CPF: 05425555 Genero: Feminino, Data de Nascimento: 1992-06-23, Antecedentes: Sim, Processo: [52454 : Criminal, 12052 : Civel]"));
		Mariane.deleteProcesso(d); // Deleta o Processo
		System.out.println(Mariane.getProcesso().toString().equals("[52454 : Criminal]")); // Criminal
		Cliente Matheus = new Cliente("Matheus", "0324854425", Genero.Masculino, LocalDate.of(1995, 8, 23),
				Antecedentes.Nao, Status.Livre);
		System.out.println(Matheus.toString().equals(
				"Nome: Matheus, CPF: 0324854425 Genero: Masculino, Data de Nascimento: 1995-08-23, Antecedentes: Nao, Processo: []")); // Sem
		// antecedentes
		// Matheus N�o tem Antecedentes;
		System.out.println(Matheus.getAntecedentes().toString().equals("Nao"));
		Processo p = new Processo("21548", Especialidade.Criminal);
		// Como as especialidades s�o iguais, Advogado tem Especialidade Civel,
		// Financeiro,
		// Cliente tamb�m responde ao mesmo tipo de processo
		// foi reaproveitado para o tipo de Processo
		Matheus.addProcesso(p); // Cliente responde a Processo criminal = ficha suja
		System.out.println(Matheus.getAntecedentes().toString().equals("Sim"));
		// Matheus Agora Responde a um processo de tipo Criminal, portanto ja � ficha
		// suja!

		Matheus.setStatus(Status.Preso);
		
		System.out.println(Matheus.getStatus().toString().equals("Preso"));
		Consulta cc = new Consulta(regis, Matheus, LocalDateTime.of(2018, 2, 6, 15, 0), doRegis,p);
		System.out.println(cc.toString().equals(
				"Advogado: Nome: R�gis, CPF: 03322767086 Genero: Masculino, Data de Nascimento: 1992-06-23, OAB: 5425, Especialidades: [Civel, Criminal], Cliente: Nome: Matheus, CPF: 0324854425 Genero: Masculino, Data de Nascimento: 1995-08-23, Antecedentes: Sim, Processo: [21548 : Criminal], Data: 2018-02-06T15:00"));
		doRegis.cadastrarAdvogado(regis); // Cadastrando
		doRegis.cadastrarCliente(Matheus);
		System.out.println(doRegis.Clientes().toString().equals(
				"[Nome: Matheus, CPF: 0324854425 Genero: Masculino, Data de Nascimento: 1995-08-23, Antecedentes: Sim, Processo: [21548 : Criminal]]"));
		System.out.println(doRegis.Advogado().toString().equals(
				"[Nome: R�gis, CPF: 03322767086 Genero: Masculino, Data de Nascimento: 1992-06-23, OAB: 5425, Especialidades: [Civel, Criminal]]"));
		doRegis.cadastrarCliente(Mariane);
		System.out.println(doRegis.Clientes().toString().equals(
				"[Nome: Matheus, CPF: 0324854425 Genero: Masculino, Data de Nascimento: 1995-08-23, Antecedentes: Sim, Processo: [21548 : Criminal], Nome: Mariane, CPF: 05425555 Genero: Feminino, Data de Nascimento: 1992-06-23, Antecedentes: Sim, Processo: [52454 : Criminal]]"));
		Advogado Marcio = new Advogado("Marcio", "0325467086", Genero.Masculino, LocalDate.of(1980, 5, 22), "5125");
		doRegis.cadastrarAdvogado(Marcio);
		System.out.println(doRegis.Advogado().toString().equals(
				"[Nome: R�gis, CPF: 03322767086 Genero: Masculino, Data de Nascimento: 1992-06-23, OAB: 5425, Especialidades: [Civel, Criminal], Nome: Marcio, CPF: 0325467086 Genero: Masculino, Data de Nascimento: 1980-05-22, OAB: 5125, Especialidades: []]"));
		doRegis.DeletarAdvogado(regis);
		System.out.println(doRegis.Advogado().toString().equals("[Nome: Marcio, CPF: 0325467086 Genero: Masculino, Data de Nascimento: 1980-05-22, OAB: 5125, Especialidades: []]"));
		System.out.println(doRegis.BuscarAdvogado(Marcio).toString().equals("Nome: Marcio, CPF: 0325467086 Genero: Masculino, Data de Nascimento: 1980-05-22, OAB: 5125, Especialidades: []"));
		System.out.println(doRegis.BuscarCliente(Matheus).toString().equals("Nome: Matheus, CPF: 0324854425 Genero: Masculino, Data de Nascimento: 1995-08-23, Antecedentes: Sim, Processo: [21548 : Criminal]"));
		doRegis.DeletarCliente(Matheus);
		doRegis.DeletarCliente(Mariane);
		System.out.print(doRegis.Clientes()); //Vazio
		doRegis.CadastrarProcesso(c);
		doRegis.CadastrarProcesso(p);
		System.out.println(doRegis.Processos().equals("[52454 : Criminal, 21548 : Criminal]"));
		doRegis.DeletarProcesso(p);
		System.out.println(doRegis.Processos().toString().equals("[52454 : Criminal]"));
		Advogado Alex = new Advogado("Alex","4545212", Genero.Masculino, LocalDate.of(1981, 6, 12),"51200");
		doRegis.cadastrarAdvogado(Alex);
		System.out.println(doRegis.Buscaradv("51200").toString().equals("Nome: Alex, CPF: 4545212 Genero: Masculino, Data de Nascimento: 1981-06-12, OAB: 51200, Especialidades: []")); //Alex
		//Buscou o Alex
		System.out.println(doRegis.Buscaradv("45451") == null);
		doRegis.cadastrarCliente(Matheus);//CPF do Matheus abaixo
		System.out.println(doRegis.BuscarCliente("0324854425").toString().equals("Nome: Matheus, CPF: 0324854425 Genero: Masculino, Data de Nascimento: 1995-08-23, Antecedentes: Sim, Processo: [21548 : Criminal]"));
		/*O Betito Melhorado N�o Compila
		Botei at� o toString na classe da OAB Inexistente. Que voc� me deu um corte
		Dizendo que n�o se faz hahahahaahah. Po, fiquei todo feliz na aula da Loiane
		Quando ela explicou: "E vejam que legal pessoal, voc�s podem at� colocar o toString
		L�!
		*/
		//Advogado BetitoMelhorado = new Advogado("VulgoMarcio","421220", Genero.Masculino, LocalDate.of(1978, 5, 12),"dsadas");
		//O BetitoMelhorado2 N�o vai compilar tamb�m
		//Pessoa BetitoMelhorado2 = new Cliente("BetitoMelhorado", "455445455454544", Genero.Masculino, LocalDate.of(1978, 5, 12), Antecedentes.Nao, Status.Livre);
		//doRegis.cadastrarCliente(Matheus); J� Cadastrado, N�o Compila
		doRegis.cadastrarAdvogado(regis); //Tinha sido removido
		//doRegis.cadastrarAdvogado(regis); Essa vai jogar Exception
		Processo d1 = new Processo("51545", Especialidade.Civel);
		doRegis.CadastrarProcesso(d1);
		//doRegis.CadastrarProcesso(d1); Quebra tamb�m
		
	
	}

}
