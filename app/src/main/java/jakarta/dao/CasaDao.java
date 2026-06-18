package jakarta.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.beans.Casa;
import jakarta.enterprise.context.Dependent;

@Dependent
public class CasaDao implements Serializable {

	private static final long serialVersionUID = 1L;

	private static List<Casa> casas = new ArrayList<Casa>();

	public Casa getCasa(Integer id) {
		for (Casa r : casas) {
			if (r.getId().equals(id)) {
				return r;
			}
		}
		return null;
	}

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
