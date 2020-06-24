package subtipagem_interfaces.ILIST;

import subtipagem_interfaces.Randomizer.MiddleSquareRandomizer;

class List implements IList {

	private Object[] lista = new Object[50]; // Comecei com 50
	private long semente = 756841;

	public Object[] getLista() {
		return lista;
	}

	public void setLista(Object[] lista) {
		this.lista = lista;
	}

	public long getSemente() {
		return semente;
	}

	public void setSemente(long semente) {
		this.semente = semente;
	}

	public void addSpace() {
		Object[] NovaLista = new Object[this.getLista().length + 25];
		System.arraycopy(this.getLista(), 0, NovaLista, 0, count());
		this.lista = NovaLista;
	}
	@Override
	public void append(Object o) {
		if (this.getLista()[this.getLista().length - 25] != null) {
			addSpace();
		}
		this.lista[count()] = o;
	}
	
	@Override
	public int count() {
		int y = 0;
		for (int x = 0; x < this.getLista().length; x++) {
			if (this.lista[x] != null)
				y++;
		}
		return y;
	}
	

	@Override
	public boolean isEmpty() {
		if (count() == 0)
			return true;
		else
			return false;
	}


	@Override
	public void prepend(Object o) {
		Object[] NovaLista = new Object[this.getLista().length + 1];
		NovaLista[0] = o;
		System.arraycopy(this.getLista(), 0, NovaLista, 1, count());
		this.setLista(NovaLista);
	}


	@Override
	public boolean insert(Object o, int index) {
		if (this.getLista().length - 1 < index || index < 0 || index > count() || count() + 1 == index)
			return false;

		Object[] NovaLista = new Object[this.lista.length + 1];
		NovaLista[index] = o;
		System.arraycopy(this.getLista(), 0, NovaLista, 0, index);
		System.arraycopy(this.getLista(), index, NovaLista, index + 1, count());

		this.setLista(NovaLista);
		return true;

	}


	@Override
	public Object get(int index) {
		if (isEmpty())
			return null;
		if (this.lista.length - 1 < index || index < 0)
			return null;
		if (this.lista[index] == null)
			return null;
		return this.lista[index];
	}

	
	@Override
	public Object getFirst() {
		if (isEmpty())
			return null;
		else
			return this.lista[0];
	}
	
	@Override
	public Object getLast() {
		if (isEmpty())
			return null;
		else
			return this.lista[count() - 1];

	}
	

	@Override
	public Object getSample() {
		if (count() == 0)
			return null;
		return this.lista[randomInt(count())];
	}

	
	public double random() {
		long quadrado = this.getSemente() * this.getSemente();
		quadrado = quadrado / 1000 % 1000000;
		double valor = (double) quadrado / 1000000;
		this.semente++;
		return valor;
	}

	
	public int randomInt(int max) {
		MiddleSquareRandomizer c = new MiddleSquareRandomizer();
		return (int) (random() * max);
	}
	
	@Override
	public Object drop(int index) {
		if (index > this.getLista().length) {
			return false;
			// throw new IllegalArgumentException("Vai estourar o vetor!");
		} else if (this.getLista()[index] == null)
			return null;
		Object o = get(index);
		delete(index);
		return o;
	}
	

	@Override
	public boolean delete(int index) {
		if (get(index) != null) {
			Object[] NovaLista = new Object[count() + 1];
			this.getLista()[index] = null;
			System.arraycopy(this.getLista(), 0, NovaLista, 0, index);
			System.arraycopy(this.getLista(), index + 1, NovaLista, index, count());
			this.setLista(NovaLista);
			return true;
		} else
			return false;
	}
	

	@Override
	public boolean remove(Object o) {
		if (has(o)) {
			delete(indexOf(o)); // Dica do marcio de abra�ar metodos
			return true;
		} else
			return false;
	}
	

	@Override
	public void reset() {
		this.setLista(new Object[50]);

	}

	
	@Override
	public boolean has(Object o) {
		boolean f = false;
		for (int x = 0; x < this.getLista().length; x++) {
			if (this.lista[x] == o) {
				f = true;
				return f;
			}
		}
		return f;
	}
	

	@Override
	public int indexOf(Object o) {
		if (has(o)) {
			for (int x = 0; x < this.getLista().length; x++)
				if (this.getLista()[x] == o) {
					return x;
				}

		}
		return -1;
	}
}

