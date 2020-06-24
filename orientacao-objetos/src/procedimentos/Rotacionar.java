package procedimentos;

 class Rotacionar {

	static String rotate(String s) {
		if (s.length() == 1 || s.length() == 0) {
			return s;

		} else if (s.charAt(s.length() - 1) == ' ') {
			return s;
		} else {
			String s1 = "";
			s1 += s.charAt(s.length() - 1);
			for (int i = 0; i < s.length() - 1; i++) {

				s1 += s.charAt(i);
			}
			return s1;
		}
	}

	public static void main(String[] args) {
		// Rotacionar.java
		String s1 = "worf";
		String s2 = rotate(s1);
		System.out.println(s1); // worf
		System.out.println(s2); // fwor
		System.out.println(s2.equals("fwor") == true); // true
		String s3 = rotate(s2);
		System.out.println(s3); // rfwo
		System.out.println(s3.equals("rfwo") == true); // true
		System.out.println(rotate("kira").equals("akir") == true);
		System.out.println(rotate(rotate(s3)).equals("worf") == true);
		String s4 = "captain sisko";
		System.out.println(rotate(s4).equals("ocaptain sisk") == true);
		for (int i = 0; i < 5; i++) s4 = rotate(s4);
		System.out.println(s4.equals("siskocaptain ") == true);

		// 0.1 pts até aqui
		// Casos Especiais
		System.out.println(rotate("").equals("") == true);
		System.out.println(rotate("a").equals("a") == true);
		System.out.println(rotate("aa").equals("aa") == true);
		// 0.2 pts até aqui
		// Adicione mais 2 Casos de Teste
		System.out.println("Testes");
		System.out.println(rotate("ola mundo java").equals("aola mundo jav"));
		System.out.println(rotate("ola ").equals("ola "));
	}

}
