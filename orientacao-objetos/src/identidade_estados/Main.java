package identidade_estados;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("xxxxxxxxx ------- Porta -------- xxxxxxxxx");
		
		Porta p1 = new Porta(233, 3434, "Aluminio");
		p1.fechada();
		p1.trancada();
		p1.aberta();
		p1.destrancada();

		System.out.println(p1.aberta()); //false
		System.out.println(p1.aberta() == false); 
		System.out.println(p1.fechada() == true);
		System.out.println(p1.trancada()); // false
		System.out.println(p1.trancada() == false);
		
		//abrir
		p1.abrir();
		System.out.println(p1.aberta() == true);
		
		// fechar
		p1.fechar();
		System.out.println(p1.aberta() == false);
		
		p1.trancar();
		System.out.println(p1.trancada() == true);
		// não é possível abrir se trancada
		
		p1.abrir();
		System.out.println(p1.aberta() == false);
		// destrancar
		p1.destrancar();
		System.out.println(p1.trancada() == false);
		// pode abrir
		p1.abrir();
		System.out.println(p1.aberta() == true);
		// não pode trancar se aberta
		p1.trancar();
		System.out.println(p1.trancada() == false);
		// fechar e trancar
		p1.fechar(); p1.trancar();
		System.out.println(p1.aberta() == false);
		System.out.println(p1.trancada() == true);
		
		
		/*
		 * 
		 */
		
		System.out.println("xxxxxxx ----- Conta ------ xxxxxx");
		
		Conta minhaConta = new Conta (3300, 33345);
		minhaConta.saldo();
		
		System.out.println(minhaConta.agencia == 3300);
		System.out.println(minhaConta.numero == 33345);

		System.out.println(minhaConta.saldo()); // 500.0
		System.out.println(minhaConta.saldo() == 500.0);
		// não é permitido
		minhaConta.sacar(600.0);
		System.out.println(minhaConta.saldo()); // 500.0
		System.out.println(minhaConta.saldo() == 500.0);
		// é permitido
		minhaConta.sacar(60.0); // 500.0 - 60.0 == 440.0
		System.out.println(minhaConta.saldo()); // 440.0
		System.out.println(minhaConta.saldo() == 440.0);
	
		minhaConta.depositarEmDinheiro(1100.0);
		System.out.println(minhaConta.saldo()); // 440.0
		System.out.println(minhaConta.saldo() == 440.0);
		// depósito em dinheiro permitido
		minhaConta.depositarEmDinheiro(500.0); // 440.0 + 500.0 == 940.0
		System.out.println(minhaConta.saldo()); // 940.0
		System.out.println(minhaConta.saldo() == 940.0);
		// depósito em cheque não permitido
		minhaConta.depositarEmCheque(11100.0);
		System.out.println(minhaConta.saldo()); // 940.0
		System.out.println(minhaConta.saldo() == 940.0);
		// depósito em cheque permitido
		minhaConta.depositarEmCheque(5000.0); // 940.0 + 5000.0 == 5940.0
		System.out.println(minhaConta.saldo()); // 5940.0
		System.out.println(minhaConta.saldo() == 5940.0);

		
		System.out.println("xxxxxxx --------- ATM --------- xxxxxxxx");
		
		ATM atm = new ATM(2344499);
		System.out.println(atm.numeroSerie == 2344499);
		// a linha a seguir não compila, comente-a
		/* atm.numeroSerie = 34883444; Isso não compila porque colocamos
		la encima como final, dai vc não pode alterar, p alterar teriamos
		que colocar como normal sabe. Faz todo sentido, dado que o numero 
		de serie de um ATM não deve ser alterada, é algo de fábrica
		*/
		// o ATM não tem dinheiro no início
		System.out.println("Testes do Marcio:");
		System.out.println(atm.consultarValor()); // 0
		System.out.println(atm.consultarValor() == 0);
		// abastecendo com 33 notas de 100
		atm.abastecer(33, 100);
		// verificando a quantidade de cédulas de 100
		System.out.println(atm.consultarQuantidade(100)); // 33
		// espera-se 33 cédulas
		System.out.println(atm.consultarQuantidade(100) == 33);
		// espera-se nenhuma cédula de qualquer outro valor
		System.out.println(atm.consultarQuantidade(5)); // 0
		System.out.println(atm.consultarQuantidade(5) == 0);
		System.out.println(atm.consultarQuantidade(50)); // 0
		System.out.println(atm.consultarQuantidade(50) == 0);
		// mesmo os que não existem podem ser consultados, mas retornam 0
		System.out.println(atm.consultarQuantidade(3)); // 0
		System.out.println(atm.consultarQuantidade(3) == 0);
		// abastecimento de cédulas não existentes são rejeitados
		atm.abastecer(8, 3); // 8 cédulas de R$ 3,00
		System.out.println(atm.consultarQuantidade(3) == 0);
		// consultando o valor
		System.out.println(atm.consultarValor()); // 33 * 100 = 3300 reais
		System.out.println(atm.consultarValor() == 3300);
		// retirada rejeitada
		atm.retirar(350); // não há cédulas de R$ 50,00
		System.out.println(atm.consultarQuantidade(100) == 33);
		System.out.println(atm.consultarValor() == 3300);
		// retirada válida
		atm.retirar(300); // 3 cédulas de 100
		System.out.println(atm.consultarQuantidade(100) == 30);
		System.out.println(atm.consultarValor() == 3000);
		// retirada rejeitada
		atm.retirar(3100); // não há cédulas suficientes
		System.out.println(atm.consultarQuantidade(100) == 30);
		System.out.println(atm.consultarValor() == 3000);
		// retirada válida
		atm.retirar(3000); // vai esvaziar o ATM
		System.out.println(atm.consultarQuantidade(100) == 0);
		System.out.println(atm.consultarValor() == 0);
		// abastecimento de R$ 50,00 e R$ 10,00
		atm.abastecer(10, 10); // 10 cédulas de R$ 10,00
		atm.abastecer(10, 50); // 10 cédulas de R$ 50,00
		System.out.println(atm.consultarQuantidade(10) == 10);
		System.out.println(atm.consultarQuantidade(50) == 10);
		System.out.println(atm.consultarValor() == 600); // 10 * 10 + 10 * 50
		// retirada prioriza cédulas de maior valor
		atm.retirar(100); // retira 2 cédulas de R$ 50,00
		System.out.println(atm.consultarQuantidade(10) == 10);
		System.out.println(atm.consultarQuantidade(50) == 8);
		System.out.println(atm.consultarValor() == 500); // 10 * 10 + 8 * 50
		// retirada combinada
		atm.retirar(90); // 1 cédula de R$ 50,00 e 4 cédulas de R$ 10,00
		System.out.println(atm.consultarQuantidade(10) == 6);
		System.out.println(atm.consultarQuantidade(50) == 7);
		System.out.println(atm.consultarValor() == 410); // 6 * 10 + 7 * 50
		// incluir casos de teste pessoais com retiradas
		// quem combinam 3, 4 e 5 cédulas
		// ---------------------------------------------------
		//de 3 cédulas
		System.out.println("");
		System.out.println("");
		System.out.println("Teste de 3 cédulas:");
		atm.abastecer(1, 100);
		System.out.println(atm.consultarQuantidade(10)); //6
		System.out.println(atm.consultarQuantidade(20)); //0
		System.out.println(atm.consultarQuantidade(50)); //7
		System.out.println(atm.consultarQuantidade(100)); //1
		System.out.println(atm.consultarQuantidade(5)); //0
		System.out.println(atm.consultarValor()); //510
		atm.retirar(170);
		System.out.println(atm.consultarValor()); //510 - 170 = 340
		System.out.println(atm.consultarValor() == 340);
		System.out.println(atm.consultarQuantidade(100));//0
		System.out.println(atm.consultarQuantidade(50)); //6
		System.out.println(atm.consultarQuantidade(10));  // 4
		//1 nota de 100, 1 nota de 50 e 2 de 10 sabe
		System.out.println("");
		System.out.println("");
		System.out.println("Teste de 4 cedulas:");
		//de 4 cedulas
		System.out.println(atm.consultarQuantidade(10)); //4 agora
		System.out.println(atm.consultarQuantidade(20)); //0
		System.out.println(atm.consultarQuantidade(50)); //6 agora
		System.out.println(atm.consultarQuantidade(100)); //0 agora
		System.out.println(atm.consultarQuantidade(5)); //0
		atm.abastecer(2, 100);
		atm.abastecer(3, 5);
		System.out.println(atm.consultarQuantidade(5)); //3 agora ne
		System.out.println(atm.consultarQuantidade(100));//2+0 = 2
		System.out.println(atm.consultarValor());
		//(2 * 100) + (3 * 5 = 15) + (6 * 50) + (4 * 10)
		//200 + 15 + 300 + 40 == 555
		System.out.println(atm.consultarValor() == 555);
		atm.retirar(365);
		System.out.println(atm.consultarValor());//555 - 365 = 190
		System.out.println(atm.consultarValor() == 190);
		System.out.println(atm.consultarQuantidade(10)); //tinha 4 agora 3
		System.out.println(atm.consultarQuantidade(20)); //tinha 0 ficou 0
		System.out.println(atm.consultarQuantidade(50)); //tinha 6 agora 3
		System.out.println(atm.consultarQuantidade(100)); //tinha 2 agora 0
		System.out.println(atm.consultarQuantidade(5)); //tinha 3 agora 2
		System.out.println("");
		System.out.println("");
		System.out.println("Testes de 5 cédulas:");
		//de 5 cédulas
		System.out.println(atm.consultarQuantidade(10)); //3
		System.out.println(atm.consultarQuantidade(20)); //0
		System.out.println(atm.consultarQuantidade(50));//3
		System.out.println(atm.consultarQuantidade(100));//0
		System.out.println(atm.consultarQuantidade(5));//2
		System.out.println(atm.consultarValor());
		//(5*2)+(10*3)+(50*3)=190 ne
		System.out.println(atm.consultarValor() == 190);
		atm.abastecer(4, 100);
		atm.abastecer(8, 20);
		System.out.println(atm.consultarQuantidade(20));// 8
		System.out.println(atm.consultarQuantidade(100));// 4
		System.out.println(atm.consultarValor()); 
		//(8 * 20) + (100 * 4) + os 190 q ja tava é = 160+400+190 = 750
		System.out.println(atm.consultarValor() == 750); 
		atm.retirar(585);
		System.out.println(atm.consultarQuantidade(10)); 
		System.out.println(atm.consultarQuantidade(20)); 
		System.out.println(atm.consultarQuantidade(50));
		System.out.println(atm.consultarQuantidade(100));
		System.out.println(atm.consultarQuantidade(5));
		/*Tinhamos 3 notas de 10, ficou 2
		tinhamos 8 notas de 20, ficou 7
		tinhamos 2 notas de 5, ficou 1
		tinhamos 4 notas de 100, ficou 0
		tinhamos 3 notas de 50, ficou 0
		Então, 1* 10 = 10
		1 * 20 = 20
		1 * 5 = 5
		4 * 100 = 400
		50 * 5 = 150
		5 + 10 + 20 + 400 + 150 = 585
		// 750 - 585 = 165 
		*/
		System.out.println(atm.consultarQuantidade(10) == 2); 
		System.out.println(atm.consultarQuantidade(20) == 7); 
		System.out.println(atm.consultarQuantidade(50) == 0);
		System.out.println(atm.consultarQuantidade(100) == 0);
		System.out.println(atm.consultarQuantidade(5) == 1);
		System.out.println(atm.consultarValor()); 
		System.out.println(atm.consultarValor() == 165); 
	
		System.out.println("xxxxxxxxx -------- Forno -------- xxxxxxxxx");
		
		Forno f1 = new Forno ( "Mondial", "Pratic Cook", "Cinza", 1500, 220, 36.0, 50.0, 32.0, false );
		f1.ligar();
		System.out.println(f1.temperatura());
		f1.dourar(); //100
		System.out.println(f1.dourarligado() == true);
		System.out.println(f1.temperatura());
		f1.assar(); //200
		System.out.println(f1.temperatura() == 300);
		f1.aumentartemperatura(); //Impossivel Aumentar
		System.out.println(f1.temperatura());
		f1.desligar();
		System.out.println(f1.temperatura()); //0
		System.out.println(f1.temperatura() == 0);
		//Não compila p1.marca = "Britania";
		// Não compila p1.temperatura = 20;
		f1.ligarluz();
		System.out.println(f1.luz()); //False, não pode ligar quando desligado o aparelho
		f1.ligar();
		f1.ligarluz();
		System.out.println(f1.luz());
		System.out.println(f1.temperatura());
		f1.dourar();
		System.out.println(f1.temperatura()); //100
		f1.diminuirtemperatura();
		System.out.println(f1.temperatura()); //Impossivel Diminuir
		//p1.altura = 32; Não compila 
		f1.temperatura();
		
	}

}
