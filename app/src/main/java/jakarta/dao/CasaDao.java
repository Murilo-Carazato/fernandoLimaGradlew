package jakarta.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.beans.Casa;

public class CasaDao {

	private static List<Casa> casas = new ArrayList<Casa>();

	public boolean existe(Casa f) {
		return casas.contains(f);
	}

	public void cadastrar(Casa f) {
		casas.add(f);
	}

	public List<Casa> pesquisar() {
		return casas;
	}

	public void remover(Casa f) {
		casas.remove(f);
	}
}
