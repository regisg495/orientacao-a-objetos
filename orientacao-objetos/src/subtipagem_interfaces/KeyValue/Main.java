package subtipagem_interfaces.KeyValue;

public class Main {

	public static void main(String[] args) {
		// escreva a interface IKeyValue
		// lembre que nos testes a seguir n�o est� previsto
		// o m�todo para remover uma chave/valor
		IKeyValue tabela = new KeyValue(); // implemente na classe KeyValue

		tabela.put("noob saibot", 0); // put(String key, Integer value)
		tabela.put("abobo", 10);
		Integer v = tabela.get("noob saibot"); // 0
		System.out.println(v == 0);
		System.out.println(tabela.get("noob saibot") == 0);
		System.out.println(tabela.get("abobo") == 10);
		tabela.put("noob saibot", 50); // se j� existe, subtitui o value
		System.out.println(tabela.get("noob saibot") == 50);

		tabela.put("noob saibot", tabela.get("noob saibot") + 20);
		System.out.println(tabela.get("noob saibot") == 70);

		Integer v2 = tabela.get("zitz"); // null
		System.out.println(v2 == null);
		System.out.println(tabela.get("zitz") == null);

		boolean b1 = tabela.hasKey("zitz"); // false
		boolean b2 = tabela.hasKey("abobo"); // true
		System.out.println(b1 == false);
		System.out.println(b2 == false);
		String[] keys = tabela.getKeys();
		Integer[] values = tabela.getValues();
		System.out.println(keys.length == 2);
		System.out.println(values.length == 2);

		System.out.println(keys[0].equals("noob saibot"));
		System.out.println(keys[1].equals("abobo"));

		System.out.println(values[0].equals(70));
		System.out.println(values[1].equals(10));

		System.out.println("Meus Testes:");
		tabela.remove("abobo");
		Integer x = tabela.get("abobo");
		System.out.println(x);// null
		tabela.remove("noob saibot");
		x = tabela.get("noob saibot");
		System.out.println(x);// null
		tabela.put("Ermac", 20);
		tabela.put("Rain", 35);
		tabela.put("Scorpion", 8);
		tabela.put("Smoke", 1);
		x = tabela.get("Ermac");
		System.out.println(x == 20); // 20
		x = tabela.get("Scorpion");
		System.out.println(x == 8); // 8
		tabela.put("Sektor", 58);
		String[] keys2 = tabela.getKeys();
		Integer[] k = tabela.getValues();
		System.out.println("Chaves:");
		for (String string : keys2) {
			System.out.print(string + " " + "");// Ermac, Rain, Scorpion, Smpoke, Sektor
		}
		System.out.println("");
		System.out.println("Valores:");
		for (Integer integer : k) {
			System.out.print(integer + " "); // 28, 35, 8, 1, 58
		}
		tabela.reset();
		String keys3[] = tabela.getKeys();
		Integer integer3[] = tabela.getValues();
		for (Integer integer : integer3) {
			System.out.println(integer); // Vazio!
		}
		for (String string : keys3) {
			System.out.println(string); // Vazio!

		}
	}
}
