package jakarta_jpa.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta_jpa.beans.Condominio;
import jakarta_jpa.dao.CondominioDao;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import jakarta_jpa.uteis.Util;

@SessionScoped
@Named
@Transactional
public class CondominioControlador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Condominio novoCondominio;
	private List<Condominio> condominios;

	@Inject
	private CondominioDao dao;
	
	public void excluir(Integer id) {
		Condominio c = dao.getCondominio(id);
		dao.remover(c);
		condominios = dao.pesquisar();
	}

	public boolean isMostrarDataTable() {
		return condominios != null && condominios.size() > 0;
	}

	public boolean isMostrarTitulo() {
		return condominios == null || condominios.size() == 0;
	}

	public String prepararTelaConsulta() {
		condominios = dao.pesquisar();
		return "consultarcondominio.xhtml";
	}

	public String voltar() {
		return "menuprincipal.xhtml";
	}

	public String prepararTelaCadastro() {
		novoCondominio = new Condominio();
		// In the professor's code there was novoPais.setMembroOtan("s"); we skip it since Condominio has no such field.
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

	public void setCondominios(List<Condominio> condominios) {
		this.condominios = condominios;
	}
}
