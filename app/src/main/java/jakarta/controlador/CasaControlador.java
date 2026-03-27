package jakarta.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.beans.Casa;
import jakarta.beans.Condominio;
import jakarta.dao.CasaDao;
import jakarta.dao.CondominioDao;
import jakarta.enterprise.context.SessionScoped;
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

	public void excluir(Casa c) {
		CasaDao dao = new CasaDao();
		dao.remover(c);
		casas = dao.pesquisar();
	}

	public String prepararTelaConsulta() {
		CasaDao dao = new CasaDao();
		casas = dao.pesquisar();
		return "consultarcasa.xhtml";
	}

	public String voltar() {
		return "menuprincipal.xhtml";
	}

	public String prepararTelaCadastro() {
		novaCasa = new Casa();
		condominios = new CondominioDao().pesquisar();
		return "cadastrarcasa.xhtml";
	}

	public String gravar() {
		if (!validarDados()) {
			return null;
		}
		CasaDao dao = new CasaDao();
		Condominio c = new CondominioDao().getCondominio(idSelecionadoCondominio);
		novaCasa.setCondominio(c);
		dao.cadastrar(novaCasa);
		new Util().adicionarMensagem("Casa cadastrada com sucesso");
		return "menuprincipal.xhtml";
	}

	private boolean validarDados() {
		CasaDao dao = new CasaDao();
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
