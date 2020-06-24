package subtipagem_interfaces.ILIST;

public class Main {

	public static void main(String[] args) {
		// Main.java, main method
		 
		IList lista = new List();
		 
		System.out.println(lista.count() == 0);
		System.out.println(lista.isEmpty() == true);
		System.out.println(lista.get(0) == null);
		System.out.println(lista.getFirst() == null);
		System.out.println(lista.getLast() == null);
		System.out.println(lista.getLast() == null);
		System.out.println(lista.getSample() == null);
		 
		lista.append("a");
		 
		System.out.println(lista.isEmpty() == false);
		System.out.println(lista.count() == 1);
		System.out.println(lista.get(0).equals("a"));
		System.out.println(lista.getFirst().equals("a"));
		System.out.println(lista.getLast().equals("a"));
		System.out.println(lista.getFirst().equals(lista.getLast()));
		System.out.println(lista.getSample().equals("a"));
		 
		lista.append(2);
		lista.append("c");
		lista.append("d");
		lista.append("e");
		 
		System.out.println(lista.count() == 5);
		 
		System.out.println(lista.indexOf("a") == 0);
		System.out.println(lista.indexOf(2) == 1);
		System.out.println(lista.indexOf("e") == 4);
		System.out.println(lista.indexOf("f") == -1);
		System.out.println(lista.indexOf(3) == -1);
		 
		System.out.println(lista.getFirst().equals("a"));
		System.out.println(lista.getLast().equals("e"));
		System.out.println(lista.getSample() != null);
		 
		System.out.println(lista.get(1).equals(2));
		System.out.println(lista.get(2).equals("c"));
		System.out.println(lista.get(5) == null);
		 
		System.out.println(lista.has("a") == true);
		System.out.println(lista.has(3) == false);
		System.out.println(lista.has("f") == false);
		System.out.println(lista.has(2) == true);
		 
		System.out.println(lista.count() == 5);
		lista.append(null);
		System.out.println(lista.count() == 5);
		 
		System.out.println(lista.delete(1) == true);
		System.out.println(lista.delete(9) == false);
		 
		System.out.println(lista.count() == 4);
		 
		System.out.println(lista.get(0).equals("a"));
		System.out.println(lista.get(1).equals("c"));
		System.out.println(lista.get(2).equals("d"));
		System.out.println(lista.get(3).equals("e"));
		 
		System.out.println(lista.drop(2).equals("d"));
		 
		System.out.println(lista.count() == 3);
		 
		System.out.println(lista.remove("c") == true);
		 
		System.out.println(lista.count() == 2);
		 
		System.out.println(lista.get(0).equals("a"));
		System.out.println(lista.get(1).equals("e"));
		 
		System.out.println(lista.drop(2) == null);
		System.out.println(lista.remove("c") == false);
		 
		lista.reset();
		 
		System.out.println(lista.count() == 0);
		System.out.println(lista.isEmpty() == true);
		System.out.println(lista.get(0) == null);
		System.out.println(lista.getFirst() == null);
		System.out.println(lista.getLast() == null);
		System.out.println(lista.getSample() == null);
		 
		lista.append("Chell");
		lista.append("Alucard");
		 
		System.out.println(lista.count() == 2);
		System.out.println(lista.isEmpty() == false);
		System.out.println(lista.get(0).equals("Chell"));
		System.out.println(lista.get(1).equals("Alucard"));
		 
		lista.prepend("Sagat");
		 
		System.out.println(lista.count() == 3);
		System.out.println(lista.get(0).equals("Sagat"));
		System.out.println(lista.get(1).equals("Chell"));
		System.out.println(lista.get(2).equals("Alucard"));
		 
		System.out.println(lista.insert("Claire Redfield", 1) == true);
		 
		System.out.println(lista.count() == 4);
		System.out.println(lista.get(0).equals("Sagat"));
		System.out.println(lista.get(1).equals("Claire Redfield"));
		System.out.println(lista.get(2).equals("Chell"));
		System.out.println(lista.get(3).equals("Alucard"));
		 
		// todos os elementos devem ser alcanc�veis pelo sample em algum momento
		 
		System.out.print("Sagat ");
		while ( ! lista.getSample().equals("Sagat")) System.out.print(".");
		System.out.println(" OK");
		 
		System.out.print("Claire Redfield ");
		while ( ! lista.getSample().equals("Claire Redfield")) System.out.print(".");
		System.out.println(" OK");
		 
		System.out.print("Chell ");
		while ( ! lista.getSample().equals("Chell")) System.out.print(".");
		System.out.println(" OK");
		 
		System.out.print("Alucard ");
		while ( ! lista.getSample().equals("Alucard")) System.out.print(".");
		System.out.println(" OK");
		 
		// n�o pode inserir em �ndices n�o existentes
		System.out.println(lista.insert("Zelda", -1) == false);
		System.out.println(lista.insert("Zelda", 5) == false);
		 
		System.out.println(lista.count() == 4);
		 
		// mas inserir no fim pode!
		System.out.println(lista.insert("Zelda", 4) == true);
		 
		System.out.println(lista.count() == 5);
		System.out.println(lista.get(0).equals("Sagat"));
		System.out.println(lista.get(1).equals("Claire Redfield"));
		System.out.println(lista.get(2).equals("Chell"));
		System.out.println(lista.get(3).equals("Alucard"));
		System.out.println(lista.get(4).equals("Zelda"));
		
		System.out.println();
		System.out.println("Meus testes agora:");
		lista.reset();
		System.out.println(lista.isEmpty() == false); //false
		lista.append("Jill Valentine");
		lista.append("Albert Wesker");
		lista.append("Assassin Cross");
		System.out.println(lista.get(0) == "Jill Valentine");
		System.out.println(lista.getLast() == "Assassin Cross");
		lista.insert("Ermac", 0);
		System.out.println(lista.get(0) == "Ermac");
		System.out.println(lista.getLast() == "Assassin Cross");
		System.out.println(lista.get(5) == null);
		System.out.println(lista.count()); //4
		lista.insert("Smoke", 8);  //Me serviu pra arrumar xD
		System.out.println(lista.count()); //N�o inseriu
		System.out.println(lista.get(3)); //continua 4
		System.out.println(lista.get(4) == null);
		System.out.println(lista.delete(5) == false);
		System.out.println(lista.delete(2) == true);
		System.out.println(lista.get(2)); //Assassin Cross passa para o 2
		lista.prepend("Zrzrrrzrrr");
		System.out.println(lista.get(0));
		System.out.println(lista.get(3)); //Assassin Cross foi pra la
		System.out.println(lista.get(-1) == null);
		System.out.println(lista.delete(-80) == false); //Outra que me serviu pra arrumar
		lista.insert("Marcio", 2);
		System.out.println(lista.get(3));
		System.out.println(lista.get(2) == "Marcio");
		lista.drop(2);
		System.out.println(lista.get(2)); //Jill passou pra la
		lista.drop(2);
		System.out.println(lista.get(2)); //Assassin cross
		lista.drop(2);
		System.out.println(lista.get(2) == null);
		
		
	}

}
