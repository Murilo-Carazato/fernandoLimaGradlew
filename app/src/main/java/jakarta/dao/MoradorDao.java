package jakarta.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.beans.Morador;
import jakarta.enterprise.context.Dependent;

@Dependent
public class MoradorDao implements Serializable {

	private static final long serialVersionUID = 1L;

	private static List<Morador> moradors = new ArrayList<Morador>();

	public boolean existe(Morador esp) {
		return moradors.contains(esp);
	}

	public void cadastrar(Morador esp) {
		moradors.add(esp);
	}

	public List<Morador> pesquisar() {
		return moradors;
	}

	public void remover(Morador esp) {
		moradors.remove(esp);
	}
}
