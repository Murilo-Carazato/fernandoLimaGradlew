package jakarta.dao;

import java.util.ArrayList;
import java.util.List;

import testeexportarcomgradlew.beans.Condominio;

public class CondominioDao {

	private static List<Condominio> condominios = new ArrayList<Condominio>();

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
