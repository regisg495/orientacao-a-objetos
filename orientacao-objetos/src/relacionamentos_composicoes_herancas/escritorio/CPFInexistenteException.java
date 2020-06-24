package relacionamentos_composicoes_herancas.escritorio;

public class CPFInexistenteException extends IllegalArgumentException{
	public String toString() {
		return "O CPF � Composto por 11 n�meros";
	}
}
