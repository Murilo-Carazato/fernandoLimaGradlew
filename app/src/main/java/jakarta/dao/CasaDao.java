package jakarta.dao;

import java.util.ArrayList;
import java.util.List;

import testeexportarcomgradlew.beans.Casa;

public class CasaDao {

	private static List<Casa> casas = new ArrayList<Casa>();

	public void cadastrar(Casa c) {
		casas.add(c);
	}

	public List<Casa> pesquisar() {
		return casas;
	}

	public void remover(Casa c) {
		casas.remove(c);
	}
}
