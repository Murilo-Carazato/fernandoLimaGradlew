package jakarta.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.beans.Morador;

public class MoradorDao {

	private static List<Morador> moradores = new ArrayList<Morador>();

	public boolean existe(Morador m) {
		return moradores.contains(m);
	}

	public void cadastrar(Morador m) {
		moradores.add(m);
	}

	public List<Morador> pesquisar() {
		return moradores;
	}

	public void remover(Morador m) {
		moradores.remove(m);
	}
}
