package objetos_extras.fatorial;

class Factorial {
	private int factorial;
	private long number;

	
	public int getFatorial() {
		return factorial;
	}

	public void setFatorial(int fatorial) {
		this.factorial = fatorial;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public Factorial(int i) {
		this.setFatorial(i);
	}

	static long of(long factorial) {
		if(factorial < 0)
			throw new IllegalArgumentException("N�o existe Fatorial Negativo");
		if ((factorial == 0) || (factorial == 1))
			return 1;
		return of(factorial - 1) * factorial;
	}

	 
	public long number() {
		return (int) this.getNumber();
	}

	public long value() {
		return of(this.getNumber());
	}

	public boolean next() {
		if (this.getNumber() == this.getFatorial())
			return false;
		this.number++;
		return true;
	}

	public void begin() {
		this.setNumber(0);
	}
	
	public void end() {
		this.setNumber(this.getFatorial());

	}
	

}

public class Main {

	public static void main(String[] args) {
		System.out.println(Factorial.of(11) == 39916800);
		System.out.println(Factorial.of(6) == 720);
		System.out.println(Factorial.of(8) == 40320);
		Factorial fact = new Factorial(5);
		System.out.println(fact.number() == 0);
		System.out.println(fact.value() == 1);
		System.out.println(fact.next() == true);
		System.out.println(fact.number() == 1);
		System.out.println(fact.value() == 1);
		System.out.println(fact.next() == true);
		System.out.println(fact.number() == 2);
		System.out.println(fact.value() == 2);
		System.out.println(fact.next() == true);
		System.out.println(fact.number() == 3);
		System.out.println(fact.value() == 6);
		System.out.println(fact.next() == true);
		System.out.println(fact.number() == 4);
		System.out.println(fact.value() == 24);
		System.out.println(fact.next() == true);
		System.out.println(fact.number() == 5);
		System.out.println(fact.value() == 120);
		System.out.println(fact.next() == false);
		System.out.println(fact.number() == 5);
		System.out.println(fact.value() == 120);
		fact.begin();
		System.out.println(fact.number() == 0);
		System.out.println(fact.value() == 1);
		System.out.println(fact.next() == true);
		System.out.println(fact.number() == 1);
		System.out.println(fact.value() == 1);
		System.out.println(fact.next() == true);
		System.out.println(fact.number() == 2);
		System.out.println(fact.value() == 2);
		fact.end();
		System.out.println(fact.number() == 5);
		System.out.println(fact.value() == 120);
		System.out.println(fact.next() == false);
		Factorial fact2 = new Factorial(14);
		while (fact2.next())
			;
		System.out.println(fact2.number() == 14);
		System.out.println(fact2.value() == 87178291200l);
	}

}
