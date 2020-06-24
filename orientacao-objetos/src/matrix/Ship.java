package matrix;

import java.util.ArrayList;

public class Ship {
	private String nomeShip;
	private ArrayList<Person> tripulacao = new ArrayList<>();

	// Maravilha do arraylist
	public ArrayList<Person> getTripulacao() {
		return tripulacao;
	}

	public void setTripulacao(ArrayList<Person> tripulacao) {
		this.tripulacao = tripulacao;
	}

	public String getNomeShip() {
		return nomeShip;
	}

	public void setNomeShip(String nomeShip) {
		this.nomeShip = nomeShip;
	}

	public Ship(String nomeShip) {
		this.setNomeShip(nomeShip);
	}

	public int crewCount() {
		return this.getTripulacao().size();
	}
	// Tamanho da tripula��o, retorna o size

	public Object getCaptain() {
		if (this.getTripulacao().size() == 0)
			return null;
		return this.getTripulacao().get(0);
	}
	// Pelo que entendi o capit�o � o primeiro da lista

	public void setCaptain(Person niobe) {
		if (!this.getTripulacao().contains(niobe))
			return;
		this.getTripulacao().remove(niobe);
		this.getTripulacao().add(0, niobe);

	}
	// Remove o personagem e joga ele para a 1� posi��o (0)
	// Setando ele como captain

	public void removeCrew(Person mouse) {
		this.getTripulacao().remove(mouse);
		mouse.setMember(false);
	}

	// remove da lista e tira ele como membro
	public void recruit(Person trinity) {
		if (this.getTripulacao().contains(trinity) || trinity.isMember())
			return;
		this.getTripulacao().add(trinity);
		trinity.setMember(true);

	}
	// Se j� est� na lista ou j� � membro retorna, se n�o adiciona
	// e seta como membro

	public void destroy() {
		for (Person person : tripulacao) {
			person.setAlive(false);
		}
		ArrayList<Person> tripulacao2 = new ArrayList<>();
		this.tripulacao = tripulacao2;

	}
	// Personagens morrem (for each setando false no alive)
	// e reseta a lista
}
