package jakarta.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.beans.Morador;
import jakarta.dao.MoradorDao;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.uteis.Util;

@SessionScoped
@Named
public class MoradorControlador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Morador novoMorador;
	private List<Morador> moradores;

	public void excluir(Morador m) {
		MoradorDao dao = new MoradorDao();
		dao.remover(m);
		moradores = dao.pesquisar();
	}

	public String prepararTelaConsulta() {
		MoradorDao dao = new MoradorDao();
		moradores = dao.pesquisar();
		return "consultarmorador.xhtml";
	}

	public String voltar() {
		return "menuprincipal.xhtml";
	}

	public String prepararTelaCadastro() {
		novoMorador = new Morador();
		return "cadastrarmorador.xhtml";
	}

	public String gravar() {
		if (!validarDados()) {
			return null;
		}
		MoradorDao dao = new MoradorDao();
		dao.cadastrar(novoMorador);
		new Util().adicionarMensagem("Morador cadastrado com sucesso");
		return "menuprincipal.xhtml";
	}

	private boolean validarDados() {
		MoradorDao dao = new MoradorDao();
		if (dao.existe(novoMorador)) {
			new Util().adicionarMensagem("Morador existente!");
			return false;
		}
		return true;
	}

	public Morador getNovoMorador() {
		return novoMorador;
	}

	public void setNovoMorador(Morador novoMorador) {
		this.novoMorador = novoMorador;
	}

	public List<Morador> getMoradores() {
		return moradores;
	}

	public void setMoradores(List<Morador> moradores) {
		this.moradores = moradores;
	}
}
