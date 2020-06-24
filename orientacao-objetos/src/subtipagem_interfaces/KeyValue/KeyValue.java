package subtipagem_interfaces.KeyValue;

public class KeyValue implements IKeyValue {
	private Object[][] KeyValue = new Object[20][2];
	private int countcol = 0;

	public Object[][] getKeyValue() {
		return KeyValue;
	}

	public int getCountcol() {
		return countcol;
	}

	public void setKeyValue(Object[][] keyValue) {
		KeyValue = keyValue;
	}

	public void setCountcol(int countcol) {
		this.countcol = countcol;
	} //Getters and Setters

	@Override
	public void reset() {
		this.setKeyValue(new Object[20][2]);
		this.setCountcol(0);
		//Reset, esse m�todo reseta a lista, e o contador 
		//de colunas volta a 0

	}

	public void addSpace() {
		if (this.getCountcol() == this.getKeyValue().length) {
			Object NovaMatriz[][] = new Object[this.getKeyValue().length * 2][2];
			for (int x = 0; x < this.getKeyValue().length; x++) {
				NovaMatriz[x][0] = this.getKeyValue()[x][0];
				NovaMatriz[x][1] = this.getKeyValue()[x][1];
			}
			this.setKeyValue(NovaMatriz);
		} else
			return;

	}
	/* cria uma nova Matriz com length duplicado e coloca todos
	os objetos l� dentro
	*/

	@Override
	public void put(String key, Integer i) {
		if (hasKey(key)) {
			this.getKeyValue()[getPosition(key)][1] = i;
			return;
		}
		if (this.getCountcol() == this.getKeyValue().length) {
			addSpace();
		}
		this.getKeyValue()[countcol][0] = key;
		this.getKeyValue()[countcol][1] = i;
		this.countcol++;

	}
	/* se a chave j� existe ent�o substitui o valor para a posi��o
	 * onde est� a chave, o m�todo getposition eu q fiz
	 */

	public int getPosition(String key) {
		for (int x = 0; x < this.getKeyValue().length; x++) {
			if (this.getKeyValue()[x][0].equals(key))
				return x;
		}
		return 0;
	}
	//Pega a posi��o, dada uma chave ne

	@Override
	public Integer get(String key) {

		for (int x = 0; x < this.getKeyValue().length; x++) {
			if (this.getKeyValue()[x][0] == key)
				return (Integer) this.getKeyValue()[x][1];

		}
		return null;
	}
	// pega o valor, dado uma chave

	@Override
	public boolean hasKey(String key) {
		for (int x = 0; x < this.getKeyValue().length; x++) {
			if (this.getKeyValue()[x][0] == key)
				return true;
		}
		return false;
	}
	
	public int countkeys(Object o[][]) {
		int y = 0;
		for (int x = 0; x < this.getKeyValue().length; x++) {
			if (this.getKeyValue()[x][0] != null)
				y++;
		}
		return y;
	}

	@Override
	public String[] getKeys() {
		String s[] = new String[countkeys(this.getKeyValue())];
		for (int x = 0, j = 0; x < this.getKeyValue().length; x++) {
			if (this.getKeyValue()[x][0] != null)
				s[j] = (String) this.getKeyValue()[x][0];
			j++;

		}
		return s;
	}


	public int countvalues(Object o[][]) {
		int y = 0;
		for (int x = 0; x < this.getKeyValue().length; x++) {
			if (this.getKeyValue()[x][1] != null)
				y++;
		}
		return y;
	}
	//Conta quantos valores h�, ser� usado no get values

	@Override
	public Integer[] getValues() {
		Integer i[] = new Integer[countvalues(this.getKeyValue())];
		for (int x = 0, j = 0; x < this.getKeyValue().length; x++) {
			if (this.getKeyValue()[x][1] != null)
				i[j] = (Integer) this.getKeyValue()[x][1];
			j++;
		}
		return i;

	}

	@Override
	public boolean remove(String key) {
		if (hasKey(key)) {
			for (int x = 0; x < this.getKeyValue().length; x++) {
				if (this.getKeyValue()[x][0] == key) {
					this.getKeyValue()[x][0] = null;
					this.getKeyValue()[x][1] = null;
					this.countcol--;
					return true;
				}
			}
		}
		return false;
	}


}
