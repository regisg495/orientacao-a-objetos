package objetos_extras.coordenada_geografica;

class Coordenada {
	final double latitude;
	final double longitude;
	
	
	public Coordenada() {
		this.latitude = 0;
		this.longitude = 0;
	} 

	public Coordenada(double latitude, double longitude) {
		if (latitude < -90.0 || latitude > 90.0) {
			throw new IllegalArgumentException("A Latitude vai de - 90.0 a 90.0 graus");
		} else
			this.latitude = latitude;
		if (longitude < -180.0 || longitude > 180.0) {
			throw new IllegalArgumentException("A Longitude vai de -180.0 a 180.0 graus");
		} else
			this.longitude = longitude;
	}

	public Coordenada norte(double norte) {
		if (this.latitude + norte == 90 || this.latitude + norte == -90)
			return new Coordenada(this.latitude + norte, this.longitude);
		else
			return new Coordenada(((this.latitude + norte) % 90), this.longitude);
	}

	public Coordenada sul(double sul) {
		if (this.latitude - sul == 90 || this.latitude - sul == -90)
			return new Coordenada(this.latitude - sul, this.longitude);
		else
			return new Coordenada(((this.latitude - sul) % 90), this.longitude);
	}

	public Coordenada leste(double leste) {
		if (this.longitude + leste == 180 || this.longitude + leste == -180)
			return new Coordenada(this.latitude, this.longitude + leste);
		else
			return new Coordenada(this.latitude, (this.longitude + leste) % 180);
	}

	public Coordenada oeste(double oeste) {
		if (this.longitude - oeste == 180 || this.longitude - oeste == -180)
			return new Coordenada(this.latitude, this.longitude - oeste);
		else
			return new Coordenada(this.latitude, (this.longitude - oeste) % 180);
	}

	public boolean noEquador() {
		if (this.latitude != 0)
			return false;
		else
			return true;
	}

	public boolean noMeridiano() {
		if (this.longitude != -180.0 && this.longitude != 180.0 && this.longitude != 0)
			return false;
		else
			return true;
	}

	public boolean noNorte() {
		if (this.latitude >= -90.0 && this.latitude <= 90.0 && this.latitude > 0) {
			return true;
		} else
			return false;
	}

	public boolean noSul() {
		if (this.latitude >= -90.0 && this.latitude <= 90.0 && this.latitude < 0) {
			return true;
		} else
			return false;
	}

	public boolean noOriente() {
		if (this.longitude >= -180.0 && this.longitude <= 180.0 && this.longitude > 0) {
			return true;
		} else
			return false;

	}

	public boolean noOcidente() {
		if (this.longitude >= -180.0 && this.longitude <= 180.0 && this.longitude < 0) {
			return true;
		} else
			return false;
	}

	public String toString() {
		return this.latitude + "�" + ", " + this.longitude + "�";
	}

	public String googleMaps() {
		String s;
		s = "https://www.google.com.br/maps/@" + this.latitude + "," + this.longitude + "," + "10z?hl=pt-BR";
		return s;
	}

	public boolean equals(Coordenada k) {
		if ((k.latitude == this.latitude) && (k.longitude == this.longitude))
			return true;
		else
			return false;
	}

}

public class Main {

	public static void main(String[] args) {
		// construtores
		Coordenada c1 = new Coordenada();
		System.out.println(c1.latitude == 0.0);
		System.out.println(c1.longitude == 0.0);

		Coordenada c2 = new Coordenada(50.0, 134.0);
		System.out.println(c2.latitude == 50.0);
		System.out.println(c2.longitude == 134.0);

		Coordenada c3 = new Coordenada(-90.0, -180.0);
		System.out.println(c3.latitude == -90.0);
		System.out.println(c3.longitude == -180.0);

		// estas coordenadas s�o inv�lida e devem lan�ar exce��o
		// fa�a serem rejeitadas e depois comente-as para n�o parar o programa
		/*
		 * Coordenada e1 = new Coordenada(-91.0, 0.0); Coordenada e2 = new
		 * Coordenada(100.0, 0.0); Coordenada e3 = new Coordenada(10.0, -182.0);
		 * Coordenada e4 = new Coordenada(10.0, 200.0); Coordenada e5 = new
		 * Coordenada(-95.0, -200.0);
		 */
		// imutabilidade: as linhas a seguir devem causar erro de compila��o
		// verifique se est� de acordo e depois comente-as
		Coordenada c4 = new Coordenada();
		// c4.latitude = 30.0;
		// c4.longitude = 80.0;
		// N�o pode porque � Final, s� instanciando
		// Uma nova coordenada com tais valores ne.

		// opera��es/comandos
		Coordenada in = new Coordenada(30.0, 50.0);
		Coordenada out = in.norte(5.0);
		System.out.println(in.latitude == 30.0); // deve ser imut�vel
		System.out.println(out.latitude == 35.0);
		out.norte(5.0); // sem reatribui��o sem altera��o
		System.out.println(out.latitude == 35.0);
		out = out.norte(5.0); // reatribuindo
		System.out.println(out.latitude == 40.0);
		out = out.sul(60.0);
		System.out.println(out.latitude == -20.0);
		out = out.sul(30.0);
		System.out.println(out.latitude == -50.0);
		out = out.sul(-10.0);
		System.out.println(out.latitude == -40.0);
		out = out.norte(-10.0);
		System.out.println(out.latitude == -50.0);
		System.out.println(out.longitude == 50.0);
		out = out.leste(50.0);
		System.out.println(out.longitude == 100.0);
		out = out.oeste(180.0);
		System.out.println(out.longitude == -80.0);
		out = out.oeste(-10.0);
		System.out.println(out.longitude == -70.0);
		out = out.leste(-10.0);
		System.out.println(out.longitude == -80.0);

		// consultas
		Coordenada q = new Coordenada();
		System.out.println(q.noEquador() == true);
		System.out.println(q.noMeridiano() == true);
		q = q.norte(10.0);
		System.out.println(q.noEquador() == false);
		q = q.leste(10.0);
		System.out.println(q.noMeridiano() == false);
		q = q.leste(170.0);
		System.out.println(q.longitude == 180.0);
		System.out.println(q.noMeridiano() == true);
		q = q.oeste(200.0);
		System.out.println(q.longitude == -20.0);
		System.out.println(q.noMeridiano() == false);
		q = q.oeste(160.0);
		System.out.println(q.longitude == -180.0);
		System.out.println(q.noMeridiano() == true);

		Coordenada r = new Coordenada(30.0, 70.0);
		/*
		 * Esse teste abaixo ir� falhar da forma como est� Creio que voc� quis p�r == ao
		 * inves de =. Vou deixar ele comentado e se voc� quiser p�e == at� porque dar�
		 * true
		 */

		// System.out.println(r.latitude = 30.0);
		// System.out.println(r.longitude = 70.0);

		System.out.println(r.noNorte() == true);
		System.out.println(r.noSul() == false);
		System.out.println(r.noOriente() == true);
		System.out.println(r.noOcidente() == false);
		r = r.oeste(140.0).sul(60.0);
		/*
		 * A mesma coisa em rela��o ao teste abaixo, voc� colocou = (creio eu kkkk), ao
		 * inves de == vou comenta-lo
		 */
		// System.out.println(r.latitude = -30.0);
		// System.out.println(r.longitude = -70.0);
		System.out.println(r.noNorte() == false);
		System.out.println(r.noSul() == true);
		System.out.println(r.noOriente() == false);
		System.out.println(r.noOcidente() == true);

		// sobrescrever o m�todo toString()
		Coordenada t = new Coordenada(-32.0714021, -52.1425059);
		// https://www.google.com.br/maps/@-32.0714021,-52.1425059,13z?hl=pt-BR
		System.out.println(t);
		// imprime -32.0714021�, -52.1425059�
		System.out.println(t.toString().equals("-32.0714021�, -52.1425059�"));

		// desafio2: escrever m�todo que retorna link para Google Maps!
		// Mudei para Coordenada y, d� duplicate local variable t
		Coordenada y = new Coordenada(37.402473, -122.3212843);
		String url = y.googleMaps(); // Tamb�m mudei para y obviamente
		System.out.println(url.equals("https://www.google.com.br/maps/@37.402473,-122.3212843,10z?hl=pt-BR"));
		// descomente para ver se funciona (n�o testei)
		// Runtime.getRuntime().exec("google-chrome " + url);
		// tente outro navegador, no windows tente "start " + url

	}

}
