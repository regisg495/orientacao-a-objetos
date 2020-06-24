package relacionamentos_composicoes_herancas.escritorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Consulta {
	private LocalDateTime c;
	private final Advogado Advogado;
	private final Cliente Cliente;

	public Consulta(Advogado adv, Cliente cli, LocalDateTime c, Filial p, Processo d) {
		this.Advogado = adv;
		this.Cliente = cli;
		this.c = c;
	}

	public String toString() {
		return "Advogado: " + this.Advogado + ", Cliente: " + this.Cliente + ", Data: " + this.c;
	}

}
