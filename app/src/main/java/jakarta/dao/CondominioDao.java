package jakarta.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.beans.Condominio;
import jakarta.enterprise.context.Dependent;

@Dependent
public class CondominioDao implements Serializable {

	private static final long serialVersionUID = 1L;

	private static List<Condominio> condominios = new ArrayList<Condominio>();

	public boolean existe(Condominio r) {
		return condominios.contains(r);
	}

	public Condominio getCondominio(Integer id) {
		for (Condominio r : condominios) {
			if (r.getId().equals(id)) {
				return r;
			}
		}
		return null;
	}

	public void cadastrar(Condominio r) {
		condominios.add(r);
	}

	public List<Condominio> pesquisar() {
		return condominios;
	}

	public void remover(Condominio r) {
		condominios.remove(r);
	}
}
