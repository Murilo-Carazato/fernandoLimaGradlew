package jakarta.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.beans.Morador;
import jakarta.beans.Casa;
import jakarta.dao.MoradorDao;
import jakarta.dao.CasaDao;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.uteis.Util;

@SessionScoped
@Named
public class MoradorControlador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Morador novaMorador;
	private List<Morador> moradors;
	private List<Casa> casas;
	private Integer idSelecionadoCasa;
	private String mensagemCasa;

	@Inject
	private MoradorDao dao;

	@Inject
	private CasaDao daoCasa;

	public void selecionarCasa(AjaxBehaviorEvent a) {
		Casa c = daoCasa.getCasa(idSelecionadoCasa);
		mensagemCasa = "Casa: " + (c != null ? c.getNome() : "");
	}

	public void excluir(Morador e) {
		dao.remover(e);
		moradors = dao.pesquisar();
	}

	public String prepararTelaConsulta() {
		moradors = dao.pesquisar();
		return "consultarmorador.xhtml";
	}

	public String voltar() {
		return "menuprincipal.xhtml";
	}

	public String prepararTelaCadastro() {
		novaMorador = new Morador();
		casas = daoCasa.pesquisar();
		return "cadastrarmorador.xhtml";
	}

	public String gravar() {
		if (!validarDados()) {
			return null;
		}
		Casa f = daoCasa.getCasa(idSelecionadoCasa);
		novaMorador.setCasa(f);
		dao.cadastrar(novaMorador);
		new Util().adicionarMensagem("Morador cadastrado com sucesso");
		return "menuprincipal.xhtml";
	}

	private boolean validarDados() {
		if (dao.existe(novaMorador)) {
			new Util().adicionarMensagem("Morador existente!");
			return false;
		}
		return true;
	}

	public Morador getNovaMorador() {
		return novaMorador;
	}

	public void setNovaMorador(Morador novaMorador) {
		this.novaMorador = novaMorador;
	}

	public List<Morador> getMoradors() {
		return moradors;
	}

	public void setMoradors(List<Morador> moradors) {
		this.moradors = moradors;
	}

	public List<Casa> getCasas() {
		return casas;
	}

	public void setCasas(List<Casa> casas) {
		this.casas = casas;
	}

	public Integer getIdSelecionadoCasa() {
		return idSelecionadoCasa;
	}

	public void setIdSelecionadoCasa(Integer idSelecionadoCasa) {
		this.idSelecionadoCasa = idSelecionadoCasa;
	}

	public String getMensagemCasa() {
		return mensagemCasa;
	}

	public void setMensagemCasa(String mensagemCasa) {
		this.mensagemCasa = mensagemCasa;
	}

	public boolean isMostrarPainel() {
		return moradors != null && moradors.size() > 0;
	}

}
