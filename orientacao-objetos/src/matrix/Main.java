package matrix;

public class Main {

	public static void main(String[] args) {
		/* setup: 0.1 ponto */

		Matrix matrix = new Matrix();

		Person Neo = matrix.newHuman("Anderson", "Tomas"); // sobrenome e nome
		Person Oracle = matrix.newProgram("Oracle"); // apelido
		Person Merovingian = matrix.newProgram("Merovingian"); // apelido
		Person Dujour = matrix.newHuman("Dujour"); // apelido
		Person Paul = matrix.newHuman("Olsen", "Paul");
		Person Kid = matrix.newHuman("Popper", "Karl", "Michael"); // sobrenome, segundo nome, nome

		Person Smith = matrix.newAgent("Smith"); // Lastname
		Person Brown = matrix.newAgent("Brown"); // Lastname

		Person Trinity = new Human("Trinity");
		Person Morpheus = new Human("Morpheus");
		Person Mouse = new Human("Mouse");
		Person Dozer = new Human("Dozer");
		Person Roland = new Human("Roland");
		Person Niobe = new Human("Niobe");
		Person Apoc = new Human("Apoc");
		Person Cypher = new Human("Cypher");
		Person Ghost = new Human("Ghost");
		Person Sparks = new Human("Sparks");

		Ship Nebuchadnezzar = new Ship("Nebuchadnezzar");
		Ship Logos = new Ship("Logos");
		Ship Mjolnir = new Ship("Mjolnir");

		/* setup: --------------------- */

		/* 1ra parte: +0.1 ponto */

		System.out.println(Neo.getFirstName().equals("Tomas"));
		System.out.println(Neo.getLastName().equals("Anderson"));
		System.out.println(Neo.getFullName().equals("Tomas Anderson"));
		System.out.println(Neo.getAlias() == null); // Neo n�o t�m alias ainda
		System.out.println(Neo.toString().equals("Mr. Anderson")); // Mr Lastname

		System.out.println(Oracle.getFirstName() == null);
		System.out.println(Oracle.getLastName() == null);
		System.out.println(Oracle.getFullName() == null);
		System.out.println(Oracle.getAlias().equals("Oracle"));
		System.out.println(Oracle.toString().equals("The Oracle")); // The Alias, quando � um Programa

		System.out.println(Paul.getFirstName().equals("Paul"));
		System.out.println(Paul.getLastName().equals("Olsen"));
		System.out.println(Paul.getFullName().equals("Paul Olsen"));
		System.out.println(Paul.getAlias() == null); // Paul n�o t�m alias
		System.out.println(Paul.toString().equals("Mr. Olsen")); // Mr Lastname

		System.out.println(Kid.getFirstName().equals("Michael"));
		System.out.println(Kid.getLastName().equals("Popper"));
		System.out.println(Kid.getMiddleName().equals("Karl"));
		System.out.println(Kid.getFullName().equals("Michael Karl Popper"));
		System.out.println(Kid.getAlias() == null); // Kid n�o t�m alias, ainda
		System.out.println(Kid.toString().equals("Mr. Popper")); // Mr Lastname

		System.out.println(Smith.getFirstName() == null);
		System.out.println(Smith.getLastName().equals("Smith"));
		System.out.println(Smith.getFullName() == null);
		System.out.println(Smith.getAlias() == null);
		System.out.println(Smith.toString().equals("Agent Smith")); // Agent Alias, quando � um Agente

		System.out.println(Trinity.getFirstName() == null);
		System.out.println(Trinity.getLastName() == null);
		System.out.println(Trinity.getFullName() == null);
		System.out.println(Trinity.getAlias().equals("Trinity"));
		System.out.println(Trinity.toString().equals("Trinity")); // S� o alias quando a pessoa tem um

		/* 1ra parte ---------- */

		/* 2da parte: +0.1 ponto */

		System.out.println(Neo.isPlugged() == true); // Neo est� na Matrix
		System.out.println(Dujour.isPlugged() == true);
		System.out.println(Smith.isPlugged() == true);
		System.out.println(Morpheus.isPlugged() == false);

		System.out.println(matrix.has(Neo) == true);
		System.out.println(matrix.has(Dujour) == true);
		System.out.println(matrix.has(Oracle) == true);
		System.out.println(matrix.has(Morpheus) == false);
		System.out.println(matrix.has(Trinity) == false);

		/* 2da parte: -------- */

		/* 3ra parte: +0.1 ponto */

		matrix.free(Neo, "Neo");
		; // ao sair da matrix as pessoas ganham um apelido e n�o tem mais nome

		System.out.println(Neo.isPlugged() == false); // Neo n�o est� na Matrix
		System.out.println(matrix.has(Neo) == false);
		System.out.println(Neo.getFirstName() == null); // Tempor�rio at� ele voltar
		System.out.println(Neo.getLastName() == null); // Tempor�rio at� ele voltar
		System.out.println(Neo.getFullName() == null); // Tempor�rio at� ele voltar
		System.out.println(Neo.getAlias().equals("Neo"));
		System.out.println(Neo.toString().equals("Neo"));

		matrix.free(Smith, "Smith"); // Smith � um Agente e n�o pode ser libertado

		System.out.println(Smith.isPlugged() == true);
		System.out.println(matrix.has(Smith) == true);

		/* 3ra parte: ---------- */

		/* 4ta parte: +0.1 ponto */

		System.out.println(Nebuchadnezzar.crewCount() == 0);
		System.out.println(Nebuchadnezzar.getCaptain() == null);

		Nebuchadnezzar.recruit(Trinity); // recrutar tripula��o

		System.out.println(Nebuchadnezzar.crewCount() == 1);
		System.out.println(Nebuchadnezzar.getCaptain().equals(Trinity));

		Nebuchadnezzar.recruit(Morpheus);
		Nebuchadnezzar.recruit(Mouse);
		Nebuchadnezzar.recruit(Dozer);
		Nebuchadnezzar.recruit(Neo);

		System.out.println(Nebuchadnezzar.crewCount() == 5);

		/* 4ta parte: -------- */

		/* 5ta parte: +0.1 ponto */

		System.out.println(Nebuchadnezzar.getCaptain().equals(Trinity) == true);

		// s� se for membro da tripula��o, Niobe n�o �!
		Nebuchadnezzar.setCaptain(Niobe);

		System.out.println(Nebuchadnezzar.getCaptain().equals(Trinity) == true);

		Nebuchadnezzar.setCaptain(Morpheus);

		System.out.println(Nebuchadnezzar.getCaptain().equals(Morpheus) == true);
		System.out.println(Nebuchadnezzar.getCaptain().equals(Niobe) == false);
		System.out.println(Nebuchadnezzar.getCaptain().equals(Trinity) == false);

		System.out.println(Morpheus.isCaptainOf(Nebuchadnezzar) == true);

		/* 5ta parte: --------------------- */

		/* 6ta parte: +0.2 ponto */

		Logos.recruit(Ghost);
		Logos.recruit(Niobe);
		Logos.recruit(Sparks);

		System.out.println(Logos.getCaptain().equals(Ghost) == true);
		System.out.println(Logos.getCaptain().equals(Niobe) == false);

		Niobe.becameCaptainOf(Logos);

		System.out.println(Logos.getCaptain().equals(Niobe) == true);

		System.out.println(Nebuchadnezzar.crewCount() == 5);
		System.out.println(Logos.crewCount() == 3);

		System.out.println(Mouse.isCrewOf(Nebuchadnezzar) == true);
		System.out.println(Mouse.isCrewOf(Logos) == false);
		System.out.println(Niobe.isCrewOf(Nebuchadnezzar) == false);
		System.out.println(Niobe.isCrewOf(Logos) == true);

		Logos.recruit(Mouse); // n�o pode pois j� � membro da Nebuchadnezzar

		System.out.println(Mouse.isCrewOf(Nebuchadnezzar) == true);
		System.out.println(Mouse.isCrewOf(Logos) == false);

		System.out.println(Nebuchadnezzar.crewCount() == 5);
		System.out.println(Logos.crewCount() == 3);

		Nebuchadnezzar.removeCrew(Mouse);

		System.out.println(Nebuchadnezzar.crewCount() == 4);
		System.out.println(Logos.crewCount() == 3);

		Logos.recruit(Mouse);

		System.out.println(Nebuchadnezzar.crewCount() == 4);
		System.out.println(Logos.crewCount() == 4);

		System.out.println(Mouse.isCrewOf(Nebuchadnezzar) == false);
		System.out.println(Mouse.isCrewOf(Logos) == true);

		Mouse.leaveShip(Logos); // outro modo de deixar de ser membro de uma tripula��o

		System.out.println(Nebuchadnezzar.crewCount() == 4);
		System.out.println(Logos.crewCount() == 3);

		System.out.println(Mouse.isCrewOf(Nebuchadnezzar) == false);
		System.out.println(Mouse.isCrewOf(Logos) == false);

		Mouse.join(Nebuchadnezzar); // outro modo de tornar-se tripula��o

		System.out.println(Mouse.isCrewOf(Nebuchadnezzar) == true);
		System.out.println(Mouse.isCrewOf(Logos) == false);
		System.out.println(Nebuchadnezzar.crewCount() == 5);
		System.out.println(Logos.crewCount() == 3);
		System.out.println(Nebuchadnezzar.getCaptain().equals(Morpheus));

		Mouse.join(Nebuchadnezzar); // n�o pode ser duas vezes
		Nebuchadnezzar.recruit(Mouse); // n�o pode ser duas vezes

		System.out.println(Nebuchadnezzar.crewCount() == 5);

		/* 6ta parte: ----------------- */

		/* 7ma parte: +0.2 ponto */

		matrix.enter(Neo); // Neo entra na matrix
		matrix.enter(Morpheus); // Morpheus tamb�m
		matrix.enter(Trinity, Mouse); // duas pessoas podem entrar juntas

		System.out.println(Neo.isPlugged() == true);
		System.out.println(Morpheus.isPlugged() == true);
		System.out.println(matrix.has(Trinity) == true);
		System.out.println(matrix.has(Mouse) == true);

		matrix.leave(Morpheus);

		System.out.println(Morpheus.isPlugged() == false);

		Morpheus.plug(); // outro modo de entrar na matrix

		System.out.println(Morpheus.isPlugged() == true);

		Morpheus.unplug(); // outro modo de sair da matrix

		System.out.println(Morpheus.isPlugged() == false);

		System.out.println(Morpheus.isAlive() == true); // Est� vivo!

		/* 7ma parte: --------------- */

		/* 8va parte: +0.2 ponto */

		System.out.println(Apoc.isPlugged() == false);
		Cypher.unplug(Apoc); // uma pessoa pode desplugar outra, mas Apoc n�o est� plugado
		System.out.println(Apoc.isAlive() == true);
		Apoc.plug(); // Apoc entrou na Matrix
		System.out.println(Apoc.isPlugged() == true);
		Cypher.unplug(Apoc); // desplugar algu�m da Matrix � assassina-lo
		System.out.println(Apoc.isAlive() == false);

		System.out.println(Dozer.isAlive() == true);
		Cypher.kill(Dozer);
		System.out.println(Dozer.isAlive() == false);

		System.out.println(Roland.isAlive() == true);
		Smith.kill(Roland); // n�o pode, Smith est� na Matrix e Roland n�o
		System.out.println(Roland.isAlive() == true);

		System.out.println(Mouse.isAlive() == true);
		Smith.kill(Mouse); // ambos est�o na Matrix, ent�o Mouse � morto
		System.out.println(Mouse.isAlive() == false);

		Dozer.kill(Cypher); // Dozer est� morto ent�o n�o pode fazer nada
		System.out.println(Cypher.isAlive() == true);
		matrix.enter(Dozer); // Dozer est�o morto
		System.out.println(matrix.has(Dozer) == false);

		/* 8va parte: ------------------ */

		/* 9na parte: +0.2 ponto */

		// caso especial
		Neo.kill(Smith);
		System.out.println(Smith.isAlive() == true);
		System.out.println(Smith.isPlugged() == false);
		System.out.println(matrix.has(Smith) == true);
		// ---

		System.out.println((Merovingian instanceof Program) == true);
		System.out.println((Neo instanceof Program) == false);
		System.out.println((Neo instanceof Human) == true);

		System.out.println(Merovingian.isPlugged() == true);
		Merovingian.unplug(); // S� Humanos entram e saem da Matrix
		System.out.println(Merovingian.isPlugged() == true);

		System.out.println(Paul.isAlive() == true);
		Neo.kill(Paul); // morreu, desplugou-se
		System.out.println(Paul.isAlive() == false);
		System.out.println(Paul.isPlugged() == false);

		System.out.println(Kid.isPlugged() == true);
		Neo.free(Kid, "Kid"); // Neo tem o poder de libertar as pessoas da Matrix
		System.out.println(Kid.isPlugged() == false);
		System.out.println(Kid.getFirstName() == null);
		System.out.println(Kid.getLastName() == null);
		System.out.println(Kid.getMiddleName() == null);
		System.out.println(Kid.getFullName() == null);
		System.out.println(Kid.getAlias().equals("Kid"));
		System.out.println(Kid.toString().equals("Kid"));

		/* 9na parte: ------------------ */

		/* 10ma parte: +0.2 ponto */

		System.out.println(Niobe.isAlive() == true);
		System.out.println(Ghost.isAlive() == true);
		System.out.println(Sparks.isAlive() == true);
		Logos.destroy(); // destruir o hovercraft implica em matar toda a tripula��o
		System.out.println(Niobe.isAlive() == false);
		System.out.println(Ghost.isAlive() == false);
		System.out.println(Sparks.isAlive() == false);

		/* 10ma parte: ------------ */

	}

}
