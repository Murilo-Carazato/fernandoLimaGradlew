package jakarta.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.beans.Condominio;

public class CondominioDao {

	private static List<Condominio> condominios = new ArrayList<Condominio>();

	public boolean existe(Condominio c) {
		return condominios.contains(c);
	}

	public Condominio getCondominio(Integer id) {
		for (Condominio c : condominios) {
			if (c.getCodigo().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public void cadastrar(Condominio c) {
		condominios.add(c);
	}

	public List<Condominio> pesquisar() {
		return condominios;
	}

	public void remover(Condominio c) {
		condominios.remove(c);
	}
}
