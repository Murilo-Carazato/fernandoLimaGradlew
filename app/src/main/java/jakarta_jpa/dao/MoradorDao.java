package jakarta_jpa.dao;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
import jakarta.enterprise.context.Dependent;
import jakarta_jpa.beans.Morador;

@Dependent
public class MoradorDao implements Serializable {
	private static final long serialVersionUID = 1L;

	private static List<Morador> moradores = new ArrayList<Morador>();

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
