package jakarta.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.beans.Casa;

public class CasaDao {

	private static List<Casa> casas = new ArrayList<Casa>();

	public boolean existe(Casa c) {
		return casas.contains(c);
	}

	public Casa getCasa(Integer id) {
		for (Casa c : casas) {
			if (c.getCodigo().equals(id)) {
				return c;
			}
		}
		return null;
	}

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
