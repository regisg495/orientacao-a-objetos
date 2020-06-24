package identidade_estados;

public class ATM {
	
	final int numeroSerie;
	int valortotal;
	int cedulasvalor []  =  { 5, 10, 20, 50, 100 };
	int cedulasdepositos [] = { 0, 0, 0, 0, 0 };
	int abastecer;
	int tipodenota;
	int temp;

	public double consultarValor() {
		valortotal = 0;
		for(int x = 0; x<cedulasvalor.length; x++) {
		 this.valortotal += this.cedulasvalor[x] * this.cedulasdepositos[x];
		}
		return (double)this.valortotal;
	}

	ATM(int numeroSerie) {
	this.numeroSerie = numeroSerie;

		}
	void abastecer(int abastecer, int tipodenota) {
		if((abastecer>=1)&&(abastecer<=100)){
		for(int x = 0; x<cedulasvalor.length; x++) {
			if(tipodenota==this.cedulasvalor[x]) {
			this.cedulasdepositos[x] += abastecer;
				}
			}
		}
	}
	int consultarQuantidade(int tipodenota) {
		if(((tipodenota!=5) && (tipodenota!=10) && (tipodenota!=20) && (tipodenota!=50) && (tipodenota!=100))){
		return tipodenota = 0;
		}else{
		for(int x = 0; x<cedulasvalor.length; x++) {
			if(tipodenota==cedulasvalor[x]) {
				return this.cedulasdepositos[x];
				}
			}
		return tipodenota;
		}
	}
	void retirar(int valorretirada) {
		int n1 = valorretirada;
		temp = 0;
		
		if(valorretirada < 0) return;
		
		for(int x = cedulasvalor.length -1; x>=0; x--) {
			temp = n1/this.cedulasvalor[x];
			if(this.cedulasdepositos[x] < temp)
				temp = this.cedulasdepositos[x];
			n1 -= (temp * cedulasvalor[x]);
		}
		if(n1 != 0) return;
		
		for(int x = cedulasdepositos.length -1; x>=0; x--) {
			if(this.cedulasdepositos[x] > 0) {
				temp = valorretirada/this.cedulasvalor[x];
				if(this.cedulasdepositos[x] < temp) temp = this.cedulasdepositos[x];
				this.cedulasdepositos[x] -= temp;
				valorretirada -= (temp * cedulasvalor[x]);
			}
		}
	}

}
