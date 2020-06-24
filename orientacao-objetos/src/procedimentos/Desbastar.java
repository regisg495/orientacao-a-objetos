package procedimentos;

	class Desbastar {

	 static String chop(String s) {
		if(s.length() == 0 || s.length() == 1) {
			return "";
		}
		return s.substring(0, s.length() - 1);
	}
	public static void main(String[] args) {
		// Desbastar.java
		String s1 = "seven of nine";
		String s2 = chop(s1);
		System.out.println(s1); // seven of nine
		System.out.println(s2); // seven of nin
		System.out.println(s2.equals("seven of nin") == true); // true
		String s3 = chop(s2);
		System.out.println(s3); // seven of ni
		System.out.println(s3.equals("seven of ni") == true); // true
		System.out.println(chop("spock").equals("spoc") == true);
		// 0.1 pts até aqui
		// Casos Especiais
		System.out.println(chop("Q").equals("") == true);
		System.out.println(chop("").equals("") == true);
		System.out.println(chop(chop(chop("abc"))).equals("") == true);
		String s4 = "jean-luc picard";
		System.out.println(s4);
		while (s4.length() > 0) {
		    s4 = chop(s4);
		    System.out.println(s4);
		}
		System.out.println(s4.equals("") == true);
		// 0.2 pts até aqui
		// Adicione mais 2 Casos de Teste:

		System.out.println(chop(" sssp ").equals(" sssp"));
		System.out.println(chop(chop("cc c p")).equals("cc c"));


	}

}
