package jakarta.dao;

import java.util.ArrayList;
import java.util.List;

import testeexportarcomgradlew.beans.Morador;

public class MoradorDao {

	private static List<Morador> moradores = new ArrayList<Morador>();

	public void cadastrar(Morador m) {
		moradores.add(m);
	}

	public List<Morador> pesquisar() {
		return moradores;
	}

	public void remover(Morador m) {
		moradores.remove(m);
	}
}
