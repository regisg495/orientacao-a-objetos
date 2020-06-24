package subtipagem_interfaces.Randomizer;

public class MiddleSquareRandomizer implements Randomizer {
	private long semente;
	private long quadrado;

	public long getSemente() {
		return semente;
	}
	

	public long getQuadrado() {
		return quadrado;
	}

	public void setQuadrado(long quadrado) {
		this.quadrado = quadrado;
	}

	public double random() {
		setQuadrado(this.getSemente() * this.getSemente());
		setQuadrado((this.getQuadrado() / 1000) % 1000000); 
	
		double valor = (double) this.getQuadrado() / 1000000;
	
		this.semente++;
		return valor;
	}

	@Override
	public int randomInt(int max) {
		MiddleSquareRandomizer c = new MiddleSquareRandomizer();
		return (int) (random() * max + 1);
	}
	
	@Override
	public int randomInt(int min, int max) {
		return randomInt(max - min) + min;
	
	}

}
