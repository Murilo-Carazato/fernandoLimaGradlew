package jakarta.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.beans.Condominio;
import jakarta.dao.CondominioDao;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.uteis.Util;

@SessionScoped
@Named
public class CondominioControlador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Condominio novoCondominio;
	private List<Condominio> condominios;

	@Inject
	private CondominioDao dao;

	public void excluir(Condominio r) {
		dao.remover(r);
		condominios = dao.pesquisar();
	}

	public String prepararTelaConsulta() {
		this.condominios = dao.pesquisar();
		return "consultarcondominio.xhtml";
	}

	public String voltar() {
		return "menuprincipal.xhtml";
	}

	public String prepararTelaCadastro() {
		novoCondominio = new Condominio();
		return "cadastrarcondominio.xhtml";
	}

	public String gravar() {
		if (!validarDados()) {
			return null;
		}
		dao.cadastrar(novoCondominio);
		new Util().adicionarMensagem("Condominio cadastrado com sucesso");
		return "menuprincipal.xhtml";
	}

	private boolean validarDados() {
		if (dao.existe(novoCondominio)) {
			new Util().adicionarMensagem("Condominio existente!");
			return false;
		}
		return true;
	}

	public Condominio getNovoCondominio() {
		return novoCondominio;
	}

	public void setNovoCondominio(Condominio novoCondominio) {
		this.novoCondominio = novoCondominio;
	}

	public List<Condominio> getCondominios() {
		return condominios;
	}

	public boolean getExibirTitulo() {
		return condominios != null && !condominios.isEmpty();
	}

	public void setCondominios(List<Condominio> condominios) {
		this.condominios = condominios;
	}
}
