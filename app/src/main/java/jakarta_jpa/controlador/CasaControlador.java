package jakarta_jpa.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta_jpa.beans.Casa;
import jakarta_jpa.beans.Condominio;
import jakarta_jpa.dao.CasaDao;
import jakarta_jpa.dao.CondominioDao;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta_jpa.uteis.Util;

@SessionScoped
@Named
public class CasaControlador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Casa novaCasa;
	private List<Casa> casas;
	private List<Condominio> condominios;
	private Integer idSelecionadoCondominio;
	
	@Inject
	private CasaDao dao;
	
	@Inject
	private CondominioDao daoCondominio;
	
	public void excluir(Casa c) {
		dao.remover(c);
		casas = dao.pesquisar();
	}

	public String prepararTelaConsulta() {
		casas = dao.pesquisar();
		return "consultarcasa.xhtml";
	}

	public String voltar() {
		return "menuprincipal.xhtml";
	}

	public boolean isMostrarPainel() {
		return casas != null && casas.size() > 0;
	}

	public String prepararTelaCadastro() {
		novaCasa = new Casa();
		condominios = daoCondominio.pesquisar();
		return "cadastrarcasa.xhtml";
	}

	public String gravar() {
		if (!validarDados()) {
			return null;
		}
		Condominio c = daoCondominio.getCondominio(idSelecionadoCondominio);
		novaCasa.setCondominio(c);
		dao.cadastrar(novaCasa);
		new Util().adicionarMensagem("Casa cadastrada com sucesso");
		return "menuprincipal.xhtml";
	}

	private boolean validarDados() {
		if (dao.existe(novaCasa)) {
			new Util().adicionarMensagem("Casa existente!");
			return false;
		}
		return true;
	}

	public Casa getNovaCasa() {
		return novaCasa;
	}

	public void setNovaCasa(Casa novaCasa) {
		this.novaCasa = novaCasa;
	}

	public List<Casa> getCasas() {
		return casas;
	}

	public void setCasas(List<Casa> casas) {
		this.casas = casas;
	}

	public List<Condominio> getCondominios() {
		return condominios;
	}

	public void setCondominios(List<Condominio> condominios) {
		this.condominios = condominios;
	}

	public Integer getIdSelecionadoCondominio() {
		return idSelecionadoCondominio;
	}

	public void setIdSelecionadoCondominio(Integer idSelecionadoCondominio) {
		this.idSelecionadoCondominio = idSelecionadoCondominio;
	}

}
