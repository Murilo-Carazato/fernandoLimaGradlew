package jakarta.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.beans.Morador;

public class MoradorDao {

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
