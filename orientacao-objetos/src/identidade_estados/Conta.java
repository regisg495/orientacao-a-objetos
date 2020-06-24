package identidade_estados;

public class Conta {
	
	private double saldo;
	final int agencia;
	final int numero;
	double dinheiro;
	double sacar;
	double cheque;


	Conta(int agencia, int numero) {
	this.agencia = agencia;
	this.numero = numero;
	this.saldo = 500;
	}

	public double saldo() {
		return this.saldo;
	}
	
	public double validardepositoemcheque(double cheque) {
		if((cheque>10000) || (cheque<=0)){
			cheque = 0;
		}
		return cheque;
	}
	
	public double depositarEmCheque(double cheque) {
		return this.saldo += validardepositoemcheque(cheque);
	}
	
	public double validardepositoemdinheiro(double deposito) {
		if((deposito>1000) || (deposito <=0)) {
			deposito = 0;
		}
		return deposito;
		}
	
	void depositarEmDinheiro(double dinheiro) {
		 this.saldo += validardepositoemdinheiro(dinheiro);
	}
		
	void sacar(double sacar) {
		if(this.saldo >= sacar){
			this.saldo = this.saldo - sacar;
		}
	}

}
