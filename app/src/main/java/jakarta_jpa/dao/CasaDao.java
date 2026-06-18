package jakarta_jpa.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta_jpa.beans.Casa;
import jakarta.enterprise.context.Dependent;

@Dependent
public class CasaDao implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private static List<Casa> casas = new ArrayList<Casa>();

	public boolean existe(Casa c) {
		return casas.contains(c);
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
