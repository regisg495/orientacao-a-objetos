package relacionamentos_composicoes_herancas.escritorio;

public class OABInexistenteException extends IllegalArgumentException {
	public String toString() {
		return "O registro da OAB � composto apenas por n�meros ";
	}
}
