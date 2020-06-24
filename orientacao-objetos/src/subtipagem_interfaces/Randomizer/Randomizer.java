package subtipagem_interfaces.Randomizer;

public interface Randomizer {
	  /**
	   * Gera um n�mero aleat�rio onde 0 =< n�mero < 1.0
	   *
	   * @return double entre 0 (inclusive) e 1 (exclusivo)
	   */
	    public double random();
	 
	    /**
	     * Gera um n�mero aleat�rio inteiro de 0 (inclusive) at� max (inclusive)
	     *
	     * @param max inteiro n�o negativo representando o maior inteiro poss�vel
	     * @return double entre 0 (inclusive) e max (inclusivo)
	     */
	    public int randomInt(int max);
	 
	    /**
	     * Gera um n�mero aleat�rio inteiro de min (inclusive) at� max (inclusive)
	     *
	     * @param min inteiro n�o negativo representando o menor inteiro poss�vel
	     * @param max inteiro n�o negativo representando o maior inteiro poss�vel
	     * @return double entre min (inclusive) e max (exclusivo)
	     */
	    public int randomInt(int min, int max);
	    
	}

