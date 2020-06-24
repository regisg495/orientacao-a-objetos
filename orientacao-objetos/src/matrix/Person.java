package matrix;

public class Person {
	private String nome;
	private String sobrenome;
	private String segundonome;
	private String apelido;
	private boolean plugged;
	private boolean member;
	private boolean alive = true;

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSegundonome() {
		return segundonome;
	}

	public void setSegundonome(String segundonome) {
		this.segundonome = segundonome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public boolean isPlugged() {
		return plugged;
	}

	public void setPlugged(boolean plugged) {
		this.plugged = plugged;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public Person(String sobrenome, String nome) {
		this.setSobrenome(sobrenome);
		this.setNome(nome);
	}
	// Construtores

	public Person(String alias) {
		this.setApelido(alias);
	}

	public Person(String sobrenome, String segundonome, String nome) {
		this.setSobrenome(sobrenome);
		this.setSegundonome(segundonome);
		this.setNome(nome);
	}

	public boolean ItsHuman(Person a) {
		if (a instanceof Human)
			return true;
		return false;
	}// M�todos para fazer os FirstName, LastName, MiddleName, Alias

	public boolean ItsAgent(Person a) {
		if (a instanceof Agent)
			return true;
		return false;
	}

	public Object getFirstName() {
		if (ItsHuman(this))
			return this.getNome();
		return null;
	}
	// Humano � o unico que tem FirstName, se n�o for humano retorna null

	public Object getLastName() {
		if (ItsHuman(this))
			return this.getSobrenome();
		if (ItsAgent(this))
			return this.getApelido();
		return null;
	} // Usei o apelido no Agente, j� que tem 1 construtor s�
		// E eu usei ele para program tb, se for agente retorna o apelido
		// Que foi usado como lastname, se for humano retorna sobrenome, se for programa
		// null

	public Object getFullName() {
		if (ItsHuman(this) && this.getNome() == null && this.getSobrenome() == null && this.getSegundonome() == null
				&& this.getApelido() != null)
			return null;
		if (ItsHuman(this) && this.getMiddleName() == null)
			return this.getFirstName() + " " + this.getLastName();
		if (ItsHuman(this) && this.getMiddleName() != null)
			return this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName();
		return null;
	}
	// Se for humano e n�o tiver segundo nome retornar nome e lastname
	// Se for humano e tiver retorna nome, middlename, e lastname

	public Object getAlias() {
		if (ItsAgent(this))
			return null;
		return this.getApelido();
	}

	// Apelido, valida��o para o agente, j� que usei o lastname(que vai no agente)
	// como apelido
	public Object getMiddleName() {
		if (this.getSegundonome() != null)
			return this.getSegundonome();
		return null;
	}

	public boolean isCaptainOf(Ship nebuchadnezzar) {
		return nebuchadnezzar.getCaptain().equals(this);
	}
	// retorna o getcaptain do ship equals o objeto (Person) daqui

	public void becameCaptainOf(Ship logos) {
		logos.setCaptain(this);

	}
	// M�todos reaproveitados do ship, s� muda o objeto

	public boolean isCrewOf(Ship nebuchadnezzar) {
		return nebuchadnezzar.getTripulacao().contains(this);
	}
	// Retorna se o personagem faz parte da tripulacao

	public void leaveShip(Ship logos) {
		logos.removeCrew(this);

	}
	// Reaproveita o removecrew

	public void join(Ship nebuchadnezzar) {
		nebuchadnezzar.recruit(this);

	}
	// reaproveita o recruit, foi interessante porque as valida��es
	// ja est�o la, ent�o foi s� sair colocando aqui kk

	public void plug() {
		this.setPlugged(true);

	}
	// pluga o personagem

	public void unplug() {
		if (!(this instanceof Human))
			return;
		this.setPlugged(false);

	}
	// S� humanos saem da matrix, se n�o for instancia de humano retorna

	public void unplug(Person apoc) {
		if (!(apoc instanceof Human))
			return;
		if (!apoc.isPlugged())
			return;
		apoc.setPlugged(false);
		apoc.setAlive(false);

	}
	// S� humanos saem da matrix, e quem sai morre

	public void kill(Person dozer) {
		if (dozer instanceof Agent) {
			dozer.setPlugged(false);

			return;
		}
		// Caso especial

		if (dozer.isPlugged() && !this.isPlugged() || !dozer.isPlugged() && this.isPlugged() || !this.isAlive())
			return;
		dozer.setAlive(false);
		dozer.setPlugged(false);
	}
	// Os dois devem estar no mesmo lugar para ter kill

	public void free(Person kid, String apelido) {
		kid.setNome(null);
		kid.setSegundonome(null);
		kid.setSobrenome(null);
		kid.setApelido(apelido);
		kid.setPlugged(false);

	}
	// livre perde a identidade, sai da matrix e ganha um alias

}
