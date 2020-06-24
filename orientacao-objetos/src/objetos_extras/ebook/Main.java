package objetos_extras.ebook;

class EBook {
	final String titulo;
	final int paginas;
	private int actualpage;

	// final porque n�o podem mudar, e o actualpage � um private
	public int getActualpage() {
		return actualpage;
	}

	public void setActualpage(int actualpage) {
		this.actualpage = actualpage;
	}
	// Getters and Setters

	public EBook(String titulo, int paginas) {
		if (titulo.length() == 0) {
			throw new IllegalArgumentException();
		}
		if (paginas <= 0 || paginas > 5000) {
			throw new IllegalArgumentException();
		} else
			this.titulo = titulo;
		this.paginas = paginas;
		this.setActualpage(1);
	}

	/*
	 * se titulo.length == 0 (titulo vazio) lan�a IllegalArgumentException, se
	 * paginas s�o <=0 > 5000 ent�o solta outra Illegal argument
	 */
	public int paginaAtual() {
		return this.getActualpage();
	}

	public void virarPagina() {
		if (this.getActualpage() < this.paginas)
			this.setActualpage(this.actualpage + 1);
	}

	// Se a pagina for menor que this.paginas(total de paginas)
	// entao pode trocar
	public void voltarPagina() {
		this.actualpage--;
		if (this.getActualpage() < 1) {
			this.setActualpage(1);
			throw new IllegalStateException();
		}
	}
	/*
	 * this.actualpage recebe -1, se ela for menor que 1, entao volta p 1 e lan�a
	 * IllegalStateException, bom, foi a unica forma que consegui fazer
	 */
}

public class Main {
	public static void main(String[] args) {
		// titulo = "Os inovadores", paginas = 544
		EBook e1 = new EBook("Os inovadores", 544);

		System.out.println(e1.titulo); // Os inovadores
		System.out.println(e1.titulo.equals("Os inovadores")); // true

		// essa linha n�o deve compilar (comente-a)
		// e1.titulo = "Alterando o t�tulo";
		// Como os atributos s�o final, somente com instanciando um novo livro para
		// alterar o titiulo
		System.out.println(e1.paginas); // 544
		System.out.println(e1.paginas == 544); // true

		// essa linha n�o deve compilar (comente-a)
		// e1.paginas = 120
		// Tamb�m, somente instanciando um novo livro

		// p�gina atual sendo lida sempre inicia com 1
		System.out.println(e1.paginaAtual() == 1);

		// essa linha n�o deve compilar (comente-a)
		// System.out.println(e1.paginaAtual); // sem acesso direto � p�gina atual
		// N�o compila porque private.
		// sequ�ncia de e-books inv�lidos
		// as instru��es devem lan�ar uma IllegalArgumentException

		try {
			EBook ebookInvalido = new EBook("", 544); // titulo vazio
			System.out.println(false); // essa linha n�o deve ser alcan�ada
		} catch (IllegalArgumentException e) { // a exce��o deve ser capturada
			System.out.println(true);
		}

		try {
			EBook ebookInvalido = new EBook("Um titulo", 0); // sem p�ginas
			System.out.println(false);
		} catch (IllegalArgumentException e) {
			System.out.println(true);
		}

		try {
			EBook ebookInvalido = new EBook("Um titulo", -10); // p�ginas negativas
			System.out.println(false);
		} catch (IllegalArgumentException e) {
			System.out.println(true);
		}

		try {
			EBook ebookInvalido = new EBook("Um titulo", 6000); // p�ginas > 5000
			System.out.println(false);
		} catch (IllegalArgumentException e) {
			System.out.println(true);
		}
		EBook e2 = new EBook("A catedral e o bazar", 14);
		// http://www.dominiopublico.gov.br/pesquisa/DetalheObraForm.do?select_action=&co_obra=8679
		System.out.println(e2.titulo.equals("A catedral e o bazar"));
		System.out.println(e2.paginas == 14);
		System.out.println(e2.paginaAtual() == 1);

		EBook e3 = new EBook("O (comovente) guia de Ruby do why", 121);
		// http://why.carlosbrando.com/
		// https://en.wikipedia.org/wiki/Why_the_lucky_stiff
		System.out.println(e3.titulo.equals("O (comovente) guia de Ruby do why"));
		System.out.println(e3.paginas == 121);

		e2.virarPagina(); // paginaAtual + 1
		System.out.println(e2.paginaAtual() == 2);

		for (int i = 0; i < 10; i++)
			e2.virarPagina(); // 10 pag viradas
		System.out.println(e2.paginaAtual() == 12);
		e2.voltarPagina();

		System.out.println(e2.paginaAtual() == 11);

		for (int i = 0; i < 10; i++)
			e2.voltarPagina(); // 10 pag atr�s
		System.out.println(e2.paginaAtual() == 1);

		// tentar voltar p�gina antes do 1 deve ser proibido
		// lan�ando IllegalStateException, descomente, verifique, comente outra vez

		try {
			e2.voltarPagina(); // deve lan�ar IllegalStateException
			System.out.println(false);
		} catch (IllegalStateException e) {
			System.out.println(true);
		}

		System.out.println(e2.paginaAtual() == 1);
	}

}
