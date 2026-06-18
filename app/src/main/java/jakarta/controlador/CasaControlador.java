package jakarta.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.beans.Casa;
import jakarta.beans.Condominio;
import jakarta.dao.CasaDao;
import jakarta.dao.CondominioDao;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.uteis.Util;

@SessionScoped
@Named
public class CasaControlador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Casa novaCasa;
	private List<Casa> casas;
	private List<Condominio> condominios;
	private Integer idSelecionadoCondominio;
	private String mensagemCondominio;

	@Inject
	private CasaDao dao;

	@Inject
	private CondominioDao daoCondominio;

	public void selecionarCondominio(AjaxBehaviorEvent a) {
		Condominio p = daoCondominio.getCondominio(idSelecionadoCondominio);
		mensagemCondominio = "Condomínio: " + (p != null ? p.getNome() : "");
	}

	public void excluir(Casa f) {
		dao.remover(f);
		casas = dao.pesquisar();
	}

	public String prepararTelaConsulta() {
		casas = dao.pesquisar();
		return "consultarcasa.xhtml";
	}

	public String voltar() {
		return "menuprincipal.xhtml";
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
		Condominio r = daoCondominio.getCondominio(idSelecionadoCondominio);
		novaCasa.setCondominio(r);
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

	public String getMensagemCondominio() {
		return mensagemCondominio;
	}

	public void setMensagemCondominio(String mensagemCondominio) {
		this.mensagemCondominio = mensagemCondominio;
	}

	public boolean isMostrarPainel() {
		return casas != null && casas.size() > 0;
	}

}
