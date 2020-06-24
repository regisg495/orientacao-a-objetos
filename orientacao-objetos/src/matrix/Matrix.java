package matrix;

public class Matrix {

	public Person newHuman(String sobrenome, String nome) {
		Person p = new Human(sobrenome, nome);
		p.setPlugged(true);
		return p;
	}


	public Person newProgram(String alias) {
		Person p = new Program(alias);
		p.setPlugged(true);
		return p;
	}

	public Person newHuman(String alias) {
		Person p = new Human(alias);
		p.setPlugged(true);
		return p;
	}

	public Person newHuman(String sobrenome, String segundonome, String nome) {
		Person p = new Human(sobrenome, segundonome, nome);
		p.setPlugged(true);
		return p;
	}

	public Person newAgent(String sobrenome) {
		Person p = new Agent(sobrenome);
		p.setPlugged(true);
		return p;
	}

	public boolean has(Person neo) {
		if (neo instanceof Agent)
			return true;
		return neo.isPlugged();
	}
	
	public void free(Person neo, String apelido) {
		if (neo instanceof Agent)
			return;
		neo.setNome(null);
		neo.setSegundonome(null);
		neo.setSobrenome(null);
		neo.setPlugged(false);
		neo.setApelido(apelido);

	}
	

	public void enter(Person neo) {
		if (neo instanceof Agent)
			return;
		if (!neo.isAlive())
			return;
		neo.setPlugged(true);
	}
	

	public void enter(Person trinity, Person mouse) {
		if (!trinity.isAlive() && !mouse.isAlive())
			return;
		if (!trinity.isAlive() && mouse.isAlive()) {
			mouse.setPlugged(true);
		}
		if (trinity.isAlive() && !mouse.isAlive()) {
			trinity.setPlugged(true);
		}
		trinity.setPlugged(true);
		mouse.setPlugged(true);

	}

	public void leave(Person morpheus) {
		if (morpheus instanceof Agent)
			return;
		morpheus.setPlugged(false);

	}
	

}
