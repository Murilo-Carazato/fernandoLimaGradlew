package jakarta.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import testeexportarcomgradlew.beans.Condominio;
import jakarta.dao.CondominioDao;

@SessionScoped
@Named
public class CondominioControlador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Condominio condominio = new Condominio();
	
	private CondominioDao condominioDao = new CondominioDao();

	public String prepararTelaCadastro() {
		return "cadastrarcondominio.xhtml";
	}

	public void salvar() {
		condominioDao.cadastrar(condominio);
		condominio = new Condominio(); // reset the form
	}

	public void excluir(Condominio c) {
		condominioDao.remover(c);
	}

	public List<Condominio> getListaCondominios() {
		return condominioDao.pesquisar();
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
}
