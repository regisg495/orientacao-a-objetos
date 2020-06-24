package restricoes_imutabilidade.Fraction;

class Fracao {
final int numerador;
final int denominador;

	Fracao(int numerador, int denominador){
		this.numerador = numerador;
		this.denominador = denominador;
	}
	Fracao add(Fracao k){
		if(k.denominador!=this.denominador)  
		return new Fracao((this.numerador * k.denominador + k.numerador * this.denominador / mdc(this.denominador, k.denominador)), k.denominador * this.denominador / mdc(this.denominador, k.denominador));
		
		return new Fracao(this.numerador + k.numerador, this.denominador);
	
	}
	
	Fracao add(int x) {
		return new Fracao(x * this.denominador + this.numerador, this.denominador);
	}	
	
	Fracao sub(Fracao k) {
		if(k.denominador!=this.denominador) 
		
		return new Fracao
		((this.numerador * k.denominador
		- k.numerador * this.denominador) 
		/ mdc(this.denominador, k.denominador)
		, k.denominador * this.denominador
		/ mdc (this.denominador, k.denominador));
		
		return new Fracao
		(this.numerador - k.numerador, 
		this.denominador);

	}
	Fracao mult(Fracao k) {
		return new Fracao(this.numerador * k.numerador,
				this.denominador * k.denominador);
	
	}
	
	Fracao div(Fracao k) {
		return new Fracao(k.denominador * this.numerador, k.numerador * this.denominador);
	
	} 
	Fracao inv() {
		return new Fracao(this.denominador, this.numerador);
	}

	Fracao() {
		this.numerador = 0;
		this.denominador = 1;
		return;
	}

	public int menor(int a, int b) {
		int menor = a < b ? a : b;
		    return menor;
		  }  
	
	public int mdc(int a, int b) {
		int mdc = menor(a, b);
		    while (a % mdc != 0 || b % mdc !=0) {
		      mdc = mdc - 1;
		    }
		    	return mdc;
	  }
	
	public boolean equals(Fracao x) {
		return this.numerador == x.numerador
				&& this.denominador == x.denominador;
	} 
}	

public class Main {
	public static void main(String[] args) {
		Fracao f1 = new Fracao(3, 5);
		System.out.println(f1.numerador == 3);
		System.out.println(f1.denominador == 5);
		 
		/* 
		as seguintes duas linhas n�o devem compilar, comente-as
		f1.numerador = 1;
		f1.denominador = 1;
		  
		Como aqui temos um objeto imut�vel sabe (Atributos s�o todos final)
		Somente com a cria��o de uma nova Instancia de Objeto fra��o � possivel ne
		Fracao f2 = new Fracao (1,1); 
		*/
		
		Fracao t1 = new Fracao(3, 5);
		System.out.println(f1.equals(t1) == true);
		 
		Fracao f2 = new Fracao(1, 5);
		System.out.println(f2.numerador == 1);
		System.out.println(f2.denominador == 5);
		 
		System.out.println(f2.equals(t1) == false);
		 
		Fracao r1 = f1.add(f2);
		System.out.println(r1.numerador == 4);
		System.out.println(r1.denominador == 5);
		System.out.println(f1.numerador == 3);
		System.out.println(f1.denominador == 5);
		System.out.println(f2.numerador == 1);
		System.out.println(f2.denominador == 5);
		// at� aqui 0.2 pts
		 
		Fracao f3 = new Fracao(3, 7);
		System.out.println(f3.numerador == 3);
		System.out.println(f3.denominador == 7);
		 
		Fracao r2 = f2.add(f3);
		System.out.println(r2.numerador == 22);
		System.out.println(r2.denominador == 35);
		System.out.println(f2.numerador == 1);
		System.out.println(f2.denominador == 5);
		System.out.println(f3.numerador == 3);
		System.out.println(f3.denominador == 7);
		// at� aqui 0.4 pts
		 
		Fracao r3 = r1.sub(r2);
		System.out.println(r3.numerador == 6);
		System.out.println(r3.denominador == 35);
		 
		Fracao r4 = r1.mult(r2);
		System.out.println(r4.numerador == 88);
		System.out.println(r4.denominador == 175);
		 
		Fracao r5 = r2.div(r1);
		System.out.println(r5.numerador == 110);
		System.out.println(r5.denominador == 140);
		 
		Fracao r6 = f1.inv(); // inversa
		System.out.println(r6.numerador == 5);
		System.out.println(r6.denominador == 3);
		 
		Fracao f4 = new Fracao(); // valor padr�o: 0/1
		System.out.println(f4.numerador == 0);
		System.out.println(f4.denominador == 1);
		System.out.println(f4.add(f4).numerador == 0);
		System.out.println(f4.add(f4).denominador == 1);
		 
		Fracao f5 = new Fracao(1, 2);
		System.out.println(f5.numerador == 1);
		System.out.println(f5.denominador == 2);
		System.out.println(f5.mult(f5).numerador == 1);
		System.out.println(f5.mult(f5).denominador == 4);
		// garantindo que n�o h� efeitos colaterais:
		System.out.println(f5.numerador == 1);
		System.out.println(f5.denominador == 2);
		//
		System.out.println(f5.mult(f5.mult(f5)).denominador == 8);
		// at� aqui 0.6 pts
		 
		Fracao f6 = new Fracao(1, 2);
		System.out.println(f6.numerador == 1);
		System.out.println(f6.denominador == 2);
		 
		Fracao r7 = f6.add(1);
		System.out.println(r7.numerador == 3);
		System.out.println(r7.denominador == 2);
		 
		Fracao r8 = f6.add(1);
		System.out.println(r8.numerador == 3);
		System.out.println(r8.denominador == 2);
		// at� aqui 0.8 pts
		 
	}

}
